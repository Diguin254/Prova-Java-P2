package controller;

import dao.IngredienteAdicionalDao;
import dto.IngredienteAdicionalDTO;
import model.IngredienteAdicional;
import implementsDao.IngredienteAdicionalImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IngredienteAdicionalController {

    private final IngredienteAdicionalDao ingredienteAdicionalDao;

    public IngredienteAdicionalController() {
        this.ingredienteAdicionalDao = new IngredienteAdicionalImplementsDAO();
    }

    public void salvar(IngredienteAdicionalDTO ingredienteAdicionalDTO) throws SQLException {
        IngredienteAdicional ingrA = ingredienteAdicionalDTO.builder();
        ingredienteAdicionalDao.salvar(ingrA);
    }

    public void editar(IngredienteAdicionalDTO ingredienteAdicionalDTO) throws SQLException {
        IngredienteAdicional ingrA = ingredienteAdicionalDTO.builder();
        ingredienteAdicionalDao.editar(ingrA);
    }

    public void deletar(int id) throws SQLException {
        ingredienteAdicionalDao.deletar(id);
    }

    public List<IngredienteAdicionalDTO> listar() throws SQLException {
        List<IngredienteAdicional> lista = ingredienteAdicionalDao.listar();
        List<IngredienteAdicionalDTO> listaDTO = new LinkedList<>();

        for (IngredienteAdicional ing : lista) {
            IngredienteAdicionalDTO dto = new IngredienteAdicionalDTO();
            dto.idIngrAdc = String.valueOf(ing.getId());
            dto.nomeIngrAdc = ing.getNome();
            dto.valorIngrAdc = String.valueOf(ing.getValor());
            dto.idIngrEsc = String.valueOf(ing.getIngredienteEscolha().getId());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
