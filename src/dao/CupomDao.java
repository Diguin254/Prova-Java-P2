package dao;

import model.Cupom;
import java.sql.*;
import java.util.List;

public interface CupomDao {
    public void salvar(Cupom cupom) throws SQLException;
    public void editar(Cupom cupom) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Cupom> listar() throws SQLException;
}
