
package dto;

import model.Bairro;
import model.Endereco;

public class EnderecoDTO implements InterfaceDTO{

    public EnderecoDTO() {
    }

    public String idEndereco;
    public String ruaEnd;
    public String cepEnd;
    public String idBairro;
    public String distanciaEnd;

    public String getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(String idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRuaEnd() {
        return ruaEnd;
    }

    public void setRuaEnd(String ruaEnd) {
        this.ruaEnd = ruaEnd;
    }

    public String getCepEnd() {
        return cepEnd;
    }

    public void setCepEnd(String cepEnd) {
        this.cepEnd = cepEnd;
    }

    public String getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(String idBairro) {
        this.idBairro = idBairro;
    }

    public String getDistanciaEnd() {
        return distanciaEnd;
    }

    public void setDistanciaEnd(String distanciaEnd) {
        this.distanciaEnd = distanciaEnd;
    }

    public Endereco builder() {
        Endereco end = new Endereco();
        end.setId(idEndereco == null ? 0 : Integer.valueOf(idEndereco));
        end.setRua(ruaEnd == null ? "" : ruaEnd);
        end.setCep(cepEnd == null ? "" : cepEnd);

        Bairro bai = new Bairro();
        bai.setId(idBairro == null ? 0 : Integer.valueOf(idBairro));
        end.setBairro(bai);

        end.setDistancia(distanciaEnd == null ? "" : distanciaEnd);

        return end;
    }

    @Override
    public String toString() {
        return "EnderecoDTO{" + "idEndereco=" + idEndereco + ", ruaEnd=" + ruaEnd + ", cepEnd=" + cepEnd + ", idBairro=" + idBairro + ", distanciaEnd=" + distanciaEnd + '}';
    }
    
    @Override
    public int getId() {
        return (idEndereco == null || idEndereco.isBlank()) ? 0 : Integer.parseInt(idEndereco);
    }

    @Override
    public void setId(int id) {
        this.idEndereco = String.valueOf(id);
    }
}
