package dao;

import java.sql.*;
import java.util.List;
import model.Produto;

public interface ProdutoDao {
    public void salvar(Produto produto) throws SQLException;
    public void editar(Produto produto) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Produto> listar() throws SQLException;
}
