package dto;

import model.IngredienteAdicional;
import model.IngredienteEscolha;

public class IngredienteAdicionalDTO {

    public IngredienteAdicionalDTO() {
    }

    public String idIngrAdc;
    public String nomeIngrAdc;
    public String valorIngrAdc;
    public String idIngrEsc;

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
}
