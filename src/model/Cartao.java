
package model;

public class Cartao {
    private Integer id;
    private int numeroCartao;
    private int ccv;
    private int tipoConta;

    public Cartao() {
    }

    public Cartao(Integer id, int numeroCartao, int ccv, int tipoConta) {
        this.id = id;
        this.numeroCartao = numeroCartao;
        this.ccv = ccv;
        this.tipoConta = tipoConta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }
    
   
}
