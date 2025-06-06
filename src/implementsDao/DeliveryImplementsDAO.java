package implementsDao;

import bancoConexao.Conexao;
import dao.DeliveryDao;
import model.Delivery;
import model.Endereco;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DeliveryImplementsDAO implements DeliveryDao {

    Connection con;

    @Override
    public void salvar(Delivery delivery) throws SQLException {
        String sql = "INSERT INTO delivery (chaveEntrega, numero, complemento, endereco_id) VALUES (?, ?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, delivery.getChaveEntrega());
            stmt.setInt(2, delivery.getNumero());
            stmt.setString(3, delivery.getComplemento());
            stmt.setInt(4, delivery.getEndereco().getId());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    delivery.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(Delivery delivery) throws SQLException {
        String sql = "UPDATE delivery SET chaveEntrega = ?, numero = ?, complemento = ?, endereco_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, delivery.getChaveEntrega());
            stmt.setInt(2, delivery.getNumero());
            stmt.setString(3, delivery.getComplemento());
            stmt.setInt(4, delivery.getEndereco().getId());
            stmt.setInt(5, delivery.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM delivery WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Delivery> listar() throws SQLException {
        List<Delivery> deliveries = new LinkedList<>();
        String sql = "SELECT id, chaveEntrega, numero, complemento, endereco_id FROM delivery";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(res.getInt("id"));
                delivery.setChaveEntrega(res.getString("chaveEntrega"));
                delivery.setNumero(res.getInt("numero"));
                delivery.setComplemento(res.getString("complemento"));

                Endereco endereco = new Endereco();
                endereco.setId(res.getInt("endereco_id"));
                delivery.setEndereco(endereco);

                deliveries.add(delivery);
            }
        }
        return deliveries;
    }
}
