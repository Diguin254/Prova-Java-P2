package implementsDao;

import bancoConexao.Conexao;
import dao.DinheiroDao;
import model.Dinheiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DinheiroImplements implements DinheiroDao {

    @Override
    public void salvar(Dinheiro dinheiro) throws SQLException {
        String sql = "INSERT INTO dinheiro (id, valorEntregado) VALUES (?, ?)";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, dinheiro.getId());
            stmt.setDouble(2, dinheiro.getValorEntregado());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Dinheiro dinheiro) throws SQLException {
        String sql = "UPDATE dinheiro SET valorEntregado = ? WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDouble(1, dinheiro.getValorEntregado());
            stmt.setInt(2, dinheiro.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM dinheiro WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Dinheiro> listar() throws SQLException {
        List<Dinheiro> dinheiros = new LinkedList<>();
        String sql = "SELECT id, valorEntregado FROM dinheiro";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Dinheiro dinheiro = new Dinheiro();
                dinheiro.setId(res.getInt("id"));
                dinheiro.setValorEntregado(res.getDouble("valorEntregado"));
                dinheiros.add(dinheiro);
            }
        }
        return dinheiros;
    }
}
