package dao;

import model.Carrinho;
import java.sql.*;
import java.util.List;

public interface CarrinhoDao {
    public void salvar(Carrinho carrinho) throws SQLException;
    public void editar(Carrinho carrinho) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Carrinho> listar() throws SQLException;
}
