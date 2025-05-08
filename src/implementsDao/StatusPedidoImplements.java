package implementsDao;

import bancoConexao.Conexao;
import dao.StatusPedidoDao;
import model.StatusPedido;
import model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StatusPedidoImplements implements StatusPedidoDao {

    @Override
    public void salvar(StatusPedido statusPedido) throws SQLException {
        String sql = "INSERT INTO statusPedido(id, progresso, pedido_id) VALUES (?, ?, ?)";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, statusPedido.getId());
            stmt.setString(2, statusPedido.getProgresso());
            stmt.setInt(3, statusPedido.getPedido().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(StatusPedido statusPedido) throws SQLException {
        String sql = "UPDATE statusPedido SET progresso = ?, pedido_id = ? WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, statusPedido.getProgresso());
            stmt.setInt(2, statusPedido.getPedido().getId());
            stmt.setInt(3, statusPedido.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM statusPedido WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<StatusPedido> listar() throws SQLException {
        List<StatusPedido> statusPedidos = new LinkedList<>();
        String sql = "SELECT id, progresso, pedido_id FROM statusPedido";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                StatusPedido statusPedido = new StatusPedido();
                statusPedido.setId(res.getInt("id"));
                statusPedido.setProgresso(res.getString("progresso"));

                Pedido pedido = new Pedido();
                pedido.setId(res.getInt("pedido_id"));
                statusPedido.setPedido(pedido);

                statusPedidos.add(statusPedido);
            }
        }
        return statusPedidos;
    }
}
