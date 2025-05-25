package controller;

import dao.DeliveryDao;
import dto.DeliveryDTO;
import dto.InterfaceDTO;
import implementsDao.DeliveryImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Delivery;

public class DeliveryController extends InterfaceController {

    private final DeliveryDao deliveryDao;

    public DeliveryController() {
        this.deliveryDao = new DeliveryImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        deliveryDao.salvar(((DeliveryDTO) dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        deliveryDao.editar(((DeliveryDTO) dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        deliveryDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Delivery> lista = deliveryDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Delivery d : lista) {
            DeliveryDTO dto = new DeliveryDTO();
            dto.idDelivery = String.valueOf(d.getId());
            dto.chaveEntregaD = d.getChaveEntrega();
            dto.numeroD = String.valueOf(d.getNumero());
            dto.complementoD = d.getComplemento();
            dto.idEndereco = String.valueOf(d.getEndereco().getId());
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
