/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelPedido;
import controller.PedidoController;
import dto.PedidoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemPedido extends Listagem<PedidoDTO> {

    private final PedidoController controller;

    public ListagemPedido(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Pedidos");
        controller = new PedidoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Pedido", "Data", "Hora", "Número do Pedido", "ID Cliente", "ID Status Pedido"};
    }

    @Override
    public Object[] linha(PedidoDTO p) {
        return new Object[]{p.getIdPed(), p.getDataP(), p.getHoraPed(), p.getnPed(), p.getIdClienteP(), p.getIdStatusPed()};
    }

    @Override
    public List<PedidoDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<PedidoDTO> listaPedidos = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaPedidos.add((PedidoDTO) iDto);
                }
            }
            return listaPedidos;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(PedidoDTO objeto) throws SQLException {
        PainelPedido painel = new PainelPedido();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(PedidoDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(PedidoDTO objeto) {
        return objeto.getIdPed();
    }
}
