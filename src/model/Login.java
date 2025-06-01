package model;

import java.util.List;

public class Login {

    private Integer id;
    private String password;
    private String login_funcionario;
    private List<Funcionario> funcionarios;

    public Login() {
    }

    public Login(Integer id, String password, String login_funcionario, List<Funcionario> funcionarios) {
        this.id = id;
        this.password = password;
        this.login_funcionario = login_funcionario;
        this.funcionarios = funcionarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin_funcionario() {
        return login_funcionario;
    }

    public void setLogin_funcionario(String login_funcionario) {
        this.login_funcionario = login_funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", password=" + password + ", login_funcionario=" + login_funcionario + ", funcionarios=" + funcionarios + '}';
    }

}
