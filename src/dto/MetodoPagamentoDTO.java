package dto;

import model.Cartao;
import model.Dinheiro;
import model.MetodoPagamento;

public class MetodoPagamentoDTO implements InterfaceDTO{

    public MetodoPagamentoDTO() {
    }

    public String idMetodoP;
    public String pixPag;
    public String idDinheiroP;
    public String idCartaoP;

    public String getIdMetodoP() {
        return idMetodoP;
    }

    public void setIdMetodoP(String idMetodoP) {
        this.idMetodoP = idMetodoP;
    }

    public String getPixPag() {
        return pixPag;
    }

    public void setPixPag(String pixPag) {
        this.pixPag = pixPag;
    }

    public String getIdDinheiroP() {
        return idDinheiroP;
    }

    public void setIdDinheiroP(String idDinheiroP) {
        this.idDinheiroP = idDinheiroP;
    }

    public String getIdCartaoP() {
        return idCartaoP;
    }

    public void setIdCartaoP(String idCartaoP) {
        this.idCartaoP = idCartaoP;
    }

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

    @Override
    public String toString() {
        return "MetodoPagamentoDTO{" + "idMetodoP=" + idMetodoP + ", pixPag=" + pixPag + ", idDinheiroP=" + idDinheiroP + ", idCartaoP=" + idCartaoP + '}';
    }
    
    
}
