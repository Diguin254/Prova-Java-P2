package implementsDao;

import bancoConexao.Conexao;
import dao.MetodoPagamentoDao;
import model.MetodoPagamento;
import model.Cartao;
import model.Dinheiro;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MetodoPagamentoImplementsDAO implements MetodoPagamentoDao {

    Connection con;

    @Override
    public void salvar(MetodoPagamento metodoPagamento) throws SQLException {
        String sql = "INSERT INTO metodoPagamento (id, pix, dinheiro_id, cartao_id) VALUES (?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, metodoPagamento.getPix());
            stmt.setInt(2, metodoPagamento.getDinheiro().getId());
            stmt.setInt(3, metodoPagamento.getCartao().getId());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    metodoPagamento.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(MetodoPagamento metodoPagamento) throws SQLException {
        String sql = "UPDATE metodoPagamento SET pix = ?, dinheiro_id = ?, cartao_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, metodoPagamento.getPix());
            stmt.setInt(2, metodoPagamento.getDinheiro().getId());
            stmt.setInt(3, metodoPagamento.getCartao().getId());
            stmt.setInt(4, metodoPagamento.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM metodoPagamento WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<MetodoPagamento> listar() throws SQLException {
        List<MetodoPagamento> metodosPagamentos = new LinkedList<>();
        String sql = "SELECT id, pix, dinheiro_id, cartao_id FROM metodoPagamento";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                MetodoPagamento metodoPagamento = new MetodoPagamento();
                metodoPagamento.setId(res.getInt("id"));
                metodoPagamento.setPix(res.getString("pix"));

                Dinheiro dinheiro = new Dinheiro();
                dinheiro.setId(res.getInt("dinheiro_id"));
                metodoPagamento.setDinheiro(dinheiro);

                Cartao cartao = new Cartao();
                cartao.setId(res.getInt("cartao_id"));
                metodoPagamento.setCartao(cartao);

                metodosPagamentos.add(metodoPagamento);
            }
        }
        return metodosPagamentos;
    }
}
