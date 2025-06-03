/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
import controller.EntregaController;
import dto.EntregaDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemEntrega extends Listagem<EntregaDTO> {

    private EntregaController controller;

    public ListagemEntrega(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Entregas");
        controller = new EntregaController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Entrega", "Tipo de entrega", "ID Cliente", "ID Delivery", "ID Pedido", "ID Status Pedido"};
    }

    @Override
    public Object[] toLinha(EntregaDTO e) {
        return new Object[]{e.getIdEntrega(), e.getTipoEntregaE(), e.getIdCliente(), e.getIdDelivery(), e.getIdPedido(), e.getIdStatusPedido()};
    }

    @Override
    public List<EntregaDTO> obterLista() {
        try {
        List<InterfaceDTO> listaGenerica = controller.listar();

        List<EntregaDTO> listaEntregas = new LinkedList<>();

        if (listaGenerica != null) {
            for (InterfaceDTO iDto : listaGenerica) {
                listaEntregas.add((EntregaDTO) iDto);
            }
        }
        return listaEntregas;
        
        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }
}
