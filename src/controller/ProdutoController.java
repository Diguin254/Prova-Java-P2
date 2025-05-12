package controller;

import dao.CarrinhoDao;
import dao.ProdutoDao;
import dto.CarrinhoDTO;
import dto.ProdutoDTO;
import implementsDao.CarrinhoImplementsDAO;
import implementsDao.ProdutoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Produto;
import model.Carrinho;

public class ProdutoController {

    private final ProdutoDao produtoDao;
    private final CarrinhoDao carrinhoDao;

    public ProdutoController() {
        this.produtoDao = new ProdutoImplementsDAO();
        this.carrinhoDao = new CarrinhoImplementsDAO();
    }

    public void salvar(ProdutoDTO produtoDTO) throws SQLException {
        Produto prod = produtoDTO.builder();
        produtoDao.salvar(prod);

        if (prod.getCarrinhos() != null) {
            for (Carrinho car : prod.getCarrinhos()) {
                car.setProduto(prod);
                carrinhoDao.salvar(car);
            }
        }

    }

    public void editar(ProdutoDTO produtoDTO) throws SQLException {
        Produto prod = produtoDTO.builder();
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

    public void deletar(int id) throws SQLException {
        List<Carrinho> todos = carrinhoDao.listar();

        for (Carrinho car : todos) {
            if (car.getProduto() != null && car.getProduto().getId().equals(id)) {
                carrinhoDao.deletar(car.getId());
            }
        }

        produtoDao.deletar(id);
    }

    public List<ProdutoDTO> listar() throws SQLException {
        List<Produto> lista = produtoDao.listar();
        List<Carrinho> listaCar = carrinhoDao.listar();

        List<ProdutoDTO> listaDTO = new LinkedList<>();
        for (Produto prod : lista) {
            List<Carrinho> carrinhos = new LinkedList<>();
            for (Carrinho car : listaCar) {
                if (car.getProduto() != null && car.getProduto().getId() == prod.getId()) {
                    carrinhos.add(car);
                }
            }
            prod.setCarrinhos(carrinhos);

            ProdutoDTO dto = new ProdutoDTO();
            dto.idProd = String.valueOf(prod.getId());
            dto.nomeProd = prod.getNome();
            dto.valUnProd = String.valueOf(prod.getValorUnitario());

            if (carrinhos != null) {
                List<CarrinhoDTO> carDtos = new LinkedList<>();
                for (Carrinho car : carrinhos) {
                    CarrinhoDTO cDto = new CarrinhoDTO();
                    cDto.idCarrinho = String.valueOf(car.getId());
                    cDto.qntdItens = String.valueOf(car.getQntd());
                    cDto.idPedido = String.valueOf(car.getPedido().getId());
                    cDto.idProduto = String.valueOf(car.getProduto().getId());
                    cDto.idIngredienteEscolha = String.valueOf(car.getIngredienteEscolha().getId());
                }
                dto.carrinhos = carDtos;
            }
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
