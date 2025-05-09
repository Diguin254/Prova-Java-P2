package implementsDao;

import bancoConexao.Conexao;
import dao.FuncionarioDao;
import model.Funcionario;
import model.Login;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FuncionarioImplementsDAO implements FuncionarioDao {

    @Override
    public void salvar(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (id, nome, cpf, rg, login_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getRg());
            stmt.setInt(5, funcionario.getLogin().getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, rg = ?, login_id = ? WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getRg());
            stmt.setInt(4, funcionario.getLogin().getId());
            stmt.setInt(5, funcionario.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> funcionarios = new LinkedList<>();
        String sql = "SELECT id, nome, cpf, rg, login_id FROM funcionario";
        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(res.getInt("id"));
                funcionario.setNome(res.getString("nome"));
                funcionario.setCpf(res.getString("cpf"));
                funcionario.setRg(res.getString("rg"));

                Login login = new Login();
                login.setId(res.getInt("login_id"));
                funcionario.setLogin(login);

                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
}
