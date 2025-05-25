package controller;

import dao.CupomDao;
import dto.CupomDTO;
import dto.InterfaceDTO;
import implementsDao.CupomImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Cupom;

public class CupomController extends InterfaceController {

    private final CupomDao cupomDao;

    public CupomController() {
        this.cupomDao = new CupomImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        cupomDao.salvar(((CupomDTO) dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        cupomDao.editar(((CupomDTO) dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        cupomDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<Cupom> lista = cupomDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (Cupom c : lista) {
            CupomDTO dto = new CupomDTO();
            dto.idC = String.valueOf(c.getId());
            dto.valorC = String.valueOf(c.getValorCupom());
            dto.codigoC = c.getCodigo();
            dto.validadeC = c.getValidade();
            dto.idPagamento = String.valueOf(c.getPagamento().getId());
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
