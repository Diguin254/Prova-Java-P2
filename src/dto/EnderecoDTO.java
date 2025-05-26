
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
}
