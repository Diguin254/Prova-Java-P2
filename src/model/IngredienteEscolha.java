package model;

import java.util.List;

public class IngredienteEscolha {

    private Integer id;
    private Carrinho carrinho;
    private List<IngredienteRemover> ingredientesRemover;
    private List<IngredienteAdicional> ingredientesAdicional;

    public IngredienteEscolha() {
    }

    public IngredienteEscolha(Integer id, Carrinho carrinho, List<IngredienteRemover> ingredientesRemover, List<IngredienteAdicional> ingredientesAdicional) {
        this.id = id;
        this.carrinho = carrinho;
        this.ingredientesRemover = ingredientesRemover;
        this.ingredientesAdicional = ingredientesAdicional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<IngredienteRemover> getIngredientesRemover() {
        return ingredientesRemover;
    }

    public void setIngredientesRemover(List<IngredienteRemover> ingredientesRemover) {
        this.ingredientesRemover = ingredientesRemover;
    }

    public List<IngredienteAdicional> getIngredientesAdicional() {
        return ingredientesAdicional;
    }

    public void setIngredientesAdicional(List<IngredienteAdicional> ingredientesAdicional) {
        this.ingredientesAdicional = ingredientesAdicional;
    }

}
