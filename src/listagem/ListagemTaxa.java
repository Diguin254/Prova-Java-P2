/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelTaxaEntrega;
import controller.TaxaEntregaController;
import dto.TaxaEntregaDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemTaxa extends Listagem<TaxaEntregaDTO> {

    private final TaxaEntregaController controller;

    public ListagemTaxa(Frame parent, boolean modal) {
        super(parent, modal, "Lista de TaxaEntregas");
        controller = new TaxaEntregaController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID TaxaEntrega", "Valor da Entrega", "ID Endereço"};
    }

    @Override
    public Object[] linha(TaxaEntregaDTO tx) {
        return new Object[]{tx.getIdTaxaEnt(), tx.getValEntrega(), tx.getIdEnd()};
    }

    @Override
    public List<TaxaEntregaDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<TaxaEntregaDTO> listaTaxaEntregas = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaTaxaEntregas.add((TaxaEntregaDTO) iDto);
                }
            }
            return listaTaxaEntregas;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(TaxaEntregaDTO objeto) throws SQLException {
        PainelTaxaEntrega painel = new PainelTaxaEntrega();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(TaxaEntregaDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(TaxaEntregaDTO objeto) {
        return objeto.getIdTaxaEnt();
    }
}
