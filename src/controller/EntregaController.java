package controller;

import dao.EntregaDao;
import dto.EntregaDTO;
import dto.InterfaceDTO;
import model.Entrega;
import implementsDao.EntregaImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EntregaController extends InterfaceController {

    private final EntregaDao entregaDao;

    public EntregaController() {
        this.entregaDao = new EntregaImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        entregaDao.salvar(((EntregaDTO) dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        entregaDao.editar(((EntregaDTO) dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        entregaDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Entrega> lista = entregaDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();

        for (Entrega e : lista) {
            EntregaDTO dto = new EntregaDTO();
            dto.idEntrega = String.valueOf(e.getId());
            dto.idCliente = String.valueOf(e.getCliente().getId());
            dto.tipoEntregaE = String.valueOf(e.getTipoEntrega());
            dto.idDelivery = String.valueOf(e.getDelivery().getId());
            dto.idPedido = String.valueOf(e.getPedido().getId());
            dto.idStatusPedido = String.valueOf(e.getStatusPedido().getId());
            listaDTO.add((InterfaceDTO) dto);
        }

        return listaDTO;
    }

}
