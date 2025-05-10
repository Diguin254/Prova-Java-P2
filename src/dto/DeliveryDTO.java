package dto;

import model.Delivery;
import model.Endereco;

public class DeliveryDTO {

    public DeliveryDTO() {
    }

    public String idDelivery;
    public String chaveEntregaD;
    public String numeroD;
    public String complementoD;
    public String idEndereco;

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
}
