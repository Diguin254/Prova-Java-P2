package implementsDao;

import bancoConexao.Conexao;
import dao.CartaoDao;
import model.Cartao;

import java.sql.*;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CartaoImplementsDAO implements CartaoDao {

    Connection con;

    @Override
    public void salvar(Cartao cartao) throws SQLException {
        String sql = "INSERT INTO cartao (numeroCartao, ccv, tipoConta) VALUES (?, ?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cartao.getNumeroCartao());
            stmt.setInt(2, cartao.getCcv());
            stmt.setInt(3, cartao.getTipoConta());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Cartao cartao) throws SQLException {
        String sql = "UPDATE cartao SET numeroCartao = ?, ccv = ?, tipoConta = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cartao.getNumeroCartao());
            stmt.setInt(2, cartao.getCcv());
            stmt.setInt(3, cartao.getTipoConta());
            stmt.setInt(4, cartao.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM cartao WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Cartao> listar() throws SQLException {
        List<Cartao> cartoes = new LinkedList<>();
        String sql = "SELECT id, numeroCartao, ccv, tipoConta FROM cartao";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Cartao cartao = new Cartao();
                cartao.setId(res.getInt("id"));
                cartao.setNumeroCartao(res.getInt("numeroCartao"));
                cartao.setCcv(res.getInt("ccv"));
                cartao.setTipoConta(res.getInt("tipoConta"));
                cartoes.add(cartao);
            }
        }
        return cartoes;
    }
}
