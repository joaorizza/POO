import java.util.ArrayList;
import java.util.List;

public class PessoaService {
    private static final int MAX_FUNCIONARIOS = 7;
    private static final int MAX_GERENTE = 1;
    private List<Pessoa> pessoas;
    private int numGerentes = 0;
    private int numFuncionarios = 0;

    public PessoaService() {
        pessoas = new ArrayList<>();
    }

    public void cadastraPessoa(Pessoa pessoa) throws QuantidadeExcedidaException {
        if (pessoa instanceof Gerente) {
            if (numGerentes >= MAX_GERENTE) {
                throw new QuantidadeExcedidaException("Vaga para gerente excedida.");
            }
            numGerentes++;
        } else if (pessoa instanceof Funcionario) {
            if (numFuncionarios >= MAX_FUNCIONARIOS) {
                throw new QuantidadeExcedidaException("Vaga para funcionários excedida.");
            }
            numFuncionarios++;
        }
        pessoas.add(pessoa);
    }

    public void imprimeCadastro() {
        for (Pessoa pessoa : pessoas) {
            pessoa.imprimeDados();
        }
    }
}
