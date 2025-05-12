package dao;

import java.sql.*;
import java.util.List;
import model.MetodoPagamento;

public interface MetodoPagamentoDao {
    public void salvar(MetodoPagamento metodoPagamento) throws SQLException;
    public void editar(MetodoPagamento metodoPagamento) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<MetodoPagamento> listar() throws SQLException;
}
