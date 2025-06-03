/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
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

    private DinheiroController controller;

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
    public Object[] toLinha(DinheiroDTO d) {
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
}
