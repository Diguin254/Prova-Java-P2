package controller;

import dao.BairroDao;
import dto.BairroDTO;
import implementsDao.BairroImplementsDAO;
import model.Bairro;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BairroController {

    private final BairroDao bairroDao;

    public BairroController() {
        this.bairroDao = new BairroImplementsDAO();
    }

    public void salvar(BairroDTO bairroDTO) throws SQLException {
        Bairro bairro = bairroDTO.builder();
        bairroDao.salvar(bairro);
    }

    public void editar(BairroDTO bairroDTO) throws SQLException {
        Bairro bairro = bairroDTO.builder();
        bairroDao.editar(bairro);
    }

    public void deletar(int id) throws SQLException {
        bairroDao.deletar(id);
    }

    public List<BairroDTO> listar() throws SQLException {
        List<Bairro> lista = bairroDao.listar();
        List<BairroDTO> listaDTO = new LinkedList<>();
        for (Bairro b : lista) {
            BairroDTO dto = new BairroDTO();
            dto.idBairro = String.valueOf(b.getId());
            dto.nomeBairro = b.getNome();
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
