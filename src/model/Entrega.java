package model;

public class Entrega {

    private Integer id;
    private Cliente cliente;
    private int tipoEntrega;
    private Delivery delivery;
    private Pedido pedido;
    private StatusPedido statusPedido;

    public Entrega() {
    }

    public Entrega(Integer id, Cliente cliente, int tipoEntrega, Delivery delivery, Pedido pedido, StatusPedido statusPedido) {
        this.id = id;
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.delivery = delivery;
        this.pedido = pedido;
        this.statusPedido = statusPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(int tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    @Override
    public String toString() {
        return "Entrega{" + "id=" + id + ", cliente=" + cliente + ", tipoEntrega=" + tipoEntrega + ", delivery=" + delivery + ", pedido=" + pedido + ", statusPedido=" + statusPedido + '}';
    }

}
