public class CadastroPessoas {
    private Pessoa[] pessoas;
    private int QuantidadeAtual;

    public CadastroPessoas(int capacidade) {
        pessoas = new Pessoa[capacidade];
        QuantidadeAtual = 0;
    }

    public void cadastraPessoa(Pessoa pessoa) {
        if (QuantidadeAtual < pessoas.length) {
            pessoas[QuantidadeAtual] = pessoa;
            QuantidadeAtual++;
        } else {
            System.out.println("Cadastro cheio.");
        }
    }

    public void imprimeCadastro() {
        for (int i = 0; i < QuantidadeAtual; i++) {
            pessoas[i].imprimeDados();
        }
    }
}