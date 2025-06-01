package model;

import java.util.Date;
import java.util.List;

public class Pedido {

    private Integer id;
    private String horaPedido;
    private int numeroPedido;
    private Date dataPedido;
    private Cliente cliente;
    private List<Carrinho> carrinhos;
    private StatusPedido statusPedido;

    public Pedido() {
    }

    public Pedido(Integer id, String horaPedido, int numeroPedido, Date dataPedido, Cliente cliente, List<Carrinho> carrinhos, StatusPedido statusPedido) {
        this.id = id;
        this.horaPedido = horaPedido;
        this.numeroPedido = numeroPedido;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.carrinhos = carrinhos;
        this.statusPedido = statusPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", horaPedido=" + horaPedido + ", numeroPedido=" + numeroPedido + ", dataPedido=" + dataPedido + ", cliente=" + cliente + ", carrinhos=" + carrinhos + ", statusPedido=" + statusPedido + '}';
    }

}
