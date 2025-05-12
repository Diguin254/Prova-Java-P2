package model;

public class Endereco {

    private Integer id;
    private String rua;
    private String cep;
    private Bairro bairro;
    private String distancia;

    public Endereco() {
    }

    public Endereco(Integer id, String rua, String cep, Bairro bairro, String distancia) {
        this.id = id;
        this.rua = rua;
        this.cep = cep;
        this.bairro = bairro;
        this.distancia = distancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

}
