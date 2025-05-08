package model;

public class Carrinho {

    private Integer id;
    private int qntd;
    private Pedido pedido;
    private Produto produto;
    private IngredienteEscolha ingredienteEscolha;

    public Carrinho() {
    }

    public Carrinho(Integer id, int qntd, Pedido pedido, Produto produto, IngredienteEscolha ingredienteEscolha) {
        this.id = id;
        this.qntd = qntd;
        this.pedido = pedido;
        this.produto = produto;
        this.ingredienteEscolha = ingredienteEscolha;
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

    public IngredienteEscolha getIngredienteEscolha() {
        return ingredienteEscolha;
    }

    public void setIngredienteEscolha(IngredienteEscolha ingredienteEscolha) {
        this.ingredienteEscolha = ingredienteEscolha;
    }

}
