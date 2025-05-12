package controller;

import dao.FuncionarioDao;
import dao.LoginDao;
import dto.FuncionarioDTO;
import dto.LoginDTO;
import implementsDao.FuncionarioImplementsDAO;
import implementsDao.LoginImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Funcionario;
import model.Login;

public class LoginController {

    private final LoginDao loginDao;
    private final FuncionarioDao funcionarioDao;

    public LoginController() {
        this.loginDao = new LoginImplementsDAO();
        this.funcionarioDao = new FuncionarioImplementsDAO();
    }

    public void salvar(LoginDTO loginDTO) throws SQLException {
        Login l = loginDTO.builder();
        loginDao.salvar(l);

        if (l.getFuncionarios() != null) {
            for (Funcionario f : l.getFuncionarios()) {
                f.setLogin(l);
                funcionarioDao.salvar(f);
            }
        }
    }

    public void editar(LoginDTO loginDTO) throws SQLException {
        Login l = loginDTO.builder();
        loginDao.editar(l);

        if (l.getFuncionarios() != null) {
            for (Funcionario f : l.getFuncionarios()) {
                f.setLogin(l);
                if (f.getId() == 0) {
                    funcionarioDao.salvar(f);
                } else {
                    funcionarioDao.editar(f);
                }
            }
        }
    }

    public void deletar(int id) throws SQLException {
        List<Funcionario> todos = funcionarioDao.listar();

        for (Funcionario f : todos) {
            if (f.getLogin() != null && f.getLogin().getId().equals(id)) {
                funcionarioDao.deletar(f.getId());
            }
        }

        loginDao.deletar(id);
    }

    public List<LoginDTO> listar() throws SQLException {
        List<Login> lista = loginDao.listar();
        List<LoginDTO> listaDTO = new LinkedList<>();
        List<Funcionario> listaFun = funcionarioDao.listar();

        for (Login l : lista) {
            List<Funcionario> funcionarios = new LinkedList<>();
            for (Funcionario fun : listaFun) {
                if (fun.getLogin() != null && fun.getLogin().getId() == l.getId()) {
                    funcionarios.add(fun);
                }
            }
            l.setFuncionarios(funcionarios);

            LoginDTO dto = new LoginDTO();
            dto.idLogin = String.valueOf(l.getId());
            dto.senhaLogin = l.getPassword();
            dto.loginFun = l.getLogin_funcionario();

            if (funcionarios != null) {
                List<FuncionarioDTO> funDtos = new LinkedList<>();
                for (Funcionario func : funcionarios) {
                    FuncionarioDTO fDto = new FuncionarioDTO();
                    fDto.nomeFun = func.getNome();
                    fDto.cpfFun = func.getCpf();
                    funDtos.add(fDto);
                }
                dto.funcionarios = funDtos;
            }
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
