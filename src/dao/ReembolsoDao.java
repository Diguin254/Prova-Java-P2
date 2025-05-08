package dao;

import model.Reembolso;
import java.sql.*;
import java.util.List;

public interface ReembolsoDao {
    public void salvar(Reembolso reembolso) throws SQLException;
    public void editar(Reembolso reembolso) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Reembolso> listar() throws SQLException;
}
