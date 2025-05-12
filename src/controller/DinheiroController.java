package controller;

import dao.DinheiroDao;
import dto.DinheiroDTO;
import implementsDao.DinheiroImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Dinheiro;

public class DinheiroController {

    private final DinheiroDao dinheiroDao;

    public DinheiroController() {
        this.dinheiroDao = new DinheiroImplementsDAO();
    }

    public void salvar(DinheiroDTO dinheiroDTO) throws SQLException {
        Dinheiro d = dinheiroDTO.builder();
        dinheiroDao.salvar(d);
    }

    public void editar(DinheiroDTO dinheiroDTO) throws SQLException {
        Dinheiro d = dinheiroDTO.builder();
        dinheiroDao.editar(d);
    }

    public void deletar(int id) throws SQLException {
        dinheiroDao.deletar(id);
    }

    public List<DinheiroDTO> listar() throws SQLException {
        List<Dinheiro> lista = dinheiroDao.listar();
        List<DinheiroDTO> listaDTO = new LinkedList<>();

        for (Dinheiro d : lista) {
            DinheiroDTO dto = new DinheiroDTO();
            dto.idDinheiro = String.valueOf(d.getId());
            dto.valorD = String.valueOf(d.getValorEntregado());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
