import java.util.Scanner;

public class TestaCadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroPessoas cadastro = new CadastroPessoas(10);

        cadastraPessoa(scanner, cadastro, "Cliente");
        cadastraPessoa(scanner, cadastro, "Funcionario");
        cadastraPessoa(scanner, cadastro, "Gerente");

        cadastro.imprimeCadastro();
        scanner.close();
    }

    private static void cadastraPessoa(Scanner scanner, CadastroPessoas cadastro, String tipoPessoa) {
        System.out.println("\nCadastro de " + tipoPessoa);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (dd mm aaaa): ");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();
        Data data = new Data(dia, mes, ano);

        if (tipoPessoa.equals("Cliente")) {
            System.out.print("Codigo: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();
            Cliente cliente = new Cliente(nome, data, codigo);
            cadastro.cadastraPessoa(cliente);
        } else if (tipoPessoa.equals("Funcionario")) {
            System.out.print("Salario: ");
            float salario = scanner.nextFloat();
            scanner.nextLine();
            Funcionario funcionario = new Funcionario(nome, data, salario);
            cadastro.cadastraPessoa(funcionario);
        } else if (tipoPessoa.equals("Gerente")) {
            System.out.print("Salario: ");
            float salario = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Area: ");
            String area = scanner.nextLine();
            Gerente gerente = new Gerente(nome, data, salario, area);
            cadastro.cadastraPessoa(gerente);
        }
    }
}
