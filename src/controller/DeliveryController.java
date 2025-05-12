package controller;

import dao.DeliveryDao;
import dto.DeliveryDTO;
import implementsDao.DeliveryImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Delivery;

public class DeliveryController {

    private final DeliveryDao deliveryDao;

    public DeliveryController() {
        this.deliveryDao = new DeliveryImplementsDAO();
    }

    public void salvar(DeliveryDTO deliveryDTO) throws SQLException {
        Delivery d = deliveryDTO.builder();
        deliveryDao.salvar(d);
    }

    public void editar(DeliveryDTO deliveryDTO) throws SQLException {
        Delivery d = new DeliveryDTO().builder();
        deliveryDao.editar(d);
    }

    public void deletar(int id) throws SQLException {
        deliveryDao.deletar(id);
    }

    public List<DeliveryDTO> listar() throws SQLException {
        List<Delivery> lista = deliveryDao.listar();
        List<DeliveryDTO> listaDTO = new LinkedList<>();
        for (Delivery d : lista) {
            DeliveryDTO dto = new DeliveryDTO();
            dto.idDelivery = String.valueOf(d.getId());
            dto.chaveEntregaD = d.getChaveEntrega();
            dto.numeroD = String.valueOf(d.getNumero());
            dto.complementoD = d.getComplemento();
            dto.idEndereco = String.valueOf(d.getEndereco().getId());
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
