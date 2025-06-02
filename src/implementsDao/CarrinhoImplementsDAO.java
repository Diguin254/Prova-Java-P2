package implementsDao;

import bancoConexao.Conexao;
import dao.CarrinhoDao;
import model.Carrinho;
import model.Pedido;
import model.Produto;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarrinhoImplementsDAO implements CarrinhoDao {

    Connection con;

    @Override
    public void salvar(Carrinho carrinho) throws SQLException {
        String sql = "INSERT INTO carrinho (qntd, pedido_id, produto_id) VALUES (?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, carrinho.getQntd());
            stmt.setInt(2, carrinho.getPedido().getId());
            stmt.setInt(3, carrinho.getProduto().getId());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    carrinho.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(Carrinho carrinho) throws SQLException {
        String sql = "UPDATE carrinho SET qntd = ?, pedido_id = ?, produto_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, carrinho.getQntd());
            stmt.setInt(2, carrinho.getPedido().getId());
            stmt.setInt(3, carrinho.getProduto().getId());
            stmt.setInt(4, carrinho.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM carrinho WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Carrinho> listar() throws SQLException {
        List<Carrinho> carrinhos = new LinkedList<>();
        String sql = "SELECT id, qntd, pedido_id, produto_id FROM carrinho";
        con = Conexao.getConexao();
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

                carrinhos.add(carrinho);
            }
        }

        return carrinhos;
    }
}
