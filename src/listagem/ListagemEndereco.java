/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listagem;

import app.Listagem;
import controller.EnderecoController;
import dto.EnderecoDTO;
import dto.InterfaceDTO;
import java.awt.Frame;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author alenc
 */
public class ListagemEndereco extends Listagem<EnderecoDTO> {

    private EnderecoController controller;

    public ListagemEndereco(Frame parent, boolean modal) {
        super(parent, modal, "Lista de Enderecos");
        controller = new EnderecoController();
        carregarTabela();
    }

    @Override
    public String[] getColunas() {
        return new String[]{"ID Endereco", "CEP", "Distância", "Rua", "ID Bairro"};
    }

    @Override
    public Object[] toLinha(EnderecoDTO d) {
        return new Object[]{d.getIdEndereco(), d.getCepEnd(), d.getDistanciaEnd(), d.getRuaEnd(), d.getIdBairro()};
    }

    @Override
    public List<EnderecoDTO> obterLista() {
        try {
        List<InterfaceDTO> listaGenerica = controller.listar();

        List<EnderecoDTO> listaEnderecos = new LinkedList<>();

        if (listaGenerica != null) {
            for (InterfaceDTO iDto : listaGenerica) {
                listaEnderecos.add((EnderecoDTO) iDto);
            }
        }
        return listaEnderecos;
        
        } catch (SQLException ex) {
            return new LinkedList<>();
        }
    }
}

