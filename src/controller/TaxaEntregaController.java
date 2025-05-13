package controller;

import dao.TaxaEntregaDao;
import dto.TaxaEntregaDTO;
import implementsDao.TaxaEntregaImplementsDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.TaxaEntrega;

public class TaxaEntregaController {

    private final TaxaEntregaDao taxaEntregaDao;

    public TaxaEntregaController() {
        this.taxaEntregaDao = new TaxaEntregaImplementsDAO();
    }

    public void salvar(TaxaEntregaDTO taxaEntregaDTO) throws SQLException {
        TaxaEntrega tx = taxaEntregaDTO.builder();
        taxaEntregaDao.salvar(tx);
    }

    public void editar(TaxaEntregaDTO taxaEntregaDTO) throws SQLException {
        TaxaEntrega tx = taxaEntregaDTO.builder();
        taxaEntregaDao.editar(tx);
    }

    public void deletar(int id) throws SQLException {
        taxaEntregaDao.deletar(id);
    }

    public List<TaxaEntregaDTO> listar() throws SQLException {
        List<TaxaEntrega> lista = taxaEntregaDao.listar();
        List<TaxaEntregaDTO> listaDTO = new LinkedList<>();

        for (TaxaEntrega taxa : lista) {
            TaxaEntregaDTO dto = new TaxaEntregaDTO();
            dto.idTaxaEnt = String.valueOf(taxa.getId());
            dto.valEntrega = String.valueOf(taxa.getTaxa_entrega());
            dto.idEnd = String.valueOf(taxa.getEndereco().getId());
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
