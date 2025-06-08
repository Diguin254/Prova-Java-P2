/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelPagamento;
import controller.PagamentoController;
import dto.PagamentoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemPagamento extends Listagem<PagamentoDTO> {

    private final PagamentoController controller;

    public ListagemPagamento(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Pagamentos");
        controller = new PagamentoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Pagamento", "ID Pedido", "ID Cupom", "ID Metodo de Pagamento"};
    }

    @Override
    public Object[] linha(PagamentoDTO p) {
        return new Object[]{p.getIdPag(), p.getIdPedidoP(), p.getIdCupomP(), p.getIdMetPag()};
    }

    @Override
    public List<PagamentoDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<PagamentoDTO> listaPagamentos = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaPagamentos.add((PagamentoDTO) iDto);
                }
            }
            return listaPagamentos;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(PagamentoDTO objeto) throws SQLException {
        PainelPagamento painel = new PainelPagamento();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(PagamentoDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(PagamentoDTO objeto) {
        return objeto.getIdPag();
    }
}
