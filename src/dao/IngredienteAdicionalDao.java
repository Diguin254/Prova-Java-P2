package dao;

import model.IngredienteAdicional;
import java.sql.*;
import java.util.List;

public interface IngredienteAdicionalDao {
    public void salvar(IngredienteAdicional ingredienteAdicional) throws SQLException;
    public void editar(IngredienteAdicional ingredienteAdicional) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<IngredienteAdicional> listar() throws SQLException;
}
