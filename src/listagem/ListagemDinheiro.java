/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelDinheiro;
import controller.DinheiroController;
import dto.DinheiroDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemDinheiro extends Listagem<DinheiroDTO> {

    private final DinheiroController controller;

    public ListagemDinheiro(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Dinheiro");
        controller = new DinheiroController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Dinheiro", "Valor"};
    }

    @Override
    public Object[] linha(DinheiroDTO d) {
        return new Object[]{d.getIdDinheiro(), d.getValorD()};
    }

    @Override
    public List<DinheiroDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<DinheiroDTO> listaDinheiros = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaDinheiros.add((DinheiroDTO) iDto);
                }
            }
            return listaDinheiros;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(DinheiroDTO objeto) throws SQLException {
        PainelDinheiro painel = new PainelDinheiro();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(DinheiroDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(DinheiroDTO objeto) {
        return objeto.getIdDinheiro();
    }
}
