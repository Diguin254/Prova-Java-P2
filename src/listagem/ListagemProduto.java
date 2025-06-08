/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelProduto;
import controller.ProdutoController;
import dto.ProdutoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemProduto extends Listagem<ProdutoDTO> {

    private final ProdutoController controller;

    public ListagemProduto(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Produtos");
        controller = new ProdutoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Produto", "Nome do Produto", "Valor da Unidade"};
    }

    @Override
    public Object[] linha(ProdutoDTO p) {
        return new Object[]{p.getIdProd(), p.getNomeProd(), p.getValUnProd()};
    }

    @Override
    public List<ProdutoDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<ProdutoDTO> listaProdutos = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaProdutos.add((ProdutoDTO) iDto);
                }
            }
            return listaProdutos;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(ProdutoDTO objeto) throws SQLException {
        PainelProduto painel = new PainelProduto();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(ProdutoDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(ProdutoDTO objeto) {
        return objeto.getIdProd();
    }
}
