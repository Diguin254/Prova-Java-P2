/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelDelivery;
import controller.DeliveryController;
import dto.DeliveryDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemDelivery extends Listagem<DeliveryDTO> {

    private final DeliveryController controller;

    public ListagemDelivery(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Deliverys");
        controller = new DeliveryController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Delivery", "Chave de Entrega", "Complemento", "Número", "ID Endereço"};
    }

    @Override
    public Object[] linha(DeliveryDTO d) {
        return new Object[]{d.getIdDelivery(), d.getChaveEntregaD(), d.getComplementoD(), d.getNumeroD(), d.getIdEndereco()};
    }

    @Override
    public List<DeliveryDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<DeliveryDTO> listaDeliverys = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaDeliverys.add((DeliveryDTO) iDto);
                }
            }
            return listaDeliverys;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(DeliveryDTO objeto) throws SQLException {
        PainelDelivery painel = new PainelDelivery();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(DeliveryDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(DeliveryDTO objeto) {
        return objeto.getIdDelivery();
    }
}
