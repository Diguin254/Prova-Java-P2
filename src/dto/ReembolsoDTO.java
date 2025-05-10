package dto;

import model.Pedido;
import model.Reembolso;

public class ReembolsoDTO {

    public ReembolsoDTO() {
    }

    public String idReemb;
    public String motivoReemb;
    public String idPedidoR;

    public Reembolso builder() {
        Reembolso r = new Reembolso();
        r.setId(idReemb == null ? 0 : Integer.valueOf(idReemb));
        r.setMotivo(motivoReemb == null ? "" : motivoReemb);

        Pedido p = new Pedido();
        p.setId(idPedidoR == null ? 0 : Integer.valueOf(idPedidoR));
        r.setPedido(p);

        return r;
    }
}
