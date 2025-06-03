/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
import controller.CartaoController;
import dto.CartaoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemCartao extends Listagem<CartaoDTO> {

    private CartaoController controller;

    public ListagemCartao(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Cartões");
        controller = new CartaoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Cartao", "Código do Cartao", "Tipo do Cartao", "Numero do Cartao"};
    }

    @Override
    public Object[] toLinha(CartaoDTO c) {
        return new Object[]{c.getIdCartao(), c.getCodCartao(), c.getTipoCartao(), c.getnCartao()};
    }

    @Override
    public List<CartaoDTO> obterLista() {
        try {
        List<InterfaceDTO> listaGenerica = controller.listar();

        List<CartaoDTO> listaCartaos = new LinkedList<>();

        if (listaGenerica != null) {
            for (InterfaceDTO iDto : listaGenerica) {
                listaCartaos.add((CartaoDTO) iDto);
            }
        }
        return listaCartaos;
        
        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }
}

