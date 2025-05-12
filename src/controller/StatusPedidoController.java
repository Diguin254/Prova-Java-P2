package controller;

import dao.StatusPedidoDao;
import dto.StatusPedidoDTO;
import implementsDao.StatusPedidoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.StatusPedido;

public class StatusPedidoController {
    private final StatusPedidoDao statusPedidoDao;
    
    public StatusPedidoController(){
        this.statusPedidoDao = new StatusPedidoImplementsDAO();
    }
    
    public void salvar(StatusPedidoDTO statusPedidoDTO) throws SQLException{
        StatusPedido stP = statusPedidoDTO.builder();
        statusPedidoDao.salvar(stP);
    }
    
    public void editar(StatusPedidoDTO statusPedidoDTO) throws SQLException{
        StatusPedido stP = statusPedidoDTO.builder();
        statusPedidoDao.editar(stP);
    }
    
    public void deletar(int id) throws SQLException{
        statusPedidoDao.deletar(id);
    }

    public List<StatusPedidoDTO> listar() throws SQLException{
        List<StatusPedido> lista = statusPedidoDao.listar();
        List<StatusPedidoDTO> listaDTO = new LinkedList<>();
        
        for(StatusPedido stP : lista){
            StatusPedidoDTO dto = new StatusPedidoDTO();
            dto.idStatPed = String.valueOf(stP.getId());
            dto.progStatPed = stP.getProgresso();
            dto.idPedidoSP = String.valueOf(stP.getPedido().getId());
            listaDTO.add(dto);
        }
        
        return listaDTO;
    }
}
