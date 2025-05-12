package controller;

import dao.CupomDao;
import dto.CupomDTO;
import implementsDao.CupomImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Cupom;

public class CupomController {

    private final CupomDao cupomDao;

    public CupomController() {
        this.cupomDao = new CupomImplementsDAO();
    }

    public void salvar(CupomDTO cupomDTO) throws SQLException {
        Cupom cupom = cupomDTO.builder();
        cupomDao.salvar(cupom);
    }

    public void editar(CupomDTO cupomDTO) throws SQLException {
        Cupom cupom = cupomDTO.builder();
        cupomDao.editar(cupom);
    }

    public void deletar(int id) throws SQLException {
        cupomDao.deletar(id);
    }

    public List<CupomDTO> listar() throws SQLException {
        List<Cupom> lista = cupomDao.listar();
        List<CupomDTO> listaDTO = new LinkedList<>();
        for (Cupom c : lista) {
            CupomDTO dto = new CupomDTO();
            dto.idC = String.valueOf(c.getId());
            dto.valorC = String.valueOf(c.getValorCupom());
            dto.codigoC = c.getCodigo();
            dto.validadeC = c.getValidade();
            dto.idPagamento = String.valueOf(c.getPagamento().getId());
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
