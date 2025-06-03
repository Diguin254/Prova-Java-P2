package implementsDao;

import bancoConexao.Conexao;
import dao.PagamentoDao;
import model.Pagamento;
import model.MetodoPagamento;
import model.Cupom;
import model.Pedido;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PagamentoImplementsDAO implements PagamentoDao {

    Connection con;

    @Override
    public void salvar(Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO pagamento (metodo_pagamento_id, cupom_id, pedido_id) VALUES (?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pagamento.getMetodoPagamento().getId());
            stmt.setInt(2, pagamento.getCupom().getId());
            stmt.setInt(3, pagamento.getPedido().getId());
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pagamento.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(Pagamento pagamento) throws SQLException {
        String sql = "UPDATE pagamento SET metodo_pagamento_id = ?, cupom_id = ?, pedido_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getMetodoPagamento().getId());
            stmt.setInt(2, pagamento.getCupom().getId());
            stmt.setInt(3, pagamento.getPedido().getId());
            stmt.setInt(4, pagamento.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM pagamento WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Pagamento> listar() throws SQLException {
        List<Pagamento> pagamentos = new LinkedList<>();
        String sql = "SELECT id, metodo_pagamento_id, cupom_id, pedido_id FROM pagamento";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setId(res.getInt("id"));

                MetodoPagamento metodoPagamento = new MetodoPagamento();
                metodoPagamento.setId(res.getInt("metodo_pagamento_id"));
                pagamento.setMetodoPagamento(metodoPagamento);

                Cupom cupom = new Cupom();
                cupom.setId(res.getInt("cupom_id"));
                pagamento.setCupom(cupom);

                Pedido pedido = new Pedido();
                pedido.setId(res.getInt("pedido_id"));
                pagamento.setPedido(pedido);

                pagamentos.add(pagamento);
            }
        }
        return pagamentos;
    }
}
