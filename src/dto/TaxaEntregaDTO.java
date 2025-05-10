package dto;

import model.Endereco;
import model.TaxaEntrega;

public class TaxaEntregaDTO {

    public TaxaEntregaDTO() {
    }

    public String idTaxaEnt;
    public String valEntrega;
    public String idEnd;

    public TaxaEntrega builder() {
        TaxaEntrega tx = new TaxaEntrega();
        tx.setId(idTaxaEnt == null ? 0 : Integer.valueOf(idTaxaEnt));
        tx.setTaxa_entrega(valEntrega == null ? 0 : Double.valueOf(valEntrega));

        Endereco end = new Endereco();
        end.setId(idEnd == null ? 0 : Integer.valueOf(idEnd));
        tx.setEndereco(end);

        return tx;
    }
}
