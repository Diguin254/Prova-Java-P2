package dto;

import model.Cliente;
import model.Delivery;
import model.Entrega;
import model.Pedido;
import model.StatusPedido;

public class EntregaDTO implements InterfaceDTO {

    public EntregaDTO() {
    }

    public String idEntrega;
    public String idCliente;
    public String tipoEntregaE;
    public String idDelivery;
    public String idPedido;
    public String idStatusPedido;

    public String getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(String idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(String idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdStatusPedido() {
        return idStatusPedido;
    }

    public void setIdStatusPedido(String idStatusPedido) {
        this.idStatusPedido = idStatusPedido;
    }

    public String getTipoEntregaE() {
        return tipoEntregaE;
    }

    public void setTipoEntregaE(String tipoEntregaE) {
        this.tipoEntregaE = tipoEntregaE;
    }

    public Entrega builder() {
        Entrega ent = new Entrega();
        ent.setId(idEntrega == null ? 0 : Integer.valueOf(idEntrega));

        Cliente c = new Cliente();
        c.setId(idCliente == null ? 0 : Integer.valueOf(idCliente));
        ent.setCliente(c);

        ent.setTipoEntrega(tipoEntregaE == null ? 0 : Integer.valueOf(tipoEntregaE));

        Delivery d = new Delivery();
        d.setId(idDelivery == null ? 0 : Integer.valueOf(idDelivery));
        ent.setDelivery(d);

        Pedido p = new Pedido();
        p.setId(idPedido == null ? 0 : Integer.valueOf(idPedido));
        ent.setPedido(p);

        StatusPedido status = new StatusPedido();
        status.setId(idStatusPedido == null ? 0 : Integer.valueOf(idStatusPedido));
        ent.setStatusPedido(status);

        return ent;
    }

    @Override
    public String toString() {
        return "EntregaDTO{" + "idEntrega=" + idEntrega + ", idCliente=" + idCliente + ", tipoEntregaE=" + tipoEntregaE + ", idDelivery=" + idDelivery + ", idPedido=" + idPedido + ", idStatusPedido=" + idStatusPedido + '}';
    }
@Override
    public int getId() {
        return (idEntrega == null || idEntrega.isBlank()) ? 0 : Integer.parseInt(idEntrega);
    }

    @Override
    public void setId(int id) {
        this.idEntrega = String.valueOf(id);
    }
}
