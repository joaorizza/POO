public class TestaCadastro {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas();

        Cliente cliente = new Cliente("João", new Data(5, 12, 1999), 123);
        cadastro.cadastraPessoa(cliente);

        Funcionario funcionario = new Funcionario("Isabela", new Data(4, 10, 1997), 3000);
        cadastro.cadastraPessoa(funcionario);

        Gerente gerente = new Gerente("Pedro", new Data(8, 8, 1971), 8000, "TI");
        cadastro.cadastraPessoa(gerente);

        cadastro.imprimeCadastro();
    }
}
