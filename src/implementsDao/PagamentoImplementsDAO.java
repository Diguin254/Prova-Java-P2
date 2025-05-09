package implementsDao;

import bancoConexao.Conexao;
import dao.PagamentoDao;
import model.Pagamento;
import model.MetodoPagamento;
import model.Cupom;
import model.Pedido;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PagamentoImplementsDAO implements PagamentoDao {

    @Override
    public void salvar(Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO pagamento (id, metodoPagamento_id, cupom_id, pedido_id) VALUES (?, ?, ?, ?)";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getId());
            stmt.setInt(2, pagamento.getMetodoPagamento().getId());
            stmt.setInt(3, pagamento.getCupom().getId());
            stmt.setInt(4, pagamento.getPedido().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Pagamento pagamento) throws SQLException {
        String sql = "UPDATE pagamento SET metodoPagamento_id = ?, cupom_id = ?, pedido_id = ? WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getMetodoPagamento().getId());
            stmt.setInt(2, pagamento.getCupom().getId());
            stmt.setInt(3, pagamento.getPedido().getId());
            stmt.setInt(4, pagamento.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM pagamento WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Pagamento> listar() throws SQLException {
        List<Pagamento> pagamentos = new LinkedList<>();
        String sql = "SELECT id, metodoPagamento_id, cupom_id, pedido_id FROM pagamento";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setId(res.getInt("id"));

                MetodoPagamento metodoPagamento = new MetodoPagamento();
                metodoPagamento.setId(res.getInt("metodoPagamento_id"));
                pagamento.setMetodoPagamento(metodoPagamento);

                Cupom cupom = new Cupom();
                cupom.setId(res.getInt("cupom_id"));
                pagamento.setCupom(cupom);

                Pedido pedido = new Pedido();
                pedido.setId(res.getInt("pedido_id"));
                pagamento.setPedido(pedido);

                pagamentos.add(pagamento);
            }
        }
        return pagamentos;
    }
}
