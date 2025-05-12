package dto;

import model.IngredienteEscolha;
import model.IngredienteRemover;

public class IngredienteRemoverDTO {

    public IngredienteRemoverDTO() {
    }

    public String idIngrRem;
    public String nomeIngrRem;
    public String idIngrEsco;

    public IngredienteRemover builder() {
        IngredienteRemover ingr = new IngredienteRemover();
        ingr.setId(idIngrRem == null ? 0 : Integer.valueOf(idIngrRem));
        ingr.setNome(nomeIngrRem == null ? "" : nomeIngrRem);

        IngredienteEscolha e = new IngredienteEscolha();
        e.setId(idIngrEsco == null ? 0 : Integer.valueOf(idIngrEsco));
        ingr.setIngredienteEscolha(e);

        return ingr;
    }
}
