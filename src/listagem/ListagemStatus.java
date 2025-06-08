/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelStatusPedido;
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

    private final StatusPedidoController controller;

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
    public Object[] linha(StatusPedidoDTO s) {
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

    @Override
    public void onEditar(StatusPedidoDTO objeto) throws SQLException {
        PainelStatusPedido painel = new PainelStatusPedido();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(StatusPedidoDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(StatusPedidoDTO objeto) {
        return objeto.getIdStatPed();
    }
}
