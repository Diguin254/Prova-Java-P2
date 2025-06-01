package model;

public class Dinheiro {

    private Integer id;
    private double valorEntregado;

    public Dinheiro() {
    }

    public Dinheiro(Integer id, double valorEntregado) {
        this.id = id;
        this.valorEntregado = valorEntregado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorEntregado() {
        return valorEntregado;
    }

    public void setValorEntregado(double valorEntregado) {
        this.valorEntregado = valorEntregado;
    }

    @Override
    public String toString() {
        return "Dinheiro{" + "id=" + id + ", valorEntregado=" + valorEntregado + '}';
    }
    
}
