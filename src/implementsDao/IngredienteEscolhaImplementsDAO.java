package implementsDao;

import bancoConexao.Conexao;
import dao.IngredienteEscolhaDao;
import model.Carrinho;
import model.IngredienteEscolha;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class IngredienteEscolhaImplementsDAO implements IngredienteEscolhaDao {

    Connection con;

    @Override
    public void salvar(IngredienteEscolha ingredienteEscolha) throws SQLException {
        String sql = "INSERT INTO ingredienteEscolha (carrinho_id) VALUES (?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, ingredienteEscolha.getCarrinho().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(IngredienteEscolha ingredienteEscolha) throws SQLException {
        String sql = "UPDATE ingredienteEscolha SET carrinho_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, ingredienteEscolha.getCarrinho().getId());
            stmt.setInt(2, ingredienteEscolha.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM ingredienteEscolha WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<IngredienteEscolha> listar() throws SQLException {
        List<IngredienteEscolha> ingredientesEscolha = new LinkedList<>();
        String sql = "SELECT id, carrinho_id FROM ingredienteEscolha";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
                ingredienteEscolha.setId(res.getInt("id"));

                Carrinho carrinho = new Carrinho();
                carrinho.setId(res.getInt("carrinho_id"));
                ingredienteEscolha.setCarrinho(carrinho);

                ingredientesEscolha.add(ingredienteEscolha);
            }
        }
        return ingredientesEscolha;
    }
}
