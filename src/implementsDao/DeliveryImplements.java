package implementsDao;

import bancoConexao.Conexao;
import dao.DeliveryDao;
import model.Delivery;
import model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DeliveryImplements implements DeliveryDao {

    @Override
    public void salvar(Delivery delivery) throws SQLException {
        String sql = "INSERT INTO delivery (id, chaveEntrega, numero, complemento, endereco_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, delivery.getId());
            stmt.setString(2, delivery.getChaveEntrega());
            stmt.setInt(3, delivery.getNumero());
            stmt.setString(4, delivery.getComplemento());
            stmt.setInt(5, delivery.getEndereco().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Delivery delivery) throws SQLException {
        String sql = "UPDATE delivery SET chaveEntrega = ?, numero = ?, complemento = ?, endereco_id = ? WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
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
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Delivery> listar() throws SQLException {
        List<Delivery> deliveries = new LinkedList<>();
        String sql = "SELECT id, chaveEntrega, numero, complemento, endereco_id FROM delivery";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
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
