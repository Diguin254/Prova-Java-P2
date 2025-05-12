package controller;

import dao.CarrinhoDao;
import dto.CarrinhoDTO;
import implementsDao.CarrinhoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Carrinho;

public class CarrinhoController {

    private final CarrinhoDao carrinhoDao;

    public CarrinhoController() {
        this.carrinhoDao = new CarrinhoImplementsDAO();
    }

    public void salvar(CarrinhoDTO carrinhoDTO) throws SQLException {
        Carrinho carrinho = carrinhoDTO.builder();
        carrinhoDao.salvar(carrinho);
    }

    public void editar(CarrinhoDTO carrinhoDTO) throws SQLException {
        Carrinho carrinho = carrinhoDTO.builder();
        carrinhoDao.editar(carrinho);
    }

    public void deletar(int id) throws SQLException {
        carrinhoDao.deletar(id);
    }

    public List<CarrinhoDTO> listar() throws SQLException {
        List<Carrinho> lista = carrinhoDao.listar();
        List<CarrinhoDTO> listaDTO = new LinkedList<>();
        for (Carrinho carrinho : lista) {
            CarrinhoDTO dto = new CarrinhoDTO();
            dto.idCarrinho = String.valueOf(carrinho.getId());
            dto.qntdItens = String.valueOf(carrinho.getQntd());
            dto.idPedido = String.valueOf(carrinho.getPedido().getId());
            dto.idProduto = String.valueOf(carrinho.getProduto().getId());
            dto.idIngredienteEscolha = String.valueOf(carrinho.getIngredienteEscolha().getId());
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
