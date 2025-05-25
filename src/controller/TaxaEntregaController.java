package controller;

import controller.InterfaceController;
import dao.TaxaEntregaDao;
import dto.InterfaceDTO;
import dto.TaxaEntregaDTO;
import implementsDao.TaxaEntregaImplementsDAO;
import model.TaxaEntrega;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TaxaEntregaController extends InterfaceController {

    private final TaxaEntregaDao taxaEntregaDao;

    public TaxaEntregaController() {
        this.taxaEntregaDao = new TaxaEntregaImplementsDAO();
    }

    @Override
    public void salvar(InterfaceDTO dto) throws SQLException {
        taxaEntregaDao.salvar(((TaxaEntregaDTO)dto).builder());
    }

    @Override
    public void editar(InterfaceDTO dto) throws SQLException {
        taxaEntregaDao.editar(((TaxaEntregaDTO)dto).builder());
    }

    @Override
    public void deletar(int id) throws SQLException {
        taxaEntregaDao.deletar(id);
    }

    @Override
    public List<InterfaceDTO> listar() throws SQLException {
        List<TaxaEntrega> lista = taxaEntregaDao.listar();
        List<InterfaceDTO> listaDTO = new LinkedList<>();
        for (TaxaEntrega taxa : lista) {
            TaxaEntregaDTO dto = new TaxaEntregaDTO();
            dto.idTaxaEnt = String.valueOf(taxa.getId());
            dto.valEntrega = String.valueOf(taxa.getTaxa_entrega());
            dto.idEnd = taxa.getEndereco() != null ? String.valueOf(taxa.getEndereco().getId()) : null;
            listaDTO.add((InterfaceDTO) dto);
        }
        return listaDTO;
    }
}
