/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelIngredienteEscolha;
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

    private final IngredienteEscolhaController controller;

    public ListagemEscolha(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Ingrediente Escolha");
        controller = new IngredienteEscolhaController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Ingrediente Escolha", "ID IngredienteEscolha"};
    }

    @Override
    public Object[] linha(IngredienteEscolhaDTO esc) {
        return new Object[]{esc.getIdIngrEsc(), esc.getIdIngrEsc()};
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

    @Override
    public void onEditar(IngredienteEscolhaDTO objeto) throws SQLException{
        PainelIngredienteEscolha painel = new PainelIngredienteEscolha();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(IngredienteEscolhaDTO objeto) throws SQLException{
            controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(IngredienteEscolhaDTO objeto) {
        return objeto.getIdIngrEsc();
    }
}
