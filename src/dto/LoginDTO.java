package dto;

import java.util.LinkedList;
import java.util.List;
import model.Login;
import model.Funcionario;

public class LoginDTO implements InterfaceDTO{

    public LoginDTO() {
    }

    public String idLogin;
    public String senhaLogin;
    public String loginFun;
    public List<FuncionarioDTO> funcionarios ;

    public Login builder() {
        if (loginFun == null || loginFun.trim().isEmpty()) {
            throw new IllegalArgumentException("Login não pode ficar vazio");
        }
        if (senhaLogin == null || senhaLogin.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ficar vazia");
        }

        Login l = new Login();
        l.setId(idLogin == null ? 0 : Integer.valueOf(idLogin));
        l.setPassword(senhaLogin);
        l.setLogin_funcionario(loginFun);

        List<Funcionario> listaFun = new LinkedList<>();
        if (funcionarios != null) {
            for (FuncionarioDTO dto : funcionarios) {
                Funcionario fun = dto.builder();
                fun.setLogin(l);
                listaFun.add(fun);
            }
        }
        l.setFuncionarios(listaFun);

        return l;
    }
}
