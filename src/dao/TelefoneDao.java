package dao;

import java.sql.*;
import java.util.List;
import model.Telefone;

public interface TelefoneDao {
    public void salvar(Telefone telefone) throws SQLException;
    public void editar(Telefone telefone) throws SQLException;
    public void deletar(int id)throws SQLException;
    public List<Telefone> listar()throws SQLException;
}
