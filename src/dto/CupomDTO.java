package dto;

import java.util.Date;
import model.Cupom;

public class CupomDTO implements InterfaceDTO {

    public String idC;
    public String valorC;
    public String codigoC;
    public Date validadeC;

    public CupomDTO() {
    }

    public String getIdC() {
        return idC;
    }

    public void setIdC(String idC) {
        this.idC = idC;
    }

    public String getValorC() {
        return valorC;
    }

    public void setValorC(String valorC) {
        this.valorC = valorC;
    }

    public String getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    public Date getValidadeC() {
        return validadeC;
    }

    public void setValidadeC(Date validadeC) {
        this.validadeC = validadeC;
    }

    public Cupom builder() {
        Cupom c = new Cupom();
        c.setId(idC == null ? 0 : Integer.valueOf(idC));
        c.setValorCupom(valorC == null ? 0.0 : Double.valueOf(valorC));
        c.setCodigo(codigoC == null ? "" : codigoC);
        c.setValidade(validadeC);

        return c;
    }

    @Override
    public String toString() {
        return "CupomDTO{" + "idC=" + idC + ", valorC=" + valorC + ", codigoC=" + codigoC + ", validadeC=" + validadeC + '}';
    }
@Override
    public int getId() {
        return (idC == null || idC.isBlank()) ? 0 : Integer.parseInt(idC);
    }

    @Override
    public void setId(int id) {
        this.idC = String.valueOf(id);
    }
}
