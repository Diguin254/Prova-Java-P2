package dto;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import model.Cliente;
import model.Pedido;
import model.StatusPedido;
import model.Carrinho;

public class PedidoDTO implements InterfaceDTO{

    public PedidoDTO() {
    }

    public String idPed;
    public String horaPed;
    public String nPed;
    public Date dataP;
    public String idClienteP;
    public List<CarrinhoDTO> carrinhos;
    public String idStatusPed;

    public String getIdPed() {
        return idPed;
    }

    public void setIdPed(String idPed) {
        this.idPed = idPed;
    }

    public String getHoraPed() {
        return horaPed;
    }

    public void setHoraPed(String horaPed) {
        this.horaPed = horaPed;
    }

    public Date getDataP() {
        return dataP;
    }

    public void setDataP(Date dataP) {
        this.dataP = dataP;
    }

    public String getIdClienteP() {
        return idClienteP;
    }

    public void setIdClienteP(String idClienteP) {
        this.idClienteP = idClienteP;
    }

    public List<CarrinhoDTO> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<CarrinhoDTO> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public String getIdStatusPed() {
        return idStatusPed;
    }

    public void setIdStatusPed(String idStatusPed) {
        this.idStatusPed = idStatusPed;
    }

    public String getnPed() {
        return nPed;
    }

    public void setnPed(String nPed) {
        this.nPed = nPed;
    }

    
    
    public Pedido builder() {
        Pedido ped = new Pedido();
        ped.setId(idPed == null ? 0 : Integer.valueOf(idPed));
        ped.setHoraPedido(horaPed == null ? "" : horaPed);
        ped.setNumeroPedido(nPed == null ? 0 : Integer.valueOf(nPed));
        ped.setDataPedido(dataP);

        Cliente c = new Cliente();
        c.setId(idClienteP == null ? 0 : Integer.valueOf(idClienteP));
        ped.setCliente(c);

        List<Carrinho> listaCar = new LinkedList<>();
        if (carrinhos != null) {
            for (CarrinhoDTO dto : carrinhos) {
                Carrinho car = dto.builder();
                car.setPedido(ped);
                listaCar.add(car);
            }
        }
        ped.setCarrinhos(listaCar);

        StatusPedido sp = new StatusPedido();
        sp.setId(idStatusPed == null ? 0 : Integer.valueOf(idStatusPed));
        ped.setStatusPedido(sp);

        return ped;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" + "idPed=" + idPed + ", horaPed=" + horaPed + ", nPed=" + nPed + ", dataP=" + dataP + ", idClienteP=" + idClienteP + ", carrinhos=" + carrinhos + ", idStatusPed=" + idStatusPed + '}';
    }
    
    
}
