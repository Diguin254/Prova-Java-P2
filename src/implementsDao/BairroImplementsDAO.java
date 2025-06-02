package implementsDao;

import bancoConexao.Conexao;
import dao.BairroDao;
import model.Bairro;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BairroImplementsDAO implements BairroDao {
    Connection con;
    @Override
    public void salvar(Bairro bairro) throws SQLException {
        String sql = "INSERT INTO bairro(nome)VALUES(?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, bairro.getNome());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    bairro.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(Bairro bairro) throws SQLException {
        String sql = "UPDATE bairro SET nome = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, bairro.getNome());
            stmt.setInt(2, bairro.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM bairro WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Bairro> listar() throws SQLException {
        List<Bairro> bairros = new LinkedList<>();
        String sql = "SELECT id, nome FROM bairro";
        con = Conexao.getConexao();
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
