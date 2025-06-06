package implementsDao;

import bancoConexao.Conexao;
import dao.LoginDao;
import model.Login;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LoginImplementsDAO implements LoginDao {

    Connection con;

    @Override
    public void salvar(Login login) throws SQLException {
        String sql = "INSERT INTO login (password, login_funcionario) VALUES (?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, login.getPassword());
            stmt.setString(2, login.getLogin_funcionario());
            stmt.executeUpdate();
            
            try(ResultSet rs = stmt.getGeneratedKeys()) {
                if(rs.next()) {
                    login.setId(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void editar(Login login) throws SQLException {
        String sql = "UPDATE login SET password = ?, login_funcionario = ? WHERE id = ?";
        con = Conexao.getConexao();
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
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Login> listar() throws SQLException {
        List<Login> logins = new LinkedList<>();
        String sql = "SELECT id, password, login_funcionario FROM login";
        con = Conexao.getConexao();
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
