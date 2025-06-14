package dto;

import model.Cliente;
import model.Funcionario;
import model.Telefone;

public class TelefoneDTO implements InterfaceDTO{

    public String idTel;
    public String dddTel;
    public String numTel;
    public String idCliente;
    public String idFuncionario;

    public TelefoneDTO() {

    }

    public String getIdTel() {
        return idTel;
    }

    public void setIdTel(String idTel) {
        this.idTel = idTel;
    }

    public String getDddTel() {
        return dddTel;
    }

    public void setDddTel(String dddTel) {
        this.dddTel = dddTel;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
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

    @Override
    public String toString() {
        return numTel;
    }
    
    @Override
    public int getId() {
        return (idTel == null || idTel.isBlank()) ? 0 : Integer.parseInt(idTel);
    }

    @Override
    public void setId(int id) {
        this.idTel = String.valueOf(id);
    }
}
