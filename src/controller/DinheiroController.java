package controller;

import dao.DinheiroDao;
import dto.DinheiroDTO;
import dto.InterfaceDTO;
import implementsDao.DinheiroImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Dinheiro;

public class DinheiroController extends InterfaceController {

    private final DinheiroDao dinheiroDao;

    public DinheiroController() {
        this.dinheiroDao = new DinheiroImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        dinheiroDao.salvar(((DinheiroDTO) dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        dinheiroDao.editar(((DinheiroDTO) dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        dinheiroDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Dinheiro> lista = dinheiroDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();

        for (Dinheiro d : lista) {
            DinheiroDTO dto = new DinheiroDTO();
            dto.idDinheiro = String.valueOf(d.getId());
            dto.valorD = String.valueOf(d.getValorEntregado());
            listaDTO.add((InterfaceDTO) dto);
        }

        return listaDTO;
    }
}
