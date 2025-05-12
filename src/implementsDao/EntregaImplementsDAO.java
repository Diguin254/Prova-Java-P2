package implementsDao;

import bancoConexao.Conexao;
import dao.EntregaDao;
import model.Entrega;
import model.Cliente;
import model.Pedido;
import model.StatusPedido;
import model.Delivery;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EntregaImplementsDAO implements EntregaDao {

    @Override
    public void salvar(Entrega entrega) throws SQLException {
        String sql = "INSERT INTO entrega (id, cliente_id, tipoEntrega, delivery_id, pedido_id, status_pedido_id) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, entrega.getId());
            stmt.setInt(2, entrega.getCliente().getId());
            stmt.setInt(3, entrega.getTipoEntrega());
            stmt.setInt(4, entrega.getDelivery().getId());
            stmt.setInt(5, entrega.getPedido().getId());
            stmt.setInt(6, entrega.getStatusPedido().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Entrega entrega) throws SQLException {
        String sql = "UPDATE entrega SET cliente_id = ?, tipoEntrega = ?, delivery_id = ?, pedido_id = ?, status_pedido_id = ? WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, entrega.getCliente().getId());
            stmt.setInt(2, entrega.getTipoEntrega());
            stmt.setInt(3, entrega.getDelivery().getId());
            stmt.setInt(4, entrega.getPedido().getId());
            stmt.setInt(5, entrega.getStatusPedido().getId());
            stmt.setInt(6, entrega.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM entrega WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Entrega> listar() throws SQLException {
        List<Entrega> entregas = new LinkedList<>();
        String sql = "SELECT id, cliente_id, tipoEntrega, delivery_id, pedido_id, status_pedido_id FROM entrega";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Entrega entrega = new Entrega();
                entrega.setId(res.getInt("id"));

                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("cliente_id"));
                entrega.setCliente(cliente);

                entrega.setTipoEntrega(res.getInt("tipoEntrega"));

                Delivery delivery = new Delivery();
                delivery.setId(res.getInt("delivery_id"));
                entrega.setDelivery(delivery);

                Pedido pedido = new Pedido();
                pedido.setId(res.getInt("pedido_id"));
                entrega.setPedido(pedido);

                StatusPedido statusPedido = new StatusPedido();
                statusPedido.setId(res.getInt("status_pedido_id"));
                entrega.setStatusPedido(statusPedido);

                entregas.add(entrega);
            }
        }
        return entregas;
    }
}
