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

    @Override
    public void salvar(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedido (id, horaPedido, numeroPedido, dataPedido, cliente_id, statusPedido_id, entrega_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getId());
            stmt.setString(2, pedido.getHoraPedido());
            stmt.setInt(3, pedido.getNumeroPedido());
            stmt.setDate(4, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setInt(5, pedido.getCliente().getId());
            stmt.setInt(6, pedido.getStatusPedido().getId());
            stmt.setInt(7, pedido.getEntrega().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Pedido pedido) throws SQLException {
        String sql = "UPDATE pedido SET horaPedido = ?, numeroPedido = ?, dataPedido = ?, cliente_id = ?, statusPedido_id = ?, entrega_id = ? WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pedido.getHoraPedido());
            stmt.setInt(2, pedido.getNumeroPedido());
            stmt.setDate(3, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setInt(4, pedido.getCliente().getId());
            stmt.setInt(5, pedido.getStatusPedido().getId());
            stmt.setInt(6, pedido.getEntrega().getId());
            stmt.setInt(7, pedido.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM pedido WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Pedido> listar() throws SQLException {
        List<Pedido> pedidos = new LinkedList<>();
        String sql = "SELECT id, horaPedido, numeroPedido, dataPedido, cliente_id, statusPedido_id, entrega_id FROM pedido";
        Connection con = Conexao.getConexao(); 
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
                status.setId(res.getInt("statusPedido_id"));
                pedido.setStatusPedido(status);

                Entrega entrega = new Entrega();
                entrega.setId(res.getInt("entrega_id"));
                pedido.setEntrega(entrega);

                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
}
