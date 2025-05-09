package implementsDao;

import bancoConexao.Conexao;
import dao.LoginDao;
import model.Login;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LoginImplementsDAO implements LoginDao {

    @Override
    public void salvar(Login login) throws SQLException {
        String sql = "INSERT INTO login (id, password, login_funcionario) VALUES (?, ?, ?)";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, login.getId());
            stmt.setString(2, login.getPassword());
            stmt.setString(3, login.getLogin_funcionario());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Login login) throws SQLException {
        String sql = "UPDATE login SET password = ?, login_funcionario = ? WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, login.getPassword());
            stmt.setString(2, login.getLogin_funcionario());
            stmt.setInt(3, login.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM login WHERE id = ?";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Login> listar() throws SQLException {
        List<Login> logins = new LinkedList<>();
        String sql = "SELECT id, password, login_funcionario FROM login";
        Connection con = Conexao.getConexao(); 
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
            while (res.next()) {
                Login login = new Login();
                login.setId(res.getInt("id"));
                login.setPassword(res.getString("password"));
                login.setLogin_funcionario(res.getString("login_funcionario"));
                logins.add(login);
            }
        }
        return logins;
    }
}
