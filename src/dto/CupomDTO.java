package dto;

import java.util.Date;
import model.Cupom;
import model.Pagamento;

public class CupomDTO {

    public CupomDTO() {
    }

    public String idC;
    public String valorC;
    public String codigoC;
    public Date validadeC;

    public Cupom builder() {
        Cupom c = new Cupom();
        c.setId(idC == null ? 0 : Integer.valueOf(idC));
        c.setValorCupom(valorC == null ? 0.0 : Double.valueOf(valorC));
        c.setCodigo(codigoC == null ? "" : codigoC);
        c.setValidade(validadeC);

        return c;
    }
}
