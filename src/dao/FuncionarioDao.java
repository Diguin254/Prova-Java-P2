package dao;

import model.Funcionario;
import java.sql.*;
import java.util.List;

public interface FuncionarioDao {
    public void salvar(Funcionario funcionario) throws SQLException;
    public void editar(Funcionario funcionario) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Funcionario> listar() throws SQLException;
}
