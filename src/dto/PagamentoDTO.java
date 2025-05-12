package dto;

import model.Cupom;
import model.MetodoPagamento;
import model.Pagamento;
import model.Pedido;

public class PagamentoDTO {

    public PagamentoDTO() {
    }

    public String idPag;
    public String idMetPag;
    public String idCupomP;
    public String idPedidoP;

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
}
