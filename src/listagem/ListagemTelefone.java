/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.CadastroPadrao;
import app.Listagem;
import cadastro.PainelTelefone;
import controller.TelefoneController;
import dto.TelefoneDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemTelefone extends Listagem<TelefoneDTO> {

    private final TelefoneController controller;

    public ListagemTelefone(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Telefones");
        controller = new TelefoneController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Telefone", "DDD", "Número"};
    }

    @Override
    public Object[] linha(TelefoneDTO t) {
        return new Object[]{t.getIdTel(), t.getDddTel(), t.getNumTel()};
    }

    @Override
    public List<TelefoneDTO> obterLista() {
        try {
            List<InterfaceDTO> listaGenerica = controller.listar();

            List<TelefoneDTO> listaTelefones = new LinkedList<>();

            if (listaGenerica != null) {
                for (InterfaceDTO iDto : listaGenerica) {
                    listaTelefones.add((TelefoneDTO) iDto);
                }
            }
            return listaTelefones;

        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public void onEditar(TelefoneDTO objeto) throws SQLException {
        PainelTelefone painel = new PainelTelefone();
        CadastroPadrao dialog = new CadastroPadrao((Frame) this.getParent(), painel, controller, true, objeto);
        dialog.setVisible(true);
    }

    @Override
    public void onDeletar(TelefoneDTO objeto) throws SQLException {
        controller.deletar(objeto.getId());
    }

    @Override
    public String getIdObjeto(TelefoneDTO objeto) {
        return objeto.getIdTel();
    }
}
