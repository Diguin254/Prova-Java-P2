package dto;

import model.Cartao;
import model.Dinheiro;
import model.MetodoPagamento;

public class MetodoPagamentoDTO {

    public MetodoPagamentoDTO() {
    }

    public String idMetodoP;
    public String pixPag;
    public String idDinheiroP;
    public String idCartaoP;

    public MetodoPagamento builder() {
        MetodoPagamento mp = new MetodoPagamento();
        mp.setId(idMetodoP == null ? 0 : Integer.valueOf(idMetodoP));
        mp.setPix(pixPag == null ? "" : pixPag);

        Dinheiro d = new Dinheiro();
        d.setId(idDinheiroP == null ? 0 : Integer.valueOf(idDinheiroP));
        mp.setDinheiro(d);

        Cartao c = new Cartao();
        c.setId(idCartaoP == null ? 0 : Integer.valueOf(idCartaoP));
        mp.setCartao(c);

        return mp;
    }
}
