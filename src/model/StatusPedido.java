package model;

public class StatusPedido {

    private Integer id;
    private String progresso;
    private Pedido pedido;

    public StatusPedido() {
    }

    public StatusPedido(Integer id, String progresso, Pedido pedido) {
        this.id = id;
        this.progresso = progresso;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProgresso() {
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
