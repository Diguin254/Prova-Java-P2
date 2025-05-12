package model;

public class Reembolso {

    private Integer id;
    private String motivo;
    private Pedido pedido;

    public Reembolso() {
    }

    public Reembolso(Integer id, String motivo, Pedido pedido) {
        this.id = id;
        this.motivo = motivo;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
