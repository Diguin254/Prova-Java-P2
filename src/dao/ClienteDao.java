package dao;

import java.sql.*;
import java.util.List;
import model.Cliente;

public interface ClienteDao {
    public void salvar(Cliente cliente) throws SQLException;
    public void editar(Cliente cliente) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Cliente> listar() throws SQLException;
}
