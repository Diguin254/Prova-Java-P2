package controller;

import dao.BairroDao;
import dto.BairroDTO;
import implementsDao.BairroImplementsDAO;
import model.Bairro;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BairroController {

    private final BairroDao dao;

    public BairroController() {
        this.dao = new BairroImplementsDAO();
    }

    public void salvar(BairroDTO bairroDTO) throws SQLException {
        Bairro bairro = bairroDTO.builder();
        dao.salvar(bairro);
    }

    public void editar(BairroDTO bairroDTO) throws SQLException {
        Bairro bairro = bairroDTO.builder();
        dao.editar(bairro);
    }

    public void deletar(int id) throws SQLException {
        dao.deletar(id);
    }

    public List listar() throws SQLException {
        List<Bairro> lista = dao.listar();
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
