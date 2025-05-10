package dto;

import model.Cliente;
import model.Funcionario;
import model.Telefone;

public class TelefoneDTO {

    public String idTel;
    public String dddTel;
    public String numTel;
    public String idCliente;
    public String idFuncionario;

    public TelefoneDTO() {

    }

    public Telefone builder() {
        Telefone t = new Telefone();
        t.setId(idTel == null ? 0 : Integer.valueOf(idTel));
        t.setDdd(dddTel == null ? 0 : Integer.valueOf(dddTel));
        t.setNumero(numTel == null ? "" : numTel);

        Cliente c = new Cliente();
        c.setId(idCliente == null ? 0 : Integer.valueOf(idCliente));
        t.setCliente(c);

        Funcionario f = new Funcionario();
        f.setId(idFuncionario == null ? 0 : Integer.valueOf(idFuncionario));
        t.setFuncionario(f);

        return t;
    }
}
