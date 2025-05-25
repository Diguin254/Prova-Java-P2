package controller;

import controller.InterfaceController;
import dao.ReembolsoDao;
import dto.InterfaceDTO;
import dto.ReembolsoDTO;
import implementsDao.ReembolsoImplementsDAO;
import model.Reembolso;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReembolsoController extends InterfaceController {

    private final ReembolsoDao reembolsoDao;

    public ReembolsoController() {
        this.reembolsoDao = new ReembolsoImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        reembolsoDao.salvar(((ReembolsoDTO)dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        reembolsoDao.editar(((ReembolsoDTO)dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        reembolsoDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Reembolso> lista = reembolsoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Reembolso r : lista) {
            ReembolsoDTO dto = new ReembolsoDTO();
            dto.idReemb = String.valueOf(r.getId());
            dto.motivoReemb = r.getMotivo();
            dto.idPedidoR = r.getPedido() != null ? String.valueOf(r.getPedido().getId()) : null;
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
