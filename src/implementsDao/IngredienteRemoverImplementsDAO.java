package implementsDao;

import bancoConexao.Conexao;
import dao.IngredienteRemoverDao;
import model.IngredienteRemover;
import model.IngredienteEscolha;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class IngredienteRemoverImplementsDAO implements IngredienteRemoverDao {

    Connection con;

    @Override
    public void salvar(IngredienteRemover ingredienteRemover) throws SQLException {
        String sql = "INSERT INTO ingredienteRemover (nome, ingredienteEscolha_id) VALUES (?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, ingredienteRemover.getNome());
            stmt.setInt(2, ingredienteRemover.getIngredienteEscolha().getId());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    ingredienteRemover.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(IngredienteRemover ingredienteRemover) throws SQLException {
        String sql = "UPDATE ingredienteRemover SET nome = ?, ingredienteEscolha_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ingredienteRemover.getNome());
            stmt.setInt(2, ingredienteRemover.getIngredienteEscolha().getId());
            stmt.setInt(3, ingredienteRemover.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM ingredienteRemover WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<IngredienteRemover> listar() throws SQLException {
        List<IngredienteRemover> ingredientesRemover = new LinkedList<>();
        String sql = "SELECT id, nome, ingredienteEscolha_id FROM ingredienteRemover";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                IngredienteRemover ingredienteRemover = new IngredienteRemover();
                ingredienteRemover.setId(res.getInt("id"));
                ingredienteRemover.setNome(res.getString("nome"));

                IngredienteEscolha escolha = new IngredienteEscolha();
                escolha.setId(res.getInt("ingredienteEscolha_id"));
                ingredienteRemover.setIngredienteEscolha(escolha);

                ingredientesRemover.add(ingredienteRemover);
            }
        }
        return ingredientesRemover;
    }
}
