package implementsDao;

import bancoConexao.Conexao;
import dao.FuncionarioDao;
import model.Funcionario;
import model.Login;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Telefone;

public class FuncionarioImplementsDAO implements FuncionarioDao {

    Connection con;

    @Override
    public void salvar(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (id, nome, cpf, rg, login_id) VALUES (?, ?, ?, ?, ?)";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
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
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
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
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> funcionarios = new LinkedList<>();
        String sql = "SELECT id, nome, cpf, rg, login_id FROM funcionario";
        con = Conexao.getConexao();
        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {
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

    @Override
    public List<Funcionario> listarComTelefones() throws SQLException {
        String sql = "SELECT f.id AS fid, f.nome, f.cpf, f.rg, f.login_id, t.id AS tid, t.ddd, t.numero FROM funcionario f LEFT JOIN telefone t ON t.funcionario_id = f.id ORDER BY f.id";

        try (Connection con = Conexao.getConexao(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            Map<Integer, Funcionario> mapa = new LinkedHashMap<>();

            while (res.next()) {
                int fid = res.getInt("fid");
                Funcionario fun = mapa.get(fid);
                if (fun == null) {
                    fun = new Funcionario();
                    fun.setId(fid);
                    fun.setNome(res.getString("nome"));
                    fun.setCpf(res.getString("cpf"));
                    fun.setRg(res.getString("rg"));
                    Login l = new Login();
                    l.setId(res.getInt("login_id"));
                    fun.setLogin(l);
                    fun.setTelefones(new LinkedList<>());
                    mapa.put(fid, fun);
                }

                int tid = res.getInt("tid");
                if (!res.wasNull()) {
                    Telefone t = new Telefone();
                    t.setId(tid);
                    t.setDdd(res.getInt("ddd"));
                    t.setNumero(res.getString("numero"));
                    t.setFuncionario(fun);
                    fun.getTelefones().add(t);
                }
            }
            return new LinkedList<>(mapa.values());
        }
    }
}
