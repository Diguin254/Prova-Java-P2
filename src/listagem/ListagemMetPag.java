/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelMetPagamento;
import controller.MetodoPagamentoController;
import dto.MetodoPagamentoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemMetPag extends Listagem<MetodoPagamentoDTO> {

    private final MetodoPagamentoController controller;

    public ListagemMetPag(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Metodos de Pagamentos");
        controller = new MetodoPagamentoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID MetodoPagamento", "PIX", "ID Dinheiro", "ID Cartão"};
    }

    @Override
    public Object[] linha(MetodoPagamentoDTO m) {
        return new Object[]{m.getIdMetodoP(), m.getPixPag(), m.getIdDinheiroP(), m.getIdCartaoP()};
    }

    @Override
    public List<MetodoPagamentoDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<MetodoPagamentoDTO> listaMetodoPagamentos = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaMetodoPagamentos.add((MetodoPagamentoDTO) iDto);
                }
            }
            return listaMetodoPagamentos;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(MetodoPagamentoDTO objeto) throws SQLException {
        PainelMetPagamento painel = new PainelMetPagamento();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(MetodoPagamentoDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(MetodoPagamentoDTO objeto) {
        return objeto.getIdMetodoP();
    }
}
