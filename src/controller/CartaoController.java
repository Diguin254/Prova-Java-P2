package controller;

import dao.CartaoDao;
import dto.CartaoDTO;
import implementsDao.CartaoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Cartao;

public class CartaoController {

    private final CartaoDao cartaoDao;

    public CartaoController() {
        this.cartaoDao = new CartaoImplementsDAO();
    }

    public void salvar(CartaoDTO cartaoDTO) throws SQLException {
        Cartao cartao = new CartaoDTO().builder();
        cartaoDao.salvar(cartao);
    }

    public void editar(CartaoDTO cartaoDTO) throws SQLException {
        Cartao cartao = new CartaoDTO().builder();
        cartaoDao.editar(cartao);
    }

    public void deletar(int id) throws SQLException {
        cartaoDao.deletar(id);
    }

    public List<CartaoDTO> listar() throws SQLException {
        List<Cartao> lista = cartaoDao.listar();
        List<CartaoDTO> listaDTO = new LinkedList<>();
        for (Cartao cartao : lista) {
            CartaoDTO dto = new CartaoDTO();
            dto.idCartao = String.valueOf(cartao.getId());
            dto.nCartao = String.valueOf(cartao.getNumeroCartao());
            dto.codCartao = String.valueOf(cartao.getNumeroCartao());
            dto.tipoCartao = String.valueOf(cartao.getTipoConta());
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
