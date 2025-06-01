package dto;

import java.util.LinkedList;
import java.util.List;
import model.Carrinho;
import model.IngredienteAdicional;
import model.IngredienteEscolha;
import model.IngredienteRemover;

public class IngredienteEscolhaDTO implements InterfaceDTO{

    public IngredienteEscolhaDTO() {
    }

    public String idIngrEsc;
    public String idCarrinho;
    public List<IngredienteRemoverDTO> ingrRemovs;
    public List<IngredienteAdicionalDTO> ingrAdcs;

    public String getIdIngrEsc() {
        return idIngrEsc;
    }

    public void setIdIngrEsc(String idIngrEsc) {
        this.idIngrEsc = idIngrEsc;
    }

    public String getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(String idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public List<IngredienteRemoverDTO> getIngrRemovs() {
        return ingrRemovs;
    }

    public void setIngrRemovs(List<IngredienteRemoverDTO> ingrRemovs) {
        this.ingrRemovs = ingrRemovs;
    }

    public List<IngredienteAdicionalDTO> getIngrAdcs() {
        return ingrAdcs;
    }

    public void setIngrAdcs(List<IngredienteAdicionalDTO> ingrAdcs) {
        this.ingrAdcs = ingrAdcs;
    }

    public IngredienteEscolha builder() {
        IngredienteEscolha ingr = new IngredienteEscolha();
        ingr.setId(idIngrEsc == null ? 0 : Integer.valueOf(idIngrEsc));

        Carrinho c = new Carrinho();
        c.setId(idCarrinho == null ? 0 : Integer.valueOf(idCarrinho));
        ingr.setCarrinho(c);

        List<IngredienteRemover> listaIR = new LinkedList<>();
        if (ingrRemovs != null) {
            for (IngredienteRemoverDTO dto : ingrRemovs) {
                IngredienteRemover ingrRemov = dto.builder();
                ingrRemov.setIngredienteEscolha(ingr);
                listaIR.add(ingrRemov);
            }
        }
        ingr.setIngredientesRemover(listaIR);

        List<IngredienteAdicional> listaIA = new LinkedList<>();
        if (ingrAdcs != null) {
            for (IngredienteAdicionalDTO dto : ingrAdcs) {
                IngredienteAdicional ingrAdc = dto.builder();
                ingrAdc.setIngredienteEscolha(ingr);
                listaIA.add(ingrAdc);
            }
        }
        ingr.setIngredientesAdicional(listaIA);

        return ingr;
    }

    @Override
    public String toString() {
        return "IngredienteEscolhaDTO{" + "idIngrEsc=" + idIngrEsc + ", idCarrinho=" + idCarrinho + ", ingrRemovs=" + ingrRemovs + ", ingrAdcs=" + ingrAdcs + '}';
    }
    
    
}
