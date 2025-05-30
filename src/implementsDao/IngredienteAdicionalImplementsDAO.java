package implementsDao;

import bancoConexao.Conexao;
import dao.IngredienteAdicionalDao;
import model.IngredienteAdicional;
import model.IngredienteEscolha;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class IngredienteAdicionalImplementsDAO implements IngredienteAdicionalDao {

    Connection con;

    @Override
    public void salvar(IngredienteAdicional ingredienteAdicional) throws SQLException {
        String sql = "INSERT INTO ingredienteAdicional (nome, valor, ingredienteEscolha_id) VALUES (?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDouble(1, ingredienteAdicional.getValor());
            stmt.setInt(2, ingredienteAdicional.getIngredienteEscolha().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(IngredienteAdicional ingredienteAdicional) throws SQLException {
        String sql = "UPDATE ingredienteAdicional SET nome = ?, valor = ?, ingredienteEscolha_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, ingredienteAdicional.getNome());
            stmt.setDouble(2, ingredienteAdicional.getValor());
            stmt.setInt(3, ingredienteAdicional.getIngredienteEscolha().getId());
            stmt.setInt(4, ingredienteAdicional.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM ingredienteAdicional WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<IngredienteAdicional> listar() throws SQLException {
        List<IngredienteAdicional> ingredientesAdicionais = new LinkedList<>();
        String sql = "SELECT id, nome, valor, ingredienteEscolha_id FROM ingredienteAdicional";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                IngredienteAdicional ingredienteAdicional = new IngredienteAdicional();
                ingredienteAdicional.setId(res.getInt("id"));
                ingredienteAdicional.setNome(res.getString("nome"));
                ingredienteAdicional.setValor(res.getDouble("valor"));

                IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
                ingredienteEscolha.setId(res.getInt("ingredienteEscolha_id"));
                ingredienteAdicional.setIngredienteEscolha(ingredienteEscolha);

                ingredientesAdicionais.add(ingredienteAdicional);
            }
        }
        return ingredientesAdicionais;
    }
}
