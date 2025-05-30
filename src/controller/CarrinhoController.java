package controller;

import dao.CarrinhoDao;
import dto.CarrinhoDTO;
import dto.InterfaceDTO;
import implementsDao.CarrinhoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Carrinho;

public class CarrinhoController extends InterfaceController {

    private final CarrinhoDao carrinhoDao;

    public CarrinhoController() {
        this.carrinhoDao = new CarrinhoImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        carrinhoDao.salvar(((CarrinhoDTO) dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        carrinhoDao.editar(((CarrinhoDTO) dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        carrinhoDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Carrinho> lista = carrinhoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Carrinho carrinho : lista) {
            CarrinhoDTO dto = new CarrinhoDTO();
            dto.idCarrinho = String.valueOf(carrinho.getId());
            dto.qntdItens = String.valueOf(carrinho.getQntd());
            dto.idPedido = String.valueOf(carrinho.getPedido().getId());
            dto.idProduto = String.valueOf(carrinho.getProduto().getId());
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
