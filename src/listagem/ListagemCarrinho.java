/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelCarrinho;
import controller.CarrinhoController;
import dto.CarrinhoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alencar
 */
public class ListagemCarrinho extends Listagem<CarrinhoDTO> {

    private final CarrinhoController controller;

    public ListagemCarrinho(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Carrinhos");
        controller = new CarrinhoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Carrinho", "Quantidade de itens", "ID Pedido", "ID Produto"};
    }

    @Override
    public Object[] linha(CarrinhoDTO c) {
        return new Object[]{c.getIdCarrinho(), c.getQntdItens(), c.getIdPedido(), c.getIdProduto()};
    }

    @Override
    public List<CarrinhoDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<CarrinhoDTO> listaCarrinhos = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaCarrinhos.add((CarrinhoDTO) iDto);
                }
            }
            return listaCarrinhos;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(CarrinhoDTO objeto) throws SQLException {
        PainelCarrinho painel = new PainelCarrinho();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(CarrinhoDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(CarrinhoDTO objeto) {
        return objeto.getIdCarrinho();
    }

}
