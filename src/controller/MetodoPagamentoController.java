package controller;

import dao.MetodoPagamentoDao;
import dto.MetodoPagamentoDTO;
import implementsDao.MetodoPagamentoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.MetodoPagamento;

public class MetodoPagamentoController {

    private final MetodoPagamentoDao metodoPagamentoDao;

    public MetodoPagamentoController() {
        this.metodoPagamentoDao = new MetodoPagamentoImplementsDAO();
    }

    public void salvar(MetodoPagamentoDTO metodoPagamentoDTO) throws SQLException {
        MetodoPagamento met = metodoPagamentoDTO.builder();
        metodoPagamentoDao.salvar(met);
    }

    public void editar(MetodoPagamentoDTO metodoPagamentoDTO) throws SQLException {
        MetodoPagamento met = metodoPagamentoDTO.builder();
        metodoPagamentoDao.editar(met);
    }

    public void deletar(int id) throws SQLException {
        metodoPagamentoDao.deletar(id);
    }

    public List<MetodoPagamentoDTO> listar() throws SQLException {
        List<MetodoPagamento> lista = metodoPagamentoDao.listar();
        List<MetodoPagamentoDTO> listaDTO = new LinkedList<>();

        for (MetodoPagamento met : lista) {
            MetodoPagamentoDTO dto = new MetodoPagamentoDTO();
            dto.idMetodoP = String.valueOf(met.getId());
            dto.pixPag = met.getPix();
            dto.idDinheiroP = String.valueOf(met.getDinheiro().getId());
            dto.idCartaoP = String.valueOf(met.getCartao().getId());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
