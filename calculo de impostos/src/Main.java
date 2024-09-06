class Item {
    protected String descricao;
    protected double valor;

    public Item(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}

class Produto extends Item {
    public Produto(String descricao, double valor) {
        super(descricao, valor);
    }
}

class Servico extends Item {
    public Servico(String descricao, double valor) {
        super(descricao, valor);
    }
}

interface Imposto {
    double calcular(Item item);
}

class ISS implements Imposto {
    private static final double ALIQUOTA = 0.073;

    @Override
    public double calcular(Item item) {
        if (item instanceof Servico) {
            return item.getValor() * ALIQUOTA;
        }
        return 0;
    }
}

class ICMS implements Imposto {
    private static final double ALIQUOTA = 0.132;

    @Override
    public double calcular(Item item) {
        return item.getValor() * ALIQUOTA;
    }
}

class IPI implements Imposto {
    private static final double ALIQUOTA = 0.219;

    @Override
    public double calcular(Item item) {
        if (item instanceof Produto) {
            return item.getValor() * ALIQUOTA;
        }
        return 0;
    }
}

class OperacaoComercial {
    private Item item;
    private double valorTotal;
    private double iss;
    private double icms;
    private double ipi;

    public OperacaoComercial(Item item) {
        this.item = item;
        this.iss = new ISS().calcular(item);
        this.icms = new ICMS().calcular(item);
        this.ipi = new IPI().calcular(item);
        this.valorTotal = item.getValor() + iss + icms + ipi;
    }

    public void detalharOperacao() {
        System.out.println("Item: " + item.getDescricao());
        System.out.println("Preço original: R$ " + item.getValor());
        if (iss > 0) {
            System.out.println("ISS: R$ " + iss);
        }
        if (icms > 0) {
            System.out.println("ICMS: R$ " + icms);
        }
        if (ipi > 0) {
            System.out.println("IPI: R$ " + ipi);
        }
        System.out.println("Valor total: R$ " + valorTotal);
    }
}

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto("Notebook", 2500.00);
        Servico servico = new Servico("Consultoria de TI", 1200.00);

        OperacaoComercial opProduto = new OperacaoComercial(produto);
        OperacaoComercial opServico = new OperacaoComercial(servico);

        System.out.println("Detalhes da operação de produto:");
        opProduto.detalharOperacao();
        System.out.println();

        System.out.println("Detalhes da operação de serviço:");
        opServico.detalharOperacao();
    }
}
