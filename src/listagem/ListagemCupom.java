/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
import controller.CupomController;
import dto.CupomDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemCupom extends Listagem<CupomDTO> {

    private CupomController controller;

    public ListagemCupom(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Cupons");
        controller = new CupomController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Cupom", "Código", "Validade", "Valor"};
    }

    @Override
    public Object[] toLinha(CupomDTO c) {
        return new Object[]{c.getIdC(), c.getCodigoC(), c.getValidadeC(), c.getValorC()};
    }

    @Override
    public List<CupomDTO> obterLista() {
        try {
        List<InterfaceDTO> listaGenerica = controller.listar();

        List<CupomDTO> listaCupoms = new LinkedList<>();

        if (listaGenerica != null) {
            for (InterfaceDTO iDto : listaGenerica) {
                listaCupoms.add((CupomDTO) iDto);
            }
        }
        return listaCupoms;
        
        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }
}
