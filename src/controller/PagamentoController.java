package controller;

import dao.PagamentoDao;
import dto.PagamentoDTO;
import implementsDao.PagamentoImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Pagamento;

public class PagamentoController {

    private final PagamentoDao pagamentoDao;

    public PagamentoController() {
        this.pagamentoDao = new PagamentoImplementsDAO();
    }

    public void salvar(PagamentoDTO pagamentoDTO) throws SQLException {
        Pagamento pag = pagamentoDTO.builder();
        pagamentoDao.salvar(pag);
    }

    public void editar(PagamentoDTO pagamentoDTO) throws SQLException {
        Pagamento pag = pagamentoDTO.builder();
        pagamentoDao.editar(pag);
    }

    public void deletar(int id) throws SQLException {
        pagamentoDao.deletar(id);
    }

    public List<PagamentoDTO> listar() throws SQLException {
        List<Pagamento> lista = pagamentoDao.listar();
        List<PagamentoDTO> listaDTO = new LinkedList<>();

        for (Pagamento pag : lista) {
            PagamentoDTO dto = new PagamentoDTO();
            dto.idPag = String.valueOf(pag.getId());
            dto.idMetPag = String.valueOf(pag.getMetodoPagamento().getId());
            dto.idCupomP = String.valueOf(pag.getCupom().getId());
            dto.idPedidoP = String.valueOf(pag.getPedido().getId());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
