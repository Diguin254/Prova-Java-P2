package dao;

import model.Dinheiro;
import java.sql.*;
import java.util.List;

public interface DinheiroDao {
    public void salvar(Dinheiro dinheiro) throws SQLException;
    public void editar(Dinheiro dinheiro) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Dinheiro> listar() throws SQLException;
}
