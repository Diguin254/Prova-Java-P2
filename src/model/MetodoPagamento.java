package model;

public class MetodoPagamento {

    private Integer id;
    private String pix;
    private Dinheiro dinheiro;
    private Cartao cartao;

    public MetodoPagamento() {
    }

    public MetodoPagamento(Integer id, String pix, Dinheiro dinheiro, Cartao cartao) {
        this.id = id;
        this.pix = pix;
        this.dinheiro = dinheiro;
        this.cartao = cartao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public Dinheiro getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Dinheiro dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

}
