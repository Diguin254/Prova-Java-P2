package controller;

import dao.IngredienteRemoverDao;
import dto.IngredienteRemoverDTO;
import model.IngredienteRemover;
import implementsDao.IngredienteRemoverImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IngredienteRemoverController {

    private final IngredienteRemoverDao ingredienteRemoverDao;

    public IngredienteRemoverController() {
        this.ingredienteRemoverDao = new IngredienteRemoverImplementsDAO();
    }

    public void salvar(IngredienteRemoverDTO ingredienteRemoverDTO) throws SQLException {
        IngredienteRemover ingrR = ingredienteRemoverDTO.builder();
        ingredienteRemoverDao.salvar(ingrR);
    }

    public void editar(IngredienteRemoverDTO ingredienteRemoverDTO) throws SQLException {
        IngredienteRemover ingrR = ingredienteRemoverDTO.builder();
        ingredienteRemoverDao.editar(ingrR);
    }

    public void deletar(int id) throws SQLException {
        ingredienteRemoverDao.deletar(id);
    }

    public List<IngredienteRemoverDTO> listar() throws SQLException {
        List<IngredienteRemover> lista = ingredienteRemoverDao.listar();
        List<IngredienteRemoverDTO> listaDTO = new LinkedList<>();

        for (IngredienteRemover ingrR : lista) {
            IngredienteRemoverDTO dto = new IngredienteRemoverDTO();
            dto.idIngrRem = String.valueOf(ingrR.getId());
            dto.nomeIngrRem = ingrR.getNome();
            dto.idIngrEsco = String.valueOf(ingrR.getIngredienteEscolha().getId());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
