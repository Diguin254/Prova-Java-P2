package controller;

import dao.MetodoPagamentoDao;
import dto.MetodoPagamentoDTO;
import dto.InterfaceDTO;
import implementsDao.MetodoPagamentoImplementsDAO;
import model.MetodoPagamento;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MetodoPagamentoController extends InterfaceController {

    private final MetodoPagamentoDao metodoPagamentoDao;

    public MetodoPagamentoController() {
        this.metodoPagamentoDao = new MetodoPagamentoImplementsDAO();
    }
    
    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        metodoPagamentoDao.salvar(((MetodoPagamentoDTO)dto).builder());
    }
    
    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        metodoPagamentoDao.editar(((MetodoPagamentoDTO)dto).builder());
    }
    
    @Override
    public void deletar(int id) throws SQLException {
        metodoPagamentoDao.deletar(id);
    }
    
    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<MetodoPagamento> lista = metodoPagamentoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (MetodoPagamento met : lista) {
            MetodoPagamentoDTO dto = new MetodoPagamentoDTO();
            dto.idMetodoP = String.valueOf(met.getId());
            dto.pixPag = met.getPix();
            dto.idDinheiroP = met.getDinheiro() != null ? String.valueOf(met.getDinheiro().getId()) : null;
            dto.idCartaoP = met.getCartao() != null ? String.valueOf(met.getCartao().getId()) : null;
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
