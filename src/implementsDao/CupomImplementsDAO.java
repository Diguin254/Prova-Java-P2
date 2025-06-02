package implementsDao;

import bancoConexao.Conexao;
import dao.CupomDao;
import model.Cupom;
import model.Pagamento;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CupomImplementsDAO implements CupomDao {

    Connection con;

    @Override
    public void salvar(Cupom cupom) throws SQLException {
        String sql = "INSERT INTO cupom (valorCupom, codigo, validade) VALUES (?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDouble(1, cupom.getValorCupom());
            stmt.setString(2, cupom.getCodigo());
            stmt.setDate(3, new java.sql.Date(cupom.getValidade().getTime()));
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cupom.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(Cupom cupom) throws SQLException {
        String sql = "UPDATE cupom SET valorCupom = ?, codigo = ?, validade = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDouble(1, cupom.getValorCupom());
            stmt.setString(2, cupom.getCodigo());
            stmt.setDate(3, new java.sql.Date(cupom.getValidade().getTime()));
            stmt.setInt(4, cupom.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM cupom WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Cupom> listar() throws SQLException {
        List<Cupom> cupons = new LinkedList<>();
        String sql = "SELECT id, valorCupom, codigo, validade FROM cupom";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Cupom cupom = new Cupom();
                cupom.setId(res.getInt("id"));
                cupom.setValorCupom(res.getDouble("valorCupom"));
                cupom.setCodigo(res.getString("codigo"));
                cupom.setValidade(res.getDate("validade"));

                cupons.add(cupom);
            }
        }
        return cupons;
    }
}
