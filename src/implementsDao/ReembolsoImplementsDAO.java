package implementsDao;

import bancoConexao.Conexao;
import dao.ReembolsoDao;
import model.Reembolso;
import model.Pedido;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ReembolsoImplementsDAO implements ReembolsoDao {

    Connection con;

    @Override
    public void salvar(Reembolso reembolso) throws SQLException {
        String sql = "INSERT INTO reembolso(id, motivo, pedido_id) VALUES (?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, reembolso.getId());
            stmt.setString(2, reembolso.getMotivo());
            stmt.setInt(3, reembolso.getPedido().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Reembolso reembolso) throws SQLException {
        String sql = "UPDATE reembolso SET motivo = ?, pedido_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, reembolso.getMotivo());
            stmt.setInt(2, reembolso.getPedido().getId());
            stmt.setInt(3, reembolso.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM reembolso WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Reembolso> listar() throws SQLException {
        List<Reembolso> reembolsos = new LinkedList<>();
        String sql = "SELECT id, motivo, pedido_id FROM reembolso";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                Reembolso reembolso = new Reembolso();
                reembolso.setId(res.getInt("id"));
                reembolso.setMotivo(res.getString("motivo"));

                Pedido pedido = new Pedido();
                pedido.setId(res.getInt("pedido_id"));
                reembolso.setPedido(pedido);

                reembolsos.add(reembolso);
            }
        }
        return reembolsos;
    }
}
