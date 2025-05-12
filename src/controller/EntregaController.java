package controller;

import dao.EntregaDao;
import dto.EntregaDTO;
import model.Entrega;
import implementsDao.EntregaImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EntregaController {

    private final EntregaDao entregaDao;

    public EntregaController() {
        this.entregaDao = new EntregaImplementsDAO();
    }

    public void salvar(EntregaDTO entregaDTO) throws SQLException {
        Entrega e = entregaDTO.builder();
        entregaDao.salvar(e);
    }

    public void editar(EntregaDTO entregaDTO) throws SQLException {
        Entrega e = entregaDTO.builder();
        entregaDao.editar(e);
    }

    public void deletar(int id) throws SQLException {
        entregaDao.deletar(id);
    }

    public List<EntregaDTO> listar() throws SQLException {
        List<Entrega> lista = entregaDao.listar();
        List<EntregaDTO> listaDTO = new LinkedList<>();

        for (Entrega e : lista) {
            EntregaDTO dto = new EntregaDTO();
            dto.idEntrega = String.valueOf(e.getId());
            dto.idCliente = String.valueOf(e.getCliente().getId());
            dto.tipoEntregaE = String.valueOf(e.getTipoEntrega());
            dto.idDelivery = String.valueOf(e.getDelivery().getId());
            dto.idPedido = String.valueOf(e.getPedido().getId());
            dto.idStatusPedido = String.valueOf(e.getStatusPedido().getId());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
