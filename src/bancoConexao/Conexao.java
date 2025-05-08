package bancoConexao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/bancoprova";
    private static final String USUARIO = "user";
    private static final String SENHA = "password";
    private static Connection con;

    private Conexao() {

    }

    public static Connection getConexao() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (SQLException e) {
                throw new RuntimeException("Erro na conexão com o banco de dados", e);
            }
        }
        return con;
    }
}
