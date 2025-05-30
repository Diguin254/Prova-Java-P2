package implementsDao;

import bancoConexao.Conexao;
import dao.StatusPedidoDao;
import model.StatusPedido;
import model.Pedido;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StatusPedidoImplementsDAO implements StatusPedidoDao {

    Connection con;

    @Override
    public void salvar(StatusPedido statusPedido) throws SQLException {
        String sql = "INSERT INTO statusPedido(progresso) VALUES (?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, statusPedido.getProgresso());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(StatusPedido statusPedido) throws SQLException {
        String sql = "UPDATE statusPedido SET progresso = ?, pedido_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, statusPedido.getProgresso());
            stmt.setInt(2, statusPedido.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM statusPedido WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<StatusPedido> listar() throws SQLException {
        List<StatusPedido> statusPedidos = new LinkedList<>();
        String sql = "SELECT id, progresso, pedido_id FROM statusPedido";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                StatusPedido statusPedido = new StatusPedido();
                statusPedido.setId(res.getInt("id"));
                statusPedido.setProgresso(res.getString("progresso"));

                statusPedidos.add(statusPedido);
            }
        }
        return statusPedidos;
    }
}
