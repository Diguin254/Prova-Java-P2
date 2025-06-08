package dto;

import model.Cupom;
import model.MetodoPagamento;
import model.Pagamento;
import model.Pedido;

public class PagamentoDTO implements InterfaceDTO{

    public PagamentoDTO() {
    }

    public String idPag;
    public String idMetPag;
    public String idCupomP;
    public String idPedidoP;

    public String getIdPag() {
        return idPag;
    }

    public void setIdPag(String idPag) {
        this.idPag = idPag;
    }

    public String getIdMetPag() {
        return idMetPag;
    }

    public void setIdMetPag(String idMetPag) {
        this.idMetPag = idMetPag;
    }

    public String getIdCupomP() {
        return idCupomP;
    }

    public void setIdCupomP(String idCupomP) {
        this.idCupomP = idCupomP;
    }

    public String getIdPedidoP() {
        return idPedidoP;
    }

    public void setIdPedidoP(String idPedidoP) {
        this.idPedidoP = idPedidoP;
    }

    public Pagamento builder() {
        Pagamento pag = new Pagamento();
        pag.setId(idPag == null ? 0 : Integer.valueOf(idPag));

        MetodoPagamento m = new MetodoPagamento();
        m.setId(idMetPag == null ? 0 : Integer.valueOf(idMetPag));
        pag.setMetodoPagamento(m);

        Cupom c = new Cupom();
        c.setId(idCupomP == null ? 0 : Integer.valueOf(idCupomP));
        pag.setCupom(c);

        Pedido p = new Pedido();
        p.setId(idPedidoP == null ? 0 : Integer.valueOf(idPedidoP));
        pag.setPedido(p);

        return pag;
    }

    @Override
    public String toString() {
        return "PagamentoDTO{" + "idPag=" + idPag + ", idMetPag=" + idMetPag + ", idCupomP=" + idCupomP + ", idPedidoP=" + idPedidoP + '}';
    }
    
    @Override
    public int getId() {
        return (idPag == null || idPag.isBlank()) ? 0 : Integer.parseInt(idPag);
    }

    @Override
    public void setId(int id) {
        this.idPag = String.valueOf(id);
    }
}
