package dto;

import model.Pedido;
import model.StatusPedido;

public class StatusPedidoDTO {

    public StatusPedidoDTO() {
    }

    public String idStatPed;
    public String progStatPed;
    public String idPedidoSP;

    public StatusPedido builder() {
        StatusPedido sp = new StatusPedido();
        sp.setId(idStatPed == null ? 0 : Integer.valueOf(idStatPed));
        sp.setProgresso(progStatPed == null ? "" : progStatPed);

        return sp;
    }
}
