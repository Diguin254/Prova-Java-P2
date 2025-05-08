package implementsDao;

import bancoConexao.Conexao;
import dao.CupomDao;
import model.Cupom;
import model.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CupomImplements implements CupomDao {

    @Override
    public void salvar(Cupom cupom) throws SQLException {
        String sql = "INSERT INTO cupom (id, valorCupom, codigo, validade, pagamento_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cupom.getId());
            stmt.setDouble(2, cupom.getValorCupom());
            stmt.setString(3, cupom.getCodigo());
            stmt.setDate(4, new java.sql.Date(cupom.getValidade().getTime()));
            stmt.setInt(5, cupom.getPagamento().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Cupom cupom) throws SQLException {
        String sql = "UPDATE cupom SET valorCupom = ?, codigo = ?, validade = ?, pagamento_id = ? WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDouble(1, cupom.getValorCupom());
            stmt.setString(2, cupom.getCodigo());
            stmt.setDate(3, new java.sql.Date(cupom.getValidade().getTime()));
            stmt.setInt(4, cupom.getPagamento().getId());
            stmt.setInt(5, cupom.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM cupom WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Cupom> listar() throws SQLException {
        List<Cupom> cupons = new LinkedList<>();
        String sql = "SELECT id, valorCupom, codigo, validade, pagamento_id FROM cupom";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Cupom cupom = new Cupom();
                cupom.setId(res.getInt("id"));
                cupom.setValorCupom(res.getDouble("valorCupom"));
                cupom.setCodigo(res.getString("codigo"));
                cupom.setValidade(res.getDate("validade"));

                Pagamento pagamento = new Pagamento();
                pagamento.setId(res.getInt("pagamento_id"));
                cupom.setPagamento(pagamento);

                cupons.add(cupom);
            }
        }
        return cupons;
    }
}
