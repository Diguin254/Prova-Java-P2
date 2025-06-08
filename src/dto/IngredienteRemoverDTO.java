package dto;

import model.IngredienteEscolha;
import model.IngredienteRemover;

public class IngredienteRemoverDTO implements InterfaceDTO{

    public IngredienteRemoverDTO() {
    }

    public String idIngrRem;
    public String nomeIngrRem;
    public String idIngrEsco;

    public String getIdIngrRem() {
        return idIngrRem;
    }

    public void setIdIngrRem(String idIngrRem) {
        this.idIngrRem = idIngrRem;
    }

    public String getNomeIngrRem() {
        return nomeIngrRem;
    }

    public void setNomeIngrRem(String nomeIngrRem) {
        this.nomeIngrRem = nomeIngrRem;
    }

    public String getIdIngrEsco() {
        return idIngrEsco;
    }

    public void setIdIngrEsco(String idIngrEsco) {
        this.idIngrEsco = idIngrEsco;
    }

    public IngredienteRemover builder() {
        IngredienteRemover ingr = new IngredienteRemover();
        ingr.setId(idIngrRem == null ? 0 : Integer.valueOf(idIngrRem));
        ingr.setNome(nomeIngrRem == null ? "" : nomeIngrRem);

        IngredienteEscolha e = new IngredienteEscolha();
        e.setId(idIngrEsco == null ? 0 : Integer.valueOf(idIngrEsco));
        ingr.setIngredienteEscolha(e);

        return ingr;
    }

    @Override
    public String toString() {
        return "IngredienteRemoverDTO{" + "idIngrRem=" + idIngrRem + ", nomeIngrRem=" + nomeIngrRem + ", idIngrEsco=" + idIngrEsco + '}';
    }
    
    @Override
    public int getId() {
        return (idIngrRem == null || idIngrRem.isBlank()) ? 0 : Integer.parseInt(idIngrRem);
    }

    @Override
    public void setId(int id) {
        this.idIngrRem = String.valueOf(id);
    }
}
