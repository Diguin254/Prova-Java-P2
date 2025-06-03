/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
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

    private FuncionarioController controller;

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
    public Object[] toLinha(FuncionarioDTO f) {
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
}
