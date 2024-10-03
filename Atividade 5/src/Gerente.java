public class Gerente extends Funcionario{
    private String area;

    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }

    @Override
    public float calculaImposto(){
        return salario * 0.05f;
    }

    @Override
    public void imprimeDados(){
        System.out.println("Gerente: " + getNome() + ", Nascimento: " + getNascimento() + ", Area: " + area
                + ", Salario: " + salario + ", Imposto: " + calculaImposto());
    }
}
