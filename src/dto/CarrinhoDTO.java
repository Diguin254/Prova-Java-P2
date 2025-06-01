package dto;

import model.Carrinho;

import model.Pedido;
import model.Produto;

public class CarrinhoDTO implements InterfaceDTO {

    public String idCarrinho;
    public String qntdItens;
    public String idPedido;
    public String idProduto;

    public CarrinhoDTO() {
    }

    public String getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(String idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getQntdItens() {
        return qntdItens;
    }

    public void setQntdItens(String qntdItens) {
        this.qntdItens = qntdItens;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

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

        return c;
    }

    @Override
    public String toString() {
        return "CarrinhoDTO{" + "idCarrinho=" + idCarrinho + ", qntdItens=" + qntdItens + ", idPedido=" + idPedido + ", idProduto=" + idProduto + '}';
    }
}
