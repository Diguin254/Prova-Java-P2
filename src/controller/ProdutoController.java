package controller;

import controller.InterfaceController;
import dao.CarrinhoDao;
import dao.ProdutoDao;
import dto.CarrinhoDTO;
import dto.ProdutoDTO;
import dto.InterfaceDTO;
import implementsDao.CarrinhoImplementsDAO;
import implementsDao.ProdutoImplementsDAO;
import model.Carrinho;
import model.Produto;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProdutoController extends InterfaceController {

    private final ProdutoDao produtoDao;
    private final CarrinhoDao carrinhoDao;

    public ProdutoController() {
        this.produtoDao = new ProdutoImplementsDAO();
        this.carrinhoDao = new CarrinhoImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        Produto prod = ((ProdutoDTO)dto).builder();
        produtoDao.salvar(prod);
        if (prod.getCarrinhos() != null) {
            for (Carrinho car : prod.getCarrinhos()) {
                car.setProduto(prod);
                carrinhoDao.salvar(car);
            }
        }
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        Produto prod = ((ProdutoDTO)dto).builder();
        produtoDao.editar(prod);
        if (prod.getCarrinhos() != null) {
            for (Carrinho car : prod.getCarrinhos()) {
                car.setProduto(prod);
                if (car.getId() == 0) {
                    carrinhoDao.salvar(car);
                } else {
                    carrinhoDao.editar(car);
                }
            }
        }
    }

    @Override
    public void deletar(int id) throws SQLException {
        for (Carrinho car : carrinhoDao.listar()) {
            if (car.getProduto() != null && car.getProduto().getId().equals(id)) {
                carrinhoDao.deletar(car.getId());
            }
        }
        produtoDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Produto> lista = produtoDao.listar();
        List<Carrinho> listaCar = carrinhoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Produto prod : lista) {
            List<Carrinho> carrinhos = new LinkedList<>();
            for (Carrinho car : listaCar) {
                if (car.getProduto() != null && car.getProduto().getId().equals(prod.getId())) {
                    carrinhos.add(car);
                }
            }
            prod.setCarrinhos(carrinhos);
            ProdutoDTO dto = new ProdutoDTO();
            dto.idProd = String.valueOf(prod.getId());
            dto.nomeProd = prod.getNome();
            dto.valUnProd = String.valueOf(prod.getValorUnitario());
            if (!carrinhos.isEmpty()) {
                dto.carrinhos = new LinkedList<>();
                for (Carrinho car : carrinhos) {
                    CarrinhoDTO cDto = new CarrinhoDTO();
                    cDto.idCarrinho = String.valueOf(car.getId());
                    cDto.qntdItens = String.valueOf(car.getQntd());
                    cDto.idPedido = car.getPedido() != null ? String.valueOf(car.getPedido().getId()) : null;
                    cDto.idProduto = car.getProduto() != null ? String.valueOf(car.getProduto().getId()) : null;
                    cDto.idIngredienteEscolha = car.getIngredienteEscolha() != null ? String.valueOf(car.getIngredienteEscolha().getId()) : null;
                    dto.carrinhos.add(cDto);
                }
            }
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
