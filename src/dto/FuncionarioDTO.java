package dto;

import java.util.LinkedList;
import java.util.List;
import model.Funcionario;
import model.Login;
import model.Telefone;

public class FuncionarioDTO {

    public FuncionarioDTO() {
    }

    public String idFuncionario;
    public String nomeFun;
    public String cpfFun;
    public String rgFun;
    public String idLogin;
    public List<TelefoneDTO> telefones;

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
}
