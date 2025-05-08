package dao;

import model.Cartao;
import java.sql.*;
import java.util.List;

public interface CartaoDao {
    public void salvar(Cartao cartao) throws SQLException;
    public void editar(Cartao cartao) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Cartao> listar() throws SQLException;
}
