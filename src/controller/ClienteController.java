package controller;

import dao.ClienteDao;
import dao.EntregaDao;
import dao.PedidoDao;
import dao.TelefoneDao;
import dto.ClienteDTO;
import dto.EntregaDTO;
import dto.InterfaceDTO;
import dto.PedidoDTO;
import dto.TelefoneDTO;
import implementsDao.ClienteImplementsDAO;
import implementsDao.EntregaImplementsDAO;
import implementsDao.PedidoImplementsDAO;
import implementsDao.TelefoneImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Cliente;
import model.Entrega;
import model.Pedido;
import model.Telefone;

public class ClienteController extends InterfaceController {

    private final ClienteDao clienteDao = new ClienteImplementsDAO();
    private final TelefoneDao telefoneDao = new TelefoneImplementsDAO();
    private final PedidoDao pedidoDao = new PedidoImplementsDAO();
    private final EntregaDao entregaDao = new EntregaImplementsDAO();

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        Cliente cliente = ((ClienteDTO) dto).builder();
        clienteDao.salvar(cliente);

        if (cliente.getTelefones() != null) {
            for (Telefone t : cliente.getTelefones()) {
                t.setCliente(cliente);
                telefoneDao.salvar(t);
            }
        }

        if (cliente.getPedidos() != null) {
            for (Pedido p : cliente.getPedidos()) {
                p.setCliente(cliente);
                pedidoDao.salvar(p);
            }
        }

        if (cliente.getEntregas() != null) {
            for (Entrega e : cliente.getEntregas()) {
                e.setCliente(cliente);
                entregaDao.salvar(e);
            }
        }
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        Cliente cliente = ((ClienteDTO) dto).builder();
        clienteDao.editar(cliente);

        if (cliente.getTelefones() != null) {
            for (Telefone t : cliente.getTelefones()) {
                t.setCliente(cliente);
                if (t.getId() == 0) {
                    telefoneDao.salvar(t);
                } else {
                    telefoneDao.editar(t);
                }
            }
        }

        if (cliente.getPedidos() != null) {
            for (Pedido p : cliente.getPedidos()) {
                p.setCliente(cliente);
                if (p.getId() == 0) {
                    pedidoDao.salvar(p);
                } else {
                    pedidoDao.editar(p);
                }
            }
        }

        if (cliente.getEntregas() != null) {
            for (Entrega e : cliente.getEntregas()) {
                e.setCliente(cliente);
                if (e.getId() == 0) {
                    entregaDao.salvar(e);
                } else {
                    entregaDao.editar(e);
                }
            }
        }
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Cliente> listaClientes = clienteDao.listar();
        List<Telefone> listaTel = telefoneDao.listar();
        List<Pedido> listaPed = pedidoDao.listar();
        List<Entrega> listaEnt = entregaDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();

        for (Cliente c : listaClientes) {
            List<Telefone> telefones = new LinkedList<>();
            for (Telefone t : listaTel) {
                if (t.getCliente() != null && t.getCliente().getId().equals(c.getId())) {
                    telefones.add(t);
                }
            }
            c.setTelefones(telefones);

            List<Pedido> pedidos = new LinkedList<>();
            for (Pedido p : listaPed) {
                if (p.getCliente() != null && p.getCliente().getId().equals(c.getId())) {
                    pedidos.add(p);
                }
            }
            c.setPedidos(pedidos);

            List<Entrega> entregas = new LinkedList<>();
            for (Entrega e : listaEnt) {
                if (e.getCliente() != null && e.getCliente().getId().equals(c.getId())) {
                    entregas.add(e);
                }
            }
            c.setEntregas(entregas);

            ClienteDTO dto = new ClienteDTO();
            dto.idCliente = String.valueOf(c.getId());
            dto.nomeCliente = c.getNome();

            if (!telefones.isEmpty()) {
                dto.telefones = new LinkedList<>();
                for (Telefone t : telefones) {
                    TelefoneDTO tDto = new TelefoneDTO();
                    tDto.idTel = String.valueOf(t.getId());
                    tDto.dddTel = String.valueOf(t.getDdd());
                    tDto.numTel = t.getNumero();
                    dto.telefones.add(tDto);
                }
            }

            if (!pedidos.isEmpty()) {
                dto.pedidos = new LinkedList<>();
                for (Pedido p : pedidos) {
                    PedidoDTO pDto = new PedidoDTO();
                    pDto.idPed = String.valueOf(p.getId());
                    pDto.horaPed = p.getHoraPedido();
                    pDto.nPed = String.valueOf(p.getNumeroPedido());
                    pDto.dataP = p.getDataPedido();
                    dto.pedidos.add(pDto);
                }
            }

            if (!entregas.isEmpty()) {
                dto.entregas = new LinkedList<>();
                for (Entrega e : entregas) {
                    EntregaDTO eDto = new EntregaDTO();
                    eDto.idEntrega = String.valueOf(e.getId());
                    eDto.tipoEntregaE = String.valueOf(e.getTipoEntrega());
                    dto.entregas.add(eDto);
                }
            }

            listaDTO.add((InterfaceDTO) dto);
        }

        return listaDTO;
    }

    @Override
    public void deletar(int id) throws SQLException {
        for (Telefone t : telefoneDao.listar()) {
            if (t.getCliente() != null && t.getCliente().getId().equals(id)) {
                telefoneDao.deletar(t.getId());
            }
        }

        for (Pedido p : pedidoDao.listar()) {
            if (p.getCliente() != null && p.getCliente().getId().equals(id)) {
                pedidoDao.deletar(p.getId());
            }
        }

        for (Entrega e : entregaDao.listar()) {
            if (e.getCliente() != null && e.getCliente().getId().equals(id)) {
                entregaDao.deletar(e.getId());
            }
        }

        clienteDao.deletar(id);
    }
}
