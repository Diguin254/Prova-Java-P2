/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
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

    private TaxaEntregaController controller;

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
    public Object[] toLinha(TaxaEntregaDTO tx) {
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
}
