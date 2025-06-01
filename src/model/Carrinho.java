package model;

public class Carrinho {

    private Integer id;
    private int qntd;
    private Pedido pedido;
    private Produto produto;

    public Carrinho() {
    }

    public Carrinho(Integer id, int qntd, Pedido pedido, Produto produto) {
        this.id = id;
        this.qntd = qntd;
        this.pedido = pedido;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Carrinho{" + "id=" + id + ", qntd=" + qntd + ", pedido=" + pedido + ", produto=" + produto + '}';
    }

}
