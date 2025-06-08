/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelIngredienteRemover;
import controller.IngredienteRemoverController;
import dto.IngredienteRemoverDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author IngredienteRemover
 */
public class ListagemRemover extends Listagem<IngredienteRemoverDTO> {

    private final IngredienteRemoverController controller;

    public ListagemRemover(Frame parent, boolean modal) {
        super(parent, modal, "Lista de IngredienteRemovers");
        controller = new IngredienteRemoverController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID IngredienteRemover", "Nome do Ingrediente Remover", "ID Ingrediente Escolha"};
    }

    @Override
    public Object[] linha(IngredienteRemoverDTO rem) {
        return new Object[]{rem.getIdIngrRem(), rem.getNomeIngrRem(), rem.getIdIngrEsco()};
    }

    @Override
    public List<IngredienteRemoverDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<IngredienteRemoverDTO> listaIngredienteRemovers = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaIngredienteRemovers.add((IngredienteRemoverDTO) iDto);
                }
            }
            return listaIngredienteRemovers;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(IngredienteRemoverDTO objeto) throws SQLException{
        PainelIngredienteRemover painel = new PainelIngredienteRemover();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(IngredienteRemoverDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(IngredienteRemoverDTO objeto) {
        return objeto.getIdIngrRem();
    }
}
