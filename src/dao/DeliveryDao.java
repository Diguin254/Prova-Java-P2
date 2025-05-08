package dao;

import model.Delivery;
import java.sql.*;
import java.util.List;

public interface DeliveryDao {
    public void salvar(Delivery delivery) throws SQLException;
    public void editar(Delivery delivery) throws SQLException;
    public void deletar(int id) throws SQLException;
    public List<Delivery> listar() throws SQLException;
}
