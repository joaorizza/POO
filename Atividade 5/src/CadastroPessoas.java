import java.util.Scanner;

public class CadastroPessoas {

    public CadastroPessoas(int i) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaService pessoaService = new PessoaService();  // Usando pessoaService

        try {
            cadastraPessoa(scanner, pessoaService, "Cliente");
            cadastraPessoa(scanner, pessoaService, "Funcionario");
            cadastraPessoa(scanner, pessoaService, "Gerente");
            cadastraPessoa(scanner, pessoaService, "ClienteVip");

            pessoaService.imprimeCadastro();  // Corrigir para usar pessoaService
        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    private static void cadastraPessoa(Scanner scanner, PessoaService pessoaService, String tipoPessoa) throws QuantidadeExcedidaException {
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
            pessoaService.cadastraPessoa(cliente);  // Corrigir para pessoaService
        } else if (tipoPessoa.equals("Funcionario")) {
            System.out.print("Salario: ");
            float salario = scanner.nextFloat();
            scanner.nextLine();
            Funcionario funcionario = new Funcionario(nome, data, salario);
            pessoaService.cadastraPessoa(funcionario);  // Corrigir para pessoaService
        } else if (tipoPessoa.equals("Gerente")) {
            System.out.print("Salario: ");
            float salario = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Area: ");
            String area = scanner.nextLine();
            Gerente gerente = new Gerente(nome, data, salario, area);
            pessoaService.cadastraPessoa(gerente);  // Corrigir para pessoaService
        } else if (tipoPessoa.equals("ClienteVip")) {
            System.out.print("Codigo: ");
            int codigo = scanner.nextInt();
            System.out.print("Desconto (%): ");
            double desconto = scanner.nextDouble();
            scanner.nextLine();
            ClienteVip clienteVip = new ClienteVip(nome, data, codigo, desconto);
            pessoaService.cadastraPessoa(clienteVip);  // Corrigir para pessoaService
        }
    }
}
