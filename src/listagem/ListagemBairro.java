/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelBairros;
import controller.BairroController;
import dto.BairroDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alencar
 */
public class ListagemBairro extends Listagem<BairroDTO> {

    private final BairroController controller;

    public ListagemBairro(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Bairros");
        controller = new BairroController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Bairro", "Nome do Bairro"};
    }

    @Override
    public Object[] linha(BairroDTO b) {
        return new Object[]{b.getIdBairro(), b.getNomeBairro()};
    }

    @Override
    public List<BairroDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<BairroDTO> listaBairros = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaBairros.add((BairroDTO) iDto);
                }
            }
            return listaBairros;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(BairroDTO objeto) throws SQLException {
        PainelBairros painel = new PainelBairros();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(BairroDTO objeto) throws SQLException{
            controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(BairroDTO objeto) {
        return objeto.getIdBairro();
    }
}
