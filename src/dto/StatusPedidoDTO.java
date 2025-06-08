package dto;

import model.Pedido;
import model.StatusPedido;

public class StatusPedidoDTO implements InterfaceDTO{

    public StatusPedidoDTO() {
    }

    public String idStatPed;
    public String progStatPed;

    public String getIdStatPed() {
        return idStatPed;
    }

    public void setIdStatPed(String idStatPed) {
        this.idStatPed = idStatPed;
    }

    public String getProgStatPed() {
        return progStatPed;
    }

    public void setProgStatPed(String progStatPed) {
        this.progStatPed = progStatPed;
    }

    public StatusPedido builder() {
        StatusPedido sp = new StatusPedido();
        sp.setId(idStatPed == null ? 0 : Integer.valueOf(idStatPed));
        sp.setProgresso(progStatPed == null ? "" : progStatPed);

        return sp;
    }

    @Override
    public String toString() {
        return "StatusPedidoDTO{" + "idStatPed=" + idStatPed + ", progStatPed=" + progStatPed + '}';
    }
    
    @Override
    public int getId() {
        return (idStatPed == null || idStatPed.isBlank()) ? 0 : Integer.parseInt(idStatPed);
    }

    @Override
    public void setId(int id) {
        this.idStatPed = String.valueOf(id);
    }
}
