/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
import controller.IngredienteEscolhaController;
import dto.IngredienteEscolhaDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemEscolha extends Listagem<IngredienteEscolhaDTO> {

    private IngredienteEscolhaController controller;

    public ListagemEscolha(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Ingrediente Escolha");
        controller = new IngredienteEscolhaController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Ingrediente Escolha", "ID Carrinho"};
    }

    @Override
    public Object[] toLinha(IngredienteEscolhaDTO esc) {
        return new Object[]{esc.getIdIngrEsc(), esc.getIdCarrinho()};
    }

    @Override
    public List<IngredienteEscolhaDTO> obterLista() {
        try {
        List<InterfaceDTO> listaGenerica = controller.listar();

        List<IngredienteEscolhaDTO> listaIngredienteEscolhas = new LinkedList<>();

        if (listaGenerica != null) {
            for (InterfaceDTO iDto : listaGenerica) {
                listaIngredienteEscolhas.add((IngredienteEscolhaDTO) iDto);
            }
        }
        return listaIngredienteEscolhas;
        
        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }
}
