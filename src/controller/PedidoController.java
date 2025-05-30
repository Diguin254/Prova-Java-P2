package controller;

import dao.CarrinhoDao;
import dao.PedidoDao;
import dto.CarrinhoDTO;
import dto.PedidoDTO;
import dto.InterfaceDTO;
import implementsDao.CarrinhoImplementsDAO;
import implementsDao.PedidoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Carrinho;
import model.Pedido;

public class PedidoController extends InterfaceController {

    private final PedidoDao pedidoDao;
    private final CarrinhoDao carrinhoDao;

    public PedidoController() {
        this.pedidoDao = new PedidoImplementsDAO();
        this.carrinhoDao = new CarrinhoImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        Pedido ped = ((PedidoDTO)dto).builder();
        pedidoDao.salvar(ped);
        if (ped.getCarrinhos() != null) {
            for (Carrinho c : ped.getCarrinhos()) {
                c.setPedido(ped);
                carrinhoDao.salvar(c);
            }
        }
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        Pedido ped = ((PedidoDTO)dto).builder();
        pedidoDao.salvar(ped);
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
    }

    @Override
    public void deletar(int id) throws SQLException {
        for (Carrinho c : carrinhoDao.listar()) {
            if (c.getPedido() != null && c.getPedido().getId().equals(id)) {
                carrinhoDao.deletar(c.getId());
            }
        }
        pedidoDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Pedido> lista = pedidoDao.listar();
        List<Carrinho> listaCar = carrinhoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Pedido ped : lista) {
            List<Carrinho> carrinhos = new LinkedList<>();
            for (Carrinho car : listaCar) {
                if (car.getPedido() != null && car.getPedido().getId().equals(ped.getId())) {
                    carrinhos.add(car);
                }
            }
            ped.setCarrinhos(carrinhos);

            PedidoDTO dto = new PedidoDTO();
            dto.idPed = String.valueOf(ped.getId());
            dto.horaPed = ped.getHoraPedido();
            dto.nPed = String.valueOf(ped.getNumeroPedido());
            dto.dataP = ped.getDataPedido();
            dto.idClienteP = ped.getCliente() != null ? String.valueOf(ped.getCliente().getId()) : null;
            dto.idStatusPed = ped.getStatusPedido() != null ? String.valueOf(ped.getStatusPedido().getId()) : null;

            if (carrinhos != null && !carrinhos.isEmpty()) {
                dto.carrinhos = new LinkedList<>();
                for (Carrinho car : carrinhos) {
                    CarrinhoDTO cDto = new CarrinhoDTO();
                    cDto.idCarrinho = String.valueOf(car.getId());
                    cDto.qntdItens = String.valueOf(car.getQntd());
                    dto.carrinhos.add(cDto);
                }
            }

            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
