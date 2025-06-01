package model;

public class Delivery {

    private Integer id;
    private String chaveEntrega;
    private int numero;
    private String complemento;
    private Endereco endereco;

    public Delivery() {
    }

    public Delivery(Integer id, String chaveEntrega, int numero, String complemento, Endereco endereco) {
        this.id = id;
        this.chaveEntrega = chaveEntrega;
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChaveEntrega() {
        return chaveEntrega;
    }

    public void setChaveEntrega(String chaveEntrega) {
        this.chaveEntrega = chaveEntrega;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Delivery{" + "id=" + id + ", chaveEntrega=" + chaveEntrega + ", numero=" + numero + ", complemento=" + complemento + ", endereco=" + endereco + '}';
    }

}
