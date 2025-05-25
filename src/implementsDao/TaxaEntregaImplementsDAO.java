package implementsDao;

import bancoConexao.Conexao;
import dao.TaxaEntregaDao;
import model.TaxaEntrega;
import model.Endereco;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TaxaEntregaImplementsDAO implements TaxaEntregaDao {

    Connection con;

    @Override
    public void salvar(TaxaEntrega taxaEntrega) throws SQLException {
        String sql = "INSERT INTO taxaEntrega(id, taxa_entrega, endereco_id) VALUES (?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, taxaEntrega.getId());
            stmt.setDouble(2, taxaEntrega.getTaxa_entrega());
            stmt.setInt(3, taxaEntrega.getEndereco().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(TaxaEntrega taxaEntrega) throws SQLException {
        String sql = "UPDATE taxaEntrega SET taxa_entrega = ?, endereco_id = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDouble(1, taxaEntrega.getTaxa_entrega());
            stmt.setInt(2, taxaEntrega.getEndereco().getId());
            stmt.setInt(3, taxaEntrega.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM taxaEntrega WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<TaxaEntrega> listar() throws SQLException {
        List<TaxaEntrega> taxasEntregas = new LinkedList<>();
        String sql = "SELECT id, taxa_entrega, endereco_id FROM taxaEntrega";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                TaxaEntrega taxaEntrega = new TaxaEntrega();
                taxaEntrega.setId(res.getInt("id"));
                taxaEntrega.setTaxa_entrega(res.getDouble("taxa_entrega"));

                Endereco endereco = new Endereco();
                endereco.setId(res.getInt("endereco_id"));
                taxaEntrega.setEndereco(endereco);

                taxasEntregas.add(taxaEntrega);
            }
        }
        return taxasEntregas;
    }
}
