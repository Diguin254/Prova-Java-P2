package implementsDao;

import bancoConexao.Conexao;
import dao.ProdutoDao;
import model.Produto;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProdutoImplementsDAO implements ProdutoDao {

    Connection con;

    @Override
    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto(nome, valor_unitario) VALUES (?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValorUnitario());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome = ?, valor_unitario = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getValorUnitario());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new LinkedList<>();
        String sql = "SELECT id, nome, valor_unitario FROM produto";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                Produto produto = new Produto();
                produto.setId(res.getInt("id"));
                produto.setNome(res.getString("nome"));
                produto.setValorUnitario(res.getDouble("valor_unitario"));
                produtos.add(produto);
            }
        }
        return produtos;
    }
}
