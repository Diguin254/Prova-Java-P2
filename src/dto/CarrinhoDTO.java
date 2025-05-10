package dto;

import model.Carrinho;
import model.IngredienteEscolha;
import model.Pedido;
import model.Produto;

public class CarrinhoDTO {

    public CarrinhoDTO() {
    }

    public String idCarrinho;
    public String qntdItens;
    public String idPedido;
    public String idProduto;
    public String idIngredienteEscolha;

    public Carrinho builder() {
        Carrinho c = new Carrinho();
        c.setId(idCarrinho == null ? 0 : Integer.valueOf(idCarrinho));
        c.setQntd(qntdItens == null ? 0 : Integer.valueOf(qntdItens));

        Pedido pe = new Pedido();
        pe.setId(idPedido == null ? 0 : Integer.valueOf(idPedido));
        c.setPedido(pe);

        Produto pro = new Produto();
        pro.setId(idProduto == null ? 0 : Integer.valueOf(idProduto));
        c.setProduto(pro);

        IngredienteEscolha ing = new IngredienteEscolha();
        ing.setId(idIngredienteEscolha == null ? 0 : Integer.valueOf(idIngredienteEscolha));
        c.setIngredienteEscolha(ing);

        return c;
    }
}
