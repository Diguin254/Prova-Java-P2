package implementsDao;

import bancoConexao.Conexao;
import dao.TelefoneDao;
import model.Telefone;
import model.Cliente;
import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TelefoneImplements implements TelefoneDao {

    @Override
    public void salvar(Telefone telefone) throws SQLException {
        String sql = "INSERT INTO telefone(id, ddd, numero, cliente_id, funcionario_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, telefone.getId());
            stmt.setInt(2, telefone.getDdd());
            stmt.setString(3, telefone.getNumero());
            stmt.setInt(4, telefone.getCliente().getId());
            stmt.setInt(5, telefone.getFuncionario().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Telefone telefone) throws SQLException {
        String sql = "UPDATE telefone SET ddd = ?, numero = ?, cliente_id = ?, funcionario_id = ? WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, telefone.getDdd());
            stmt.setString(2, telefone.getNumero());
            stmt.setInt(3, telefone.getCliente().getId());
            stmt.setInt(4, telefone.getFuncionario().getId());
            stmt.setInt(5, telefone.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM telefone WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Telefone> listar() throws SQLException {
        List<Telefone> telefones = new LinkedList<>();
        String sql = "SELECT id, ddd, numero, cliente_id, funcionario_id FROM telefone";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                Telefone telefone = new Telefone();
                telefone.setId(res.getInt("id"));
                telefone.setDdd(res.getInt("ddd"));
                telefone.setNumero(res.getString("numero"));

                Cliente cliente = new Cliente();
                cliente.setId(res.getInt("cliente_id"));
                telefone.setCliente(cliente);

                Funcionario funcionario = new Funcionario();
                funcionario.setId(res.getInt("funcionario_id"));
                telefone.setFuncionario(funcionario);

                telefones.add(telefone);
            }
        }
        return telefones;
    }
}
