package controller;

import dao.IngredienteAdicionalDao;
import dto.IngredienteAdicionalDTO;
import dto.InterfaceDTO;
import model.IngredienteAdicional;
import implementsDao.IngredienteAdicionalImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IngredienteAdicionalController extends InterfaceController {

    private final IngredienteAdicionalDao ingredienteAdicionalDao = new IngredienteAdicionalImplementsDAO();

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        ingredienteAdicionalDao.salvar(((IngredienteAdicionalDTO) dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        ingredienteAdicionalDao.salvar(((IngredienteAdicionalDTO) dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        ingredienteAdicionalDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<IngredienteAdicional> lista = ingredienteAdicionalDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();

        for (IngredienteAdicional ing : lista) {
            IngredienteAdicionalDTO dto = new IngredienteAdicionalDTO();
            dto.idIngrAdc = String.valueOf(ing.getId());
            dto.nomeIngrAdc = ing.getNome();
            dto.valorIngrAdc = String.valueOf(ing.getValor());
            dto.idIngrEsc = String.valueOf(ing.getIngredienteEscolha().getId());
            listaDTO.add((InterfaceDTO) dto);
        }

        return listaDTO;
    }
}
