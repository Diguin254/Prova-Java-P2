package dto;

import java.util.LinkedList;
import java.util.List;
import model.Funcionario;
import model.Login;
import model.Telefone;

public class FuncionarioDTO implements InterfaceDTO{

    public FuncionarioDTO() {
    }

    public String idFuncionario;
    public String nomeFun;
    public String cpfFun;
    public String rgFun;
    public String idLogin;
    public List<TelefoneDTO> telefones;

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getRgFun() {
        return rgFun;
    }

    public void setRgFun(String rgFun) {
        this.rgFun = rgFun;
    }

    public String getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(String idLogin) {
        this.idLogin = idLogin;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
    }

    public String getNomeFun() {
        return nomeFun;
    }

    public void setNomeFun(String nomeFun) {
        this.nomeFun = nomeFun;
    }

    public String getCpfFun() {
        return cpfFun;
    }

    public void setCpfFun(String cpfFun) {
        this.cpfFun = cpfFun;
    }
    
    public Funcionario builder() {

        Funcionario f = new Funcionario();
        f.setId(idFuncionario == null ? 0 : Integer.valueOf(idFuncionario));
        f.setNome(nomeFun == null ? "" : nomeFun);
        f.setCpf(cpfFun == null ? "" : cpfFun);
        f.setRg(rgFun == null ? "" : rgFun);

        Login l = new Login();
        l.setId(idLogin == null ? 0 : Integer.valueOf(idLogin));
        f.setLogin(l);

        List<Telefone> lista = new LinkedList<>();
        if (telefones != null) {
            for (TelefoneDTO dto : telefones) {
                Telefone tel = dto.builder();
                tel.setFuncionario(f);
                lista.add(tel);
            }
        }
        f.setTelefones(lista);

        return f;
    }

    @Override
    public String toString() {
        return "FuncionarioDTO{" + "idFuncionario=" + idFuncionario + ", nomeFun=" + nomeFun + ", cpfFun=" + cpfFun + ", rgFun=" + rgFun + ", idLogin=" + idLogin + ", telefones=" + telefones + '}';
    }
}
