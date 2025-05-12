package dao;

import model.IngredienteRemover;
import java.sql.*;
import java.util.List;

public interface IngredienteRemoverDao {
    public void salvar(IngredienteRemover ingredienteRemover) throws SQLException;
    public void editar(IngredienteRemover ingredienteRemover) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<IngredienteRemover> listar() throws SQLException;
}
