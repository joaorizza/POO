public class CadastroPessoas {
    private Pessoa[] pessoas = new Pessoa[10];
    private int qtdAtual = 0;

    public void cadastraPessoa(Pessoa pess) {
        if (qtdAtual < pessoas.length) {
            pessoas[qtdAtual] = pess;
            qtdAtual++;
        } else {
            System.out.println("Cadastro cheio!");
        }
    }

    public void imprimeCadastro() {
        for (int i = 0; i < qtdAtual; i++) {
            pessoas[i].imprimeDados();
        }
    }
}
