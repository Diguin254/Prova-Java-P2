package dao;

import model.Bairro;
import java.sql.*;
import java.util.List;

public interface BairroDao {
    public void salvar(Bairro bairro) throws SQLException;
    public void editar(Bairro bairro) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Bairro> listar() throws SQLException;
}
