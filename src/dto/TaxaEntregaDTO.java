package dto;

import model.Endereco;
import model.TaxaEntrega;

public class TaxaEntregaDTO implements InterfaceDTO {

    public TaxaEntregaDTO() {
    }

    public String idTaxaEnt;
    public String valEntrega;
    public String idEnd;

    public String getIdTaxaEnt() {
        return idTaxaEnt;
    }

    public void setIdTaxaEnt(String idTaxaEnt) {
        this.idTaxaEnt = idTaxaEnt;
    }

    public String getValEntrega() {
        return valEntrega;
    }

    public void setValEntrega(String valEntrega) {
        this.valEntrega = valEntrega;
    }

    public String getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(String idEnd) {
        this.idEnd = idEnd;
    }

    public TaxaEntrega builder() {
        TaxaEntrega tx = new TaxaEntrega();
        tx.setId(idTaxaEnt == null ? 0 : Integer.valueOf(idTaxaEnt));
        tx.setTaxa_entrega(valEntrega == null ? 0 : Double.valueOf(valEntrega));

        Endereco end = new Endereco();
        end.setId(idEnd == null ? 0 : Integer.valueOf(idEnd));
        tx.setEndereco(end);

        return tx;
    }

    @Override
    public String toString() {
        return "TaxaEntregaDTO{" + "idTaxaEnt=" + idTaxaEnt + ", valEntrega=" + valEntrega + ", idEnd=" + idEnd + '}';
    }
    
    @Override
    public int getId() {
        return (idTaxaEnt == null || idTaxaEnt.isBlank()) ? 0 : Integer.parseInt(idTaxaEnt);
    }

    @Override
    public void setId(int id) {
        this.idTaxaEnt = String.valueOf(id);
    }
}
