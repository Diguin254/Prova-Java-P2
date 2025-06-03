/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
import controller.ReembolsoController;
import dto.ReembolsoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemReembolso extends Listagem<ReembolsoDTO> {

    private ReembolsoController controller;

    public ListagemReembolso(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Reembolsos");
        controller = new ReembolsoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Reembolso", "Motivo", "ID Pedido"};
    }

    @Override
    public Object[] toLinha(ReembolsoDTO r) {
        return new Object[]{r.getIdReemb(), r.getMotivoReemb(), r.getIdPedidoR()};
    }

    @Override
    public List<ReembolsoDTO> obterLista() {
        try {
        List<InterfaceDTO> listaGenerica = controller.listar();

        List<ReembolsoDTO> listaReembolsos = new LinkedList<>();

        if (listaGenerica != null) {
            for (InterfaceDTO iDto : listaGenerica) {
                listaReembolsos.add((ReembolsoDTO) iDto);
            }
        }
        return listaReembolsos;
        
        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }
}
