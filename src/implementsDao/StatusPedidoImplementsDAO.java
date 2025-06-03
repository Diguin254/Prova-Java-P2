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
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, statusPedido.getProgresso());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    statusPedido.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(StatusPedido statusPedido) throws SQLException {
        String sql = "UPDATE statusPedido SET progresso = ? WHERE id = ?";
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
        String sql = "SELECT id, progresso FROM statusPedido";
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
