package controller;

import dao.FuncionarioDao;
import dao.LoginDao;
import dto.FuncionarioDTO;
import dto.LoginDTO;
import dto.InterfaceDTO;
import implementsDao.FuncionarioImplementsDAO;
import implementsDao.LoginImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Funcionario;
import model.Login;

public class LoginController extends InterfaceController {

    private final LoginDao loginDao = new LoginImplementsDAO();
    private final FuncionarioDao funcionarioDao = new FuncionarioImplementsDAO();

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        Login login = ((LoginDTO)dto).builder();
        loginDao.salvar(login);

        if (login.getFuncionarios() != null) {
            for (Funcionario f : login.getFuncionarios()) {
                f.setLogin(login);
                funcionarioDao.salvar(f);
            }
        }
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        Login login = ((LoginDTO)dto).builder();
        loginDao.salvar(login);

        if (login.getFuncionarios() != null) {
            for (Funcionario f : login.getFuncionarios()) {
                f.setLogin(login);
                if (f.getId() == 0) {
                    funcionarioDao.salvar(f);
                } else {
                    funcionarioDao.editar(f);
                }
            }
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        for (Funcionario f : funcionarioDao.listar()) {
            if (f.getLogin() != null && f.getLogin().getId().equals(id)) {
                funcionarioDao.deletar(f.getId());
            }
        }
        loginDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Login> listaLogins = loginDao.listar();
        List<Funcionario> listaFun = funcionarioDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();

        for (Login l : listaLogins) {
            List<Funcionario> funcionarios = new LinkedList<>();
            for (Funcionario f : listaFun) {
                if (f.getLogin() != null && f.getLogin().getId().equals(l.getId())) {
                    funcionarios.add(f);
                }
            }
            l.setFuncionarios(funcionarios);

            LoginDTO dto = new LoginDTO();
            dto.idLogin = String.valueOf(l.getId());
            dto.loginFun = l.getLogin_funcionario();
            dto.senhaLogin = l.getPassword();

            if (funcionarios != null && !funcionarios.isEmpty()) {
                dto.funcionarios = new LinkedList<>();
                for (Funcionario func : funcionarios) {
                    FuncionarioDTO fDto = new FuncionarioDTO();
                    fDto.nomeFun = func.getNome();
                    fDto.cpfFun = func.getCpf();
                    dto.funcionarios.add(fDto);
                }
            }

            listaDTO.add((InterfaceDTO) dto);
        }

        return listaDTO;
    }
}
