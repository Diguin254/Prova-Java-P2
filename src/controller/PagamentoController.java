package controller;

import dao.PagamentoDao;
import dto.PagamentoDTO;
import dto.InterfaceDTO;
import implementsDao.PagamentoImplementsDAO;
import model.Pagamento;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PagamentoController extends InterfaceController {

    private final PagamentoDao pagamentoDao;

    public PagamentoController() {
        this.pagamentoDao = new PagamentoImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        pagamentoDao.salvar(((PagamentoDTO)dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        pagamentoDao.editar(((PagamentoDTO)dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        pagamentoDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Pagamento> lista = pagamentoDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Pagamento pag : lista) {
            PagamentoDTO dto = new PagamentoDTO();
            dto.idPag = String.valueOf(pag.getId());
            dto.idMetPag = pag.getMetodoPagamento() != null ? String.valueOf(pag.getMetodoPagamento().getId()) : null;
            dto.idCupomP = pag.getCupom() != null ? String.valueOf(pag.getCupom().getId()) : null;
            dto.idPedidoP = pag.getPedido() != null ? String.valueOf(pag.getPedido().getId()) : null;
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
