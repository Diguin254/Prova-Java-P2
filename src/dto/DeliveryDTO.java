package dto;

import model.Delivery;
import model.Endereco;

public class DeliveryDTO implements InterfaceDTO{

    public DeliveryDTO() {
    }

    public String idDelivery;
    public String chaveEntregaD;
    public String numeroD;
    public String complementoD;
    public String idEndereco;

    public String getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(String idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getChaveEntregaD() {
        return chaveEntregaD;
    }

    public void setChaveEntregaD(String chaveEntregaD) {
        this.chaveEntregaD = chaveEntregaD;
    }

    public String getNumeroD() {
        return numeroD;
    }

    public void setNumeroD(String numeroD) {
        this.numeroD = numeroD;
    }

    public String getComplementoD() {
        return complementoD;
    }

    public void setComplementoD(String complementoD) {
        this.complementoD = complementoD;
    }

    public String getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(String idEndereco) {
        this.idEndereco = idEndereco;
    }
    public Delivery builder() {
        Delivery d = new Delivery();
        d.setId(idDelivery == null ? 0 : Integer.valueOf(idDelivery));
        d.setChaveEntrega(chaveEntregaD == null ? "" : chaveEntregaD);
        d.setNumero(numeroD == null ? 0 : Integer.valueOf(numeroD));
        d.setComplemento(complementoD == null ? "" : complementoD);

        Endereco end = new Endereco();
        end.setId(idEndereco == null ? 0 : Integer.valueOf(idEndereco));
        d.setEndereco(end);

        return d;
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" + "idDelivery=" + idDelivery + ", chaveEntregaD=" + chaveEntregaD + ", numeroD=" + numeroD + ", complementoD=" + complementoD + ", idEndereco=" + idEndereco + '}';
    }
    
    @Override
    public int getId() {
        return (idDelivery == null || idDelivery.isBlank()) ? 0 : Integer.parseInt(idDelivery);
    }

    @Override
    public void setId(int id) {
        this.idDelivery = String.valueOf(id);
    }
}
