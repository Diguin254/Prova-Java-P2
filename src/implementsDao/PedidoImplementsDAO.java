package implementsDao;

import bancoConexao.Conexao;
import dao.PedidoDao;
import model.Pedido;
import model.Cliente;
import model.StatusPedido;
import model.Entrega;

import java.sql.*;

import java.util.LinkedList;
import java.util.List;

public class PedidoImplementsDAO implements PedidoDao {

    Connection con;

    @Override
    public void salvar(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedido (horaPedido, numeroPedido, dataPedido, cliente_id, status_pedido_id) VALUES (?, ?, ?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            String horaStr = pedido.getHoraPedido().trim();
            java.sql.Time horaSql;
            
            if(horaStr.matches("^\\d{1,2}:\\d{2}$")){
                horaSql = java.sql.Time.valueOf(horaStr + ":00");
            } else {
                horaSql = java.sql.Time.valueOf(horaStr);
            }
            
            stmt.setTime(1, horaSql);
            stmt.setInt(2, pedido.getNumeroPedido());
            stmt.setDate(3, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setInt(4, pedido.getCliente().getId());
            stmt.setInt(5, pedido.getStatusPedido().getId());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pedido.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(Pedido pedido) throws SQLException {
        String sql = "UPDATE pedido SET horaPedido = ?, numeroPedido = ?, dataPedido = ?, cliente_id = ?, status_pedido_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pedido.getHoraPedido());
            stmt.setInt(2, pedido.getNumeroPedido());
            stmt.setDate(3, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setInt(4, pedido.getCliente().getId());
            stmt.setInt(5, pedido.getStatusPedido().getId());
            stmt.setInt(6, pedido.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM pedido WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Pedido> listar() throws SQLException {
        List<Pedido> pedidos = new LinkedList<>();
        String sql = "SELECT id, horaPedido, numeroPedido, dataPedido, cliente_id, status_pedido_id FROM pedido";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(res.getInt("id"));
                pedido.setHoraPedido(res.getString("horaPedido"));
                pedido.setNumeroPedido(res.getInt("numeroPedido"));
                pedido.setDataPedido(res.getDate("dataPedido"));

                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("cliente_id"));
                pedido.setCliente(cliente);

                StatusPedido status = new StatusPedido();
                status.setId(res.getInt("status_pedido_id"));
                pedido.setStatusPedido(status);

                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
}
