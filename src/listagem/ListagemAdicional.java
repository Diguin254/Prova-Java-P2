/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelIngredienteAdicional;
import controller.IngredienteAdicionalController;
import dto.IngredienteAdicionalDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemAdicional extends Listagem<IngredienteAdicionalDTO> {

    private final IngredienteAdicionalController controller;

    public ListagemAdicional(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Ingredientes Adicionais");
        controller = new IngredienteAdicionalController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Ingrediente Adicional", "Nome do Ingrediente", "Valor do Ingrediente"};
    }

    @Override
    public Object[] linha(IngredienteAdicionalDTO c) {
        return new Object[]{c.getIdIngrAdc(), c.getNomeIngrAdc(), c.getValorIngrAdc()};
    }

    @Override
    public List<IngredienteAdicionalDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<IngredienteAdicionalDTO> listaClientes = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaClientes.add((IngredienteAdicionalDTO) iDto);
                }
            }
            return listaClientes;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(IngredienteAdicionalDTO objeto) throws SQLException{
        PainelIngredienteAdicional painel = new PainelIngredienteAdicional();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(IngredienteAdicionalDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(IngredienteAdicionalDTO objeto) {
        return objeto.getIdIngrAdc();
    }
}
