package dao;

import java.sql.*;
import java.util.List;
import model.TaxaEntrega;

public interface TaxaEntregaDao {
    public void salvar(TaxaEntrega taxaEntrega) throws SQLException;
    public void editar(TaxaEntrega taxaEntrega) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<TaxaEntrega> listar() throws SQLException;
}
