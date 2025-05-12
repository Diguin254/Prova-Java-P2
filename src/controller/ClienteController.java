package controller;

import dao.ClienteDao;
import dao.EntregaDao;
import dao.PedidoDao;
import dao.TelefoneDao;
import dto.ClienteDTO;
import dto.EntregaDTO;
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
import model.Telefone;
import model.Pedido;
import model.Entrega;

public class ClienteController {

    private final ClienteDao clienteDao;
    private final TelefoneDao telefoneDao;
    private final PedidoDao pedidoDao;
    private final EntregaDao entregaDao;

    public ClienteController() {
        this.clienteDao = new ClienteImplementsDAO();
        this.telefoneDao = new TelefoneImplementsDAO();
        this.pedidoDao = new PedidoImplementsDAO();
        this.entregaDao = new EntregaImplementsDAO();
    }

    public void salvar(ClienteDTO clienteDTO) throws SQLException {
        Cliente cliente = clienteDTO.builder();
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

    public void editar(ClienteDTO clienteDTO) throws SQLException {
        Cliente cliente = clienteDTO.builder();
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

    public void deletar(int id) throws SQLException {
        List<Telefone> todosTel = telefoneDao.listar();
        List<Pedido> todosPed = pedidoDao.listar();
        List<Entrega> todosEnt = entregaDao.listar();

        for (Telefone tel : todosTel) {
            if (tel.getCliente() != null && tel.getCliente().getId().equals(id)) {
                telefoneDao.deletar(tel.getId());
            }
        }
        for (Pedido ped : todosPed) {
            if (ped.getCliente() != null && ped.getCliente().getId().equals(id)) {
                pedidoDao.deletar(ped.getId());
            }
        }
        for (Entrega ent : todosEnt) {
            if (ent.getCliente() != null && ent.getCliente().getId().equals(id)) {
                entregaDao.deletar(ent.getId());
            }
        }

        clienteDao.deletar(id);
    }

    public List<ClienteDTO> listar() throws SQLException {
        List<Cliente> listaClientes = clienteDao.listar();
        List<Telefone> listaTel = telefoneDao.listar();
        List<Pedido> listaPed = pedidoDao.listar();
        List<Entrega> listaEnt = entregaDao.listar();

        List<ClienteDTO> listaDTO = new LinkedList<>();

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
                List<TelefoneDTO> telDtos = new LinkedList<>();
                for (Telefone t : telefones) {
                    TelefoneDTO tDto = new TelefoneDTO();
                    tDto.idTel = String.valueOf(t.getId());
                    tDto.dddTel = String.valueOf(t.getDdd());
                    tDto.numTel = t.getNumero();
                    telDtos.add(tDto);
                }
                dto.telefones = telDtos;
            }
            if (!pedidos.isEmpty()) {
                List<PedidoDTO> pedDtos = new LinkedList<>();
                for (Pedido p : pedidos) {
                    PedidoDTO pDto = new PedidoDTO();
                    pDto.idPed = String.valueOf(p.getId());
                    pDto.horaPed = p.getHoraPedido();
                    pDto.nPed = String.valueOf(p.getNumeroPedido());
                    pDto.dataP = p.getDataPedido();
                    pedDtos.add(pDto);
                }
                dto.pedidos = pedDtos;
            }
            if (!entregas.isEmpty()) {
                List<EntregaDTO> entDtos = new LinkedList<>();
                for (Entrega e : entregas) {
                    EntregaDTO eDto = new EntregaDTO();
                    eDto.idEntrega = String.valueOf(e.getId());
                    eDto.tipoEntregaE = String.valueOf(e.getTipoEntrega());
                    entDtos.add(eDto);
                }
                dto.entregas = entDtos;
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
