package dao;

import java.sql.*;
import java.util.List;
import model.Pedido;

public interface PedidoDao {
    public void salvar(Pedido pedido) throws SQLException;
    public void editar(Pedido pedido) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Pedido> listar() throws SQLException;
}
