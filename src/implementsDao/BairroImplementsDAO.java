package implementsDao;

import bancoConexao.Conexao;
import dao.BairroDao;
import model.Bairro;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BairroImplementsDAO implements BairroDao {

    @Override
    public void salvar(Bairro bairro) throws SQLException {
        String sql = "INSERT INTO bairro(id, nome)VALUES(?,?)";
        Connection con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, bairro.getId());
            stmt.setString(2, bairro.getNome());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Bairro bairro) throws SQLException {
        String sql = "UPDATE bairro SET nome = ? WHERE id = ?";
        Connection con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, bairro.getNome());
            stmt.setInt(2, bairro.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM bairro WHERE id = ?";
        Connection con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Bairro> listar() throws SQLException {
        List<Bairro> bairros = new LinkedList<>();
        String sql = "SELECT id, nome FROM bairro";
        Connection con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Bairro bairro = new Bairro();
                bairro.setId(res.getInt("id"));
                bairro.setNome(res.getString("nome"));
                bairros.add(bairro);
            }
        }

        return bairros;
    }
}
