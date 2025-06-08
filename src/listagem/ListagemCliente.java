/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelCliente;
import controller.ClienteController;
import dto.ClienteDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenca
 */
public class ListagemCliente extends Listagem<ClienteDTO> {

    private ClienteController controller;

    public ListagemCliente(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Clientes");
        controller = new ClienteController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Cliente", "Nome do Cliente"};
    }

    @Override
    public Object[] linha(ClienteDTO c) {
        return new Object[]{c.getIdCliente(), c.getNomeCliente()};
    }

    @Override
    public List<ClienteDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<ClienteDTO> listaClientes = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaClientes.add((ClienteDTO) iDto);
                }
            }
            return listaClientes;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(ClienteDTO objeto) throws SQLException {
        PainelCliente painel = new PainelCliente();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(ClienteDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(ClienteDTO objeto) {
        return objeto.getIdCliente();
    }
}
