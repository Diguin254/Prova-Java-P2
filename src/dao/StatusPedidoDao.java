package dao;

import java.sql.*;
import java.util.List;
import model.StatusPedido;

public interface StatusPedidoDao {
    public void salvar(StatusPedido statusPedido) throws SQLException;
    public void editar(StatusPedido statusPedido) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<StatusPedido> listar() throws SQLException;
}
