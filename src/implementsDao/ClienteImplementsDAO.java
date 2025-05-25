package implementsDao;

import bancoConexao.Conexao;
import dao.ClienteDao;
import model.Cliente;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClienteImplementsDAO implements ClienteDao {

    Connection con;

    @Override
    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (id, nome) VALUES (?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ? WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new LinkedList<>();
        String sql = "SELECT id, nome FROM cliente";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("id"));
                cliente.setNome(res.getString("nome"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}
