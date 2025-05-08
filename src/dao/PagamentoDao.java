package dao;

import java.sql.*;
import java.util.List;
import model.Pagamento;

public interface PagamentoDao {
    public void salvar(Pagamento pagamento) throws SQLException;
    public void editar(Pagamento pagamento) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Pagamento> listar() throws SQLException;
}
