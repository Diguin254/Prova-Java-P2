package dto;

import model.Bairro;

public class BairroDTO implements InterfaceDTO{

    public String nomeBairro;
    public String idBairro;

    public BairroDTO() {
    }

    public Bairro builder() {
        Bairro b = new Bairro();
        b.setId(idBairro == null ? 0 : Integer.valueOf(idBairro));
        b.setNome(nomeBairro == null ? "" : nomeBairro);
        return b;
    }
}
