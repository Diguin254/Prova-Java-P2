/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelLogin;
import controller.LoginController;
import dto.LoginDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemLogin extends Listagem<LoginDTO> {

    private final LoginController controller;

    public ListagemLogin(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Logins");
        controller = new LoginController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Login", "Nome do funcionário", "Senha"};
    }

    @Override
    public Object[] linha(LoginDTO l) {
        return new Object[]{l.getIdLogin(), l.getLoginFun(), l.getSenhaLogin()};
    }

    @Override
    public List<LoginDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<LoginDTO> listaLogins = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaLogins.add((LoginDTO) iDto);
                }
            }
            return listaLogins;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(LoginDTO objeto) throws SQLException {
        PainelLogin painel = new PainelLogin();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(LoginDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(LoginDTO objeto) {
        return objeto.getIdLogin();
    }
}
