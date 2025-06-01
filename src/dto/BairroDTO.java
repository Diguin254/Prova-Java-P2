package dto;

import model.Bairro;

public class BairroDTO implements InterfaceDTO {

    public String nomeBairro;
    public String idBairro;

    public BairroDTO() {
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public String getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(String idBairro) {
        this.idBairro = idBairro;
    }

    public Bairro builder() {
        Bairro b = new Bairro();
        b.setId(idBairro == null ? 0 : Integer.valueOf(idBairro));
        b.setNome(nomeBairro == null ? "" : nomeBairro);
        return b;
    }

    @Override
    public String toString() {
        return "BairroDTO{" + "nomeBairro=" + nomeBairro + ", idBairro=" + idBairro + '}';
    }

}
