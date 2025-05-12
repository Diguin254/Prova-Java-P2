package model;

public class TaxaEntrega {

    private Integer id;
    private double taxa_entrega;
    private Endereco endereco;

    public TaxaEntrega() {
    }

    public TaxaEntrega(Integer id, double taxa_entrega, Endereco endereco) {
        this.id = id;
        this.taxa_entrega = taxa_entrega;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTaxa_entrega() {
        return taxa_entrega;
    }

    public void setTaxa_entrega(double taxa_entrega) {
        this.taxa_entrega = taxa_entrega;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
