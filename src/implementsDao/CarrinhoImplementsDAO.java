package implementsDao;

import bancoConexao.Conexao;
import dao.CarrinhoDao;
import model.Carrinho;
import model.IngredienteEscolha;
import model.Pedido;
import model.Produto;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarrinhoImplementsDAO implements CarrinhoDao {

    @Override
    public void salvar(Carrinho carrinho) throws SQLException {
        String sql = "INSERT INTO carrinho (id, qntd, pedido_id, produto_id, ingrediente_escolha_id) VALUES (?, ?, ?, ?, ?)";
        Connection con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, carrinho.getId());
            stmt.setInt(2, carrinho.getQntd());
            stmt.setInt(3, carrinho.getPedido().getId());
            stmt.setInt(4, carrinho.getProduto().getId());
            stmt.setInt(5, carrinho.getIngredienteEscolha().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Carrinho carrinho) throws SQLException {
        String sql = "UPDATE carrinho SET qntd = ?, pedido_id = ?, produto_id = ?, ingrediente_escolha_id = ? WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, carrinho.getQntd());
            stmt.setInt(2, carrinho.getPedido().getId());
            stmt.setInt(3, carrinho.getProduto().getId());
            stmt.setInt(4, carrinho.getIngredienteEscolha().getId());
            stmt.setInt(5, carrinho.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM carrinho WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Carrinho> listar() throws SQLException {
        List<Carrinho> carrinhos = new LinkedList<>();
        String sql = "SELECT id, qntd, pedido_id, produto_id, ingrediente_escolha_id FROM carrinho";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                Carrinho carrinho = new Carrinho();
                carrinho.setId(res.getInt("id"));
                carrinho.setQntd(res.getInt("qntd"));

                Pedido pedido = new Pedido();
                pedido.setId(res.getInt("pedido_id"));
                carrinho.setPedido(pedido);

                Produto produto = new Produto();
                produto.setId(res.getInt("produto_id"));
                carrinho.setProduto(produto);

                IngredienteEscolha ingredienteEscolha = new IngredienteEscolha();
                ingredienteEscolha.setId(res.getInt("ingrediente_escolha_id"));
                carrinho.setIngredienteEscolha(ingredienteEscolha);

                carrinhos.add(carrinho);
            }
        }

        return carrinhos;
    }
}
