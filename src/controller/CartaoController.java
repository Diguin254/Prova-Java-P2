package controller;

import dao.CartaoDao;
import dto.CartaoDTO;
import dto.InterfaceDTO;
import implementsDao.CartaoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Cartao;

public class CartaoController extends InterfaceController{

    private final CartaoDao cartaoDao;

    public CartaoController() {
        this.cartaoDao = new CartaoImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        cartaoDao.salvar(((CartaoDTO)dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        cartaoDao.editar(((CartaoDTO)dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        cartaoDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Cartao> lista = cartaoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Cartao cartao : lista) {
            CartaoDTO dto = new CartaoDTO();
            dto.idCartao = String.valueOf(cartao.getId());
            dto.nCartao = String.valueOf(cartao.getNumeroCartao());
            dto.codCartao = String.valueOf(cartao.getNumeroCartao());
            dto.tipoCartao = String.valueOf(cartao.getTipoConta());
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
