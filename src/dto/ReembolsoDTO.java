package dto;

import model.Pedido;
import model.Reembolso;

public class ReembolsoDTO implements InterfaceDTO{

    public ReembolsoDTO() {
    }

    public String idReemb;
    public String motivoReemb;
    public String idPedidoR;

    public String getIdReemb() {
        return idReemb;
    }

    public void setIdReemb(String idReemb) {
        this.idReemb = idReemb;
    }

    public String getMotivoReemb() {
        return motivoReemb;
    }

    public void setMotivoReemb(String motivoReemb) {
        this.motivoReemb = motivoReemb;
    }

    public String getIdPedidoR() {
        return idPedidoR;
    }

    public void setIdPedidoR(String idPedidoR) {
        this.idPedidoR = idPedidoR;
    }

    public Reembolso builder() {
        Reembolso r = new Reembolso();
        r.setId(idReemb == null ? 0 : Integer.valueOf(idReemb));
        r.setMotivo(motivoReemb == null ? "" : motivoReemb);

        Pedido p = new Pedido();
        p.setId(idPedidoR == null ? 0 : Integer.valueOf(idPedidoR));
        r.setPedido(p);

        return r;
    }

    @Override
    public String toString() {
        return "ReembolsoDTO{" + "idReemb=" + idReemb + ", motivoReemb=" + motivoReemb + ", idPedidoR=" + idPedidoR + '}';
    }
    
    
}
