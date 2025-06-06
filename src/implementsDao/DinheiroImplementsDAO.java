package implementsDao;

import bancoConexao.Conexao;
import dao.DinheiroDao;
import model.Dinheiro;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DinheiroImplementsDAO implements DinheiroDao {

    Connection con;

    @Override
    public void salvar(Dinheiro dinheiro) throws SQLException {
        String sql = "INSERT INTO dinheiro (valorEntregado) VALUES (?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDouble(1, dinheiro.getValorEntregado());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    dinheiro.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(Dinheiro dinheiro) throws SQLException {
        String sql = "UPDATE dinheiro SET valorEntregado = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDouble(1, dinheiro.getValorEntregado());
            stmt.setInt(2, dinheiro.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM dinheiro WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Dinheiro> listar() throws SQLException {
        List<Dinheiro> dinheiros = new LinkedList<>();
        String sql = "SELECT id, valorEntregado FROM dinheiro";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
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
