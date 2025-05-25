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
}
