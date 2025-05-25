package controller;

import dao.IngredienteRemoverDao;
import dto.IngredienteRemoverDTO;
import dto.InterfaceDTO;
import implementsDao.IngredienteRemoverImplementsDAO;
import model.IngredienteRemover;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IngredienteRemoverController extends InterfaceController {

    private final IngredienteRemoverDao ingredienteRemoverDao = new IngredienteRemoverImplementsDAO();

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        ingredienteRemoverDao.salvar(((IngredienteRemoverDTO) dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        ingredienteRemoverDao.salvar(((IngredienteRemoverDTO) dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        ingredienteRemoverDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<IngredienteRemover> lista = ingredienteRemoverDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();

        for (IngredienteRemover ingrR : lista) {
            IngredienteRemoverDTO dto = new IngredienteRemoverDTO();
            dto.idIngrRem = String.valueOf(ingrR.getId());
            dto.nomeIngrRem = ingrR.getNome();
            dto.idIngrEsco = String.valueOf(ingrR.getIngredienteEscolha().getId());
            listaDTO.add((InterfaceDTO) dto);
        }

        return listaDTO;
    }
}
