package dao;

import model.Login;
import java.sql.*;
import java.util.List;

public interface LoginDao {
   public void salvar(Login login) throws SQLException;
   public void editar(Login login) throws SQLException;
   public void deletar(int id) throws SQLException;
   public List<Login> listar() throws SQLException;
}
