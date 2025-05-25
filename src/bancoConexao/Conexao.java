package bancoConexao;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    String url;
    String user;
    String password;
    private static Connection con;
    private static Conexao obj;

    private Conexao() {
        try {
            criarConexao();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexao(){
        if(con == null){
            if(obj == null){
                obj = new Conexao();
            }
        }
        return con;
    }
    
    public Connection criarConexao() throws SQLException {
        url = "jdbc:postgresql://localhost:5432/postgres";
        user = "postgres";
        password = "1234";
        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(true);
        return con;
    }
}
