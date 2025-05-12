package dto;

import model.Cartao;

public class CartaoDTO {

    public CartaoDTO() {
    }

    public String idCartao;
    public String nCartao;
    public String codCartao;
    public String tipoCartao;

    public Cartao builder() {
        Cartao c = new Cartao();
        c.setId(idCartao == null ? 0 : Integer.valueOf(idCartao));
        c.setNumeroCartao(idCartao == null ? 0 : Integer.valueOf(nCartao));
        c.setCcv(codCartao == null ? 0 : Integer.valueOf(codCartao));
        c.setTipoConta(tipoCartao == null ? 0 : Integer.valueOf(tipoCartao));

        return c;
    }
}
