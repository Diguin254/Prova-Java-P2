/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
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

    private IngredienteRemoverController controller;

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
    public Object[] toLinha(IngredienteRemoverDTO rem) {
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
}
