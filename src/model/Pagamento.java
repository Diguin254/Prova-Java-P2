package model;

public class Pagamento {

    private Integer id;
    private MetodoPagamento metodoPagamento;
    private Cupom cupom;
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer id, MetodoPagamento metodoPagamento, Cupom cupom, Pedido pedido) {
        this.id = id;
        this.metodoPagamento = metodoPagamento;
        this.cupom = cupom;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Cupom getCupom() {
        return cupom;
    }

    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", metodoPagamento=" + metodoPagamento + ", cupom=" + cupom + ", pedido=" + pedido + '}';
    }

}
