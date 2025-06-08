package dto;

import java.util.LinkedList;
import model.Cliente;
import java.util.List;
import model.Pedido;
import model.Telefone;
import model.Entrega;

public class ClienteDTO implements InterfaceDTO{

    public ClienteDTO() {
    }

    public String idCliente;
    public String nomeCliente;
    public List<TelefoneDTO> telefones;
    public List<PedidoDTO> pedidos;
    public List<EntregaDTO> entregas;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }

    public List<EntregaDTO> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<EntregaDTO> entregas) {
        this.entregas = entregas;
    }

    
    
    public Cliente builder() {
        Cliente c = new Cliente();
        c.setId(idCliente == null ? 0 : Integer.valueOf(idCliente));
        c.setNome(nomeCliente == null ? "" : nomeCliente);

        List<Telefone> listaT = new LinkedList<>();
        if (telefones != null) {
            for (TelefoneDTO dto : telefones) {
                Telefone tel = dto.builder();
                tel.setCliente(c);
                listaT.add(tel);
            }
        }
        c.setTelefones(listaT);

        List<Pedido> listaP = new LinkedList<>();
        if (pedidos != null) {
            for (PedidoDTO dto : pedidos) {
                Pedido ped = dto.builder();
                ped.setCliente(c);
                listaP.add(ped);
            }
        }
        c.setPedidos(listaP);

        List<Entrega> listaE = new LinkedList<>();
        if (entregas != null) {
            for (EntregaDTO dto : entregas) {
                Entrega ent = dto.builder();
                ent.setCliente(c);
                listaE.add(ent);
            }
        }
        c.setEntregas(listaE);

        return c;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", telefones=" + telefones + ", pedidos=" + pedidos + ", entregas=" + entregas + '}';
    }
    
    @Override
    public int getId() {
        return (idCliente == null || idCliente.isBlank()) ? 0 : Integer.parseInt(idCliente);
    }

    @Override
    public void setId(int id) {
        this.idCliente = String.valueOf(id);
    }
}
