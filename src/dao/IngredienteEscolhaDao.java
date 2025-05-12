package dao;

import model.IngredienteEscolha;
import java.sql.*;
import java.util.List;

public interface IngredienteEscolhaDao {
    public void salvar(IngredienteEscolha ingredienteEscolha) throws SQLException;
    public void editar(IngredienteEscolha ingredienteEscolha) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<IngredienteEscolha> listar() throws SQLException;
}
