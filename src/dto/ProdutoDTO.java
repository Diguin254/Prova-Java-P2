package dto;

import java.util.LinkedList;
import java.util.List;
import model.Carrinho;
import model.Produto;

public class ProdutoDTO implements InterfaceDTO{

    public ProdutoDTO() {
    }

    public String idProd;
    public String nomeProd;
    public String valUnProd;
    public List<CarrinhoDTO> carrinhos;

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getValUnProd() {
        return valUnProd;
    }

    public void setValUnProd(String valUnProd) {
        this.valUnProd = valUnProd;
    }

    public List<CarrinhoDTO> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<CarrinhoDTO> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public Produto builder() {

        Produto p = new Produto();
        p.setId(idProd == null ? 0 : Integer.valueOf(idProd));
        p.setNome(nomeProd == null ? "" : nomeProd);
        p.setValorUnitario(valUnProd == null ? 0.0 : Double.valueOf(valUnProd));

        List<Carrinho> listaCar = new LinkedList<>();
        if (carrinhos != null) {
            for (CarrinhoDTO dto : carrinhos) {
                Carrinho car = dto.builder();
                car.setProduto(p);
                listaCar.add(car);
            }
        }
        p.setCarrinhos(listaCar);

        return p;
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" + "idProd=" + idProd + ", nomeProd=" + nomeProd + ", valUnProd=" + valUnProd + ", carrinhos=" + carrinhos + '}';
    }
    
}
