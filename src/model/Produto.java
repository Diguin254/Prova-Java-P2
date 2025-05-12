package model;

import java.util.List;

public class Produto {

    private Integer id;
    private String nome;
    private double valorUnitario;
    private List<Carrinho> carrinhos;

    public Produto() {
    }

    public Produto(Integer id, String nome, double valorUnitario, List<Carrinho> carrinhos) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.carrinhos = carrinhos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

}
