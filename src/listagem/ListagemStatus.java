/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
import controller.StatusPedidoController;
import dto.StatusPedidoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemStatus extends Listagem<StatusPedidoDTO> {

    private StatusPedidoController controller;

    public ListagemStatus(Frame parent, boolean modal) {
        super(parent, modal, "Lista de StatusPedidos");
        controller = new StatusPedidoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID StatusPedido", "Progresso do Pedido"};
    }

    @Override
    public Object[] toLinha(StatusPedidoDTO s) {
        return new Object[]{s.getIdStatPed(), s.getProgStatPed()};
    }

    @Override
    public List<StatusPedidoDTO> obterLista() {
        try {
        List<InterfaceDTO> listaGenerica = controller.listar();

        List<StatusPedidoDTO> listaStatusPedidos = new LinkedList<>();

        if (listaGenerica != null) {
            for (InterfaceDTO iDto : listaGenerica) {
                listaStatusPedidos.add((StatusPedidoDTO) iDto);
            }
        }
        return listaStatusPedidos;
        
        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }
}
