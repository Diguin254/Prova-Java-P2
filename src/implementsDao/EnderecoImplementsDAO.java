package implementsDao;

import bancoConexao.Conexao;
import dao.EnderecoDao;
import model.Endereco;
import model.Bairro;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EnderecoImplementsDAO implements EnderecoDao {

    Connection con;

    @Override
    public void salvar(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO endereco (rua, cep, bairro_id, distancia) VALUES (?, ?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getCep());
            stmt.setInt(3, endereco.getBairro().getId());
            
            double d;
            
            try {
                String texto = endereco.getDistancia().replace(",", ".");
                d = Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                throw new SQLException("Valor de distância inválido: \"" + endereco.getDistancia() + "\"");
            }
            
            stmt.setDouble(4, d);
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    endereco.setId(rs.getInt(1));
                }
            }
            
        }
    }

    @Override
    public void editar(Endereco endereco) throws SQLException {
        String sql = "UPDATE endereco SET rua = ?, cep = ?, bairro_id = ?, distancia = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getCep());
            stmt.setInt(3, endereco.getBairro().getId());
            stmt.setString(4, endereco.getDistancia());
            stmt.setInt(5, endereco.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM endereco WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Endereco> listar() throws SQLException {
        List<Endereco> enderecos = new LinkedList<>();
        String sql = "SELECT id, rua, cep, bairro_id, distancia FROM endereco";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(res.getInt("id"));
                endereco.setRua(res.getString("rua"));
                endereco.setCep(res.getString("cep"));

                Bairro bairro = new Bairro();
                bairro.setId(res.getInt("bairro_id"));
                endereco.setBairro(bairro);

                endereco.setDistancia(res.getString("distancia"));
                enderecos.add(endereco);
            }
        }
        return enderecos;
    }
}
