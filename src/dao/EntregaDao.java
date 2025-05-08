package dao;

import model.Entrega;
import java.sql.*;
import java.util.List;

public interface EntregaDao {
    public void salvar(Entrega entrega) throws SQLException;
    public void editar(Entrega entrega) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Entrega> listar() throws SQLException;
}
