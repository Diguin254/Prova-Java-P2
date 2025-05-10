package dto;

import model.Cliente;
import model.Delivery;
import model.Entrega;
import model.Pedido;
import model.StatusPedido;

public class EntregaDTO {
    
    public EntregaDTO() {
    }
    
    public String idEntrega;
    public String idCliente;
    public String tipoEntregaE;
    public String idDelivery;
    public String idPedido;
    public String idStatusPedido;
    
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
}
