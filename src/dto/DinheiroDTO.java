package dto;

import model.Dinheiro;

public class DinheiroDTO implements InterfaceDTO {

    public DinheiroDTO() {
    }

    public String idDinheiro;
    public String valorD;

    public String getIdDinheiro() {
        return idDinheiro;
    }

    public void setIdDinheiro(String idDinheiro) {
        this.idDinheiro = idDinheiro;
    }

    public String getValorD() {
        return valorD;
    }

    public void setValorD(String valorD) {
        this.valorD = valorD;
    }

    public Dinheiro builder() {
        Dinheiro d = new Dinheiro();
        d.setId(idDinheiro == null ? 0 : Integer.valueOf(idDinheiro));
        d.setValorEntregado(valorD == null ? 0.0 : Double.valueOf(valorD));

        return d;
    }

    @Override
    public String toString() {
        return "DinheiroDTO{" + "idDinheiro=" + idDinheiro + ", valorD=" + valorD + '}';
    }

}
