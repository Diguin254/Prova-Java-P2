package dto;

import model.Cartao;

public class CartaoDTO implements InterfaceDTO{

    public CartaoDTO() {
    }

    public String idCartao;
    public String nCartao;
    public String codCartao;
    public String tipoCartao;

    public String getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(String idCartao) {
        this.idCartao = idCartao;
    }

    public String getnCartao() {
        return nCartao;
    }

    public void setnCartao(String nCartao) {
        this.nCartao = nCartao;
    }

    public String getCodCartao() {
        return codCartao;
    }

    public void setCodCartao(String codCartao) {
        this.codCartao = codCartao;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    
    
    public Cartao builder() {
        Cartao c = new Cartao();
        c.setId(idCartao == null ? 0 : Integer.valueOf(idCartao));
        c.setNumeroCartao(idCartao == null ? 0 : Integer.valueOf(nCartao));
        c.setCcv(codCartao == null ? 0 : Integer.valueOf(codCartao));
        c.setTipoConta(tipoCartao == null ? 0 : Integer.valueOf(tipoCartao));

        return c;
    }

    @Override
    public String toString() {
        return "CartaoDTO{" + "idCartao=" + idCartao + ", nCartao=" + nCartao + ", codCartao=" + codCartao + ", tipoCartao=" + tipoCartao + '}';
    }
    
    @Override
    public int getId() {
        return (idCartao == null || idCartao.isBlank()) ? 0 : Integer.parseInt(idCartao);
    }

    @Override
    public void setId(int id) {
        this.idCartao = String.valueOf(id);
    }
}
