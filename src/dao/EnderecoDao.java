package dao;

import model.Endereco;
import java.sql.*;
import java.util.List;

public interface EnderecoDao {
    public void salvar(Endereco endereco) throws SQLException;
    public void editar(Endereco endereco) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Endereco> listar() throws SQLException;
}
