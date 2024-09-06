import java.util.Scanner;

class BombaCombustivel {
    private String tipoCombustivel;
    private double valorLitro;
    private double quantidadeCombustivel;
    private double totalAbastecido;

    public BombaCombustivel(String tipoCombustivel, double valorLitro, double quantidadeCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
        this.valorLitro = valorLitro;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.totalAbastecido = 0;
    }

    public void abastecerPorValor(double valor) {
        double litros = valor / valorLitro;
        if (litros <= quantidadeCombustivel) {
            quantidadeCombustivel -= litros;
            totalAbastecido += valor;
            System.out.printf("Você abasteceu %.2f litros de %s%n", litros, tipoCombustivel);
        } else {
            System.out.println("Não há combustível suficiente na bomba.");
        }
    }

    public void abastecerPorLitro(double litros) {
        if (litros <= quantidadeCombustivel) {
            double valor = litros * valorLitro;
            quantidadeCombustivel -= litros;
            totalAbastecido += valor;
            System.out.printf("Você pagará R$%.2f por %.2f litros de %s%n", valor, litros, tipoCombustivel);
        } else {
            System.out.println("Não há combustível suficiente na bomba.");
        }
    }

    public void alterarValor(double novoValor) {
        valorLitro = novoValor;
        System.out.printf("O novo valor do litro de %s é R$%.2f%n", tipoCombustivel, valorLitro);
    }

    public void alterarCombustivel(String novoTipo) {
        tipoCombustivel = novoTipo;
        System.out.printf("O tipo de combustível foi alterado para %s%n", tipoCombustivel);
    }

    public void alterarQuantidadeCombustivel(double novaQuantidade) {
        quantidadeCombustivel = novaQuantidade;
        System.out.printf("A nova quantidade de combustível na bomba é %.2f litros%n", quantidadeCombustivel);
    }

    public void exibirTotalAbastecido() {
        System.out.printf("O total já abastecido é R$%.2f%n", totalAbastecido);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BombaCombustivel bomba = new BombaCombustivel("Gasolina", 5.49, 1000);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1 - Abastecer por valor");
            System.out.println("2 - Abastecer por litros");
            System.out.println("3 - Alterar valor do litro");
            System.out.println("4 - Alterar tipo de combustível");
            System.out.println("5 - Alterar quantidade de combustível");
            System.out.println("6 - Exibir total já abastecido");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor a ser abastecido: ");
                    double valor = scanner.nextDouble();
                    bomba.abastecerPorValor(valor);
                    break;

                case 2:
                    System.out.println("Informe a quantidade de litros a ser abastecida: ");
                    double litros = scanner.nextDouble();
                    bomba.abastecerPorLitro(litros);
                    break;

                case 3:
                    System.out.println("Informe o novo valor por litro: ");
                    double novoValor = scanner.nextDouble();
                    bomba.alterarValor(novoValor);
                    break;

                case 4:
                    System.out.println("Informe o novo tipo de combustível: ");
                    scanner.nextLine();
                    String novoTipo = scanner.nextLine();
                    bomba.alterarCombustivel(novoTipo);
                    break;

                case 5:
                    System.out.println("Informe a nova quantidade de combustível: ");
                    double novaQuantidade = scanner.nextDouble();
                    bomba.alterarQuantidadeCombustivel(novaQuantidade);
                    break;

                case 6:
                    bomba.exibirTotalAbastecido();
                    break;

                case 7:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
