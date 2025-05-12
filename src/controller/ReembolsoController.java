package controller;

import dao.ReembolsoDao;
import dto.ReembolsoDTO;
import implementsDao.ReembolsoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Reembolso;

public class ReembolsoController {

    private final ReembolsoDao reembolsoDao;

    public ReembolsoController() {
        this.reembolsoDao = new ReembolsoImplementsDAO();
    }

    public void salvar(ReembolsoDTO reembolsoDTO) throws SQLException {
        Reembolso reem = reembolsoDTO.builder();
        reembolsoDao.salvar(reem);
    }

    public void editar(ReembolsoDTO reembolsoDTO) throws SQLException {
        Reembolso reem = reembolsoDTO.builder();
        reembolsoDao.editar(reem);
    }

    public void deletar(int id) throws SQLException {
        reembolsoDao.deletar(id);
    }

    public List<ReembolsoDTO> listar() throws SQLException {
        List<Reembolso> lista = reembolsoDao.listar();
        List<ReembolsoDTO> listaDTO = new LinkedList<>();

        for (Reembolso r : lista) {
            ReembolsoDTO dto = new ReembolsoDTO();
            dto.idReemb = String.valueOf(r.getId());
            dto.motivoReemb = r.getMotivo();
            dto.idPedidoR = String.valueOf(r.getPedido().getId());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
