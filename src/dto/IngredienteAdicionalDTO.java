package dto;

import model.IngredienteAdicional;
import model.IngredienteEscolha;

public class IngredienteAdicionalDTO implements InterfaceDTO{

    public IngredienteAdicionalDTO() {
    }

    public String idIngrAdc;
    public String nomeIngrAdc;
    public String valorIngrAdc;
    public String idIngrEsc;

    public String getIdIngrAdc() {
        return idIngrAdc;
    }

    public void setIdIngrAdc(String idIngrAdc) {
        this.idIngrAdc = idIngrAdc;
    }

    public String getNomeIngrAdc() {
        return nomeIngrAdc;
    }

    public void setNomeIngrAdc(String nomeIngrAdc) {
        this.nomeIngrAdc = nomeIngrAdc;
    }

    public String getValorIngrAdc() {
        return valorIngrAdc;
    }

    public void setValorIngrAdc(String valorIngrAdc) {
        this.valorIngrAdc = valorIngrAdc;
    }

    public String getIdIngrEsc() {
        return idIngrEsc;
    }

    public void setIdIngrEsc(String idIngrEsc) {
        this.idIngrEsc = idIngrEsc;
    }

    public IngredienteAdicional builder() {
        IngredienteAdicional ingr = new IngredienteAdicional();
        ingr.setId(idIngrAdc == null ? 0 : Integer.valueOf(idIngrAdc));
        ingr.setNome(nomeIngrAdc == null ? "" : nomeIngrAdc);
        ingr.setValor(valorIngrAdc == null ? 0.0 : Double.valueOf(valorIngrAdc));

        IngredienteEscolha ingre = new IngredienteEscolha();
        ingre.setId(idIngrEsc == null ? 0 : Integer.valueOf(idIngrEsc));
        ingr.setIngredienteEscolha(ingre);

        return ingr;
    }

    @Override
    public String toString() {
        return "IngredienteAdicionalDTO{" + "idIngrAdc=" + idIngrAdc + ", nomeIngrAdc=" + nomeIngrAdc + ", valorIngrAdc=" + valorIngrAdc + ", idIngrEsc=" + idIngrEsc + '}';
    }
    
    
}
