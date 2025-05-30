package controller;

import controller.InterfaceController;
import dao.StatusPedidoDao;
import dto.InterfaceDTO;
import dto.StatusPedidoDTO;
import implementsDao.StatusPedidoImplementsDAO;
import model.StatusPedido;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StatusPedidoController extends InterfaceController {

    private final StatusPedidoDao statusPedidoDao;

    public StatusPedidoController() {
        this.statusPedidoDao = new StatusPedidoImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        statusPedidoDao.salvar(((StatusPedidoDTO)dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        statusPedidoDao.editar(((StatusPedidoDTO)dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        statusPedidoDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<StatusPedido> lista = statusPedidoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (StatusPedido stP : lista) {
            StatusPedidoDTO dto = new StatusPedidoDTO();
            dto.idStatPed = String.valueOf(stP.getId());
            dto.progStatPed = stP.getProgresso();
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
