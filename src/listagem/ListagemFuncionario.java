/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelFuncionario;
import controller.FuncionarioController;
import dto.FuncionarioDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemFuncionario extends Listagem<FuncionarioDTO> {

    private final FuncionarioController controller;

    public ListagemFuncionario(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Funcionarios");
        controller = new FuncionarioController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Funcionario", "Nome", "CPF", "RG"};
    }

    @Override
    public Object[] linha(FuncionarioDTO f) {
        return new Object[]{f.getIdFuncionario(), f.getNomeFun(), f.getCpfFun(), f.getRgFun()};
    }

    @Override
    public List<FuncionarioDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<FuncionarioDTO> listaFuncionarios = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaFuncionarios.add((FuncionarioDTO) iDto);
                }
            }
            return listaFuncionarios;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(FuncionarioDTO objeto) throws SQLException {
        PainelFuncionario painel = new PainelFuncionario();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(FuncionarioDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(FuncionarioDTO objeto) {
        return objeto.getIdFuncionario();
    }
}
