package controller;

import dao.CarrinhoDao;
import dao.PedidoDao;
import dto.CarrinhoDTO;
import dto.PedidoDTO;
import implementsDao.CarrinhoImplementsDAO;
import implementsDao.PedidoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Carrinho;
import model.Pedido;

public class PedidoController {

    private final PedidoDao pedidoDao;
    private final CarrinhoDao carrinhoDao;

    public PedidoController() {
        this.pedidoDao = new PedidoImplementsDAO();
        this.carrinhoDao = new CarrinhoImplementsDAO();
    }

    public void salvar(PedidoDTO pedidoDTO) throws SQLException {
        Pedido ped = pedidoDTO.builder();
        pedidoDao.salvar(ped);

        if (ped.getCarrinhos() != null) {
            for (Carrinho c : ped.getCarrinhos()) {
                c.setPedido(ped);
                carrinhoDao.salvar(c);
            }
        }
    }

    public void editar(PedidoDTO pedidoDTO) throws SQLException {
        Pedido ped = pedidoDTO.builder();

        if (ped.getCarrinhos() != null) {
            for (Carrinho c : ped.getCarrinhos()) {
                c.setPedido(ped);
                if (c.getId() == 0) {
                    carrinhoDao.salvar(c);
                } else {
                    carrinhoDao.editar(c);
                }
            }
        }
        pedidoDao.editar(ped);
    }

    public void deletar(int id) throws SQLException {
        List<Carrinho> todos = carrinhoDao.listar();

        for (Carrinho c : todos) {
            if (c.getPedido() != null && c.getPedido().getId().equals(id)) {
                carrinhoDao.deletar(c.getId());
            }
        }

        pedidoDao.deletar(id);
    }

    public List<PedidoDTO> listar() throws SQLException {
        List<Pedido> lista = pedidoDao.listar();
        List<Carrinho> listaCar = carrinhoDao.listar();

        List<PedidoDTO> listaDTO = new LinkedList<>();
        for (Pedido ped : lista) {
            List<Carrinho> carrinhos = new LinkedList<>();
            for (Carrinho car : listaCar) {
                if (car.getPedido() != null && car.getPedido().getId() == ped.getId()) {
                    carrinhos.add(car);
                }
            }
            ped.setCarrinhos(carrinhos);

            PedidoDTO dto = new PedidoDTO();
            dto.idPed = String.valueOf(ped.getId());
            dto.horaPed = ped.getHoraPedido();
            dto.nPed = String.valueOf(ped.getNumeroPedido());
            dto.dataP = ped.getDataPedido();
            dto.idClienteP = String.valueOf(ped.getCliente().getId());
            dto.idStatusPed = String.valueOf(ped.getStatusPedido().getId());
            dto.idEntregaP = String.valueOf(ped.getEntrega().getId());

            if (carrinhos != null) {
                List<CarrinhoDTO> carDtos = new LinkedList<>();
                for (Carrinho car : carrinhos) {
                    CarrinhoDTO cDto = new CarrinhoDTO();
                    cDto.idCarrinho = String.valueOf(car.getId());
                    cDto.qntdItens = String.valueOf(car.getQntd());
                    carDtos.add(cDto);
                }
                dto.carrinhos = carDtos;
            }
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
