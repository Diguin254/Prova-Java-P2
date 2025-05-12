package model;

import java.util.Date;

public class Cupom {

    private Integer id;
    private double valorCupom;
    private String codigo;
    private Date validade;
    private Pagamento pagamento;

    public Cupom() {
    }

    public Cupom(Integer id, double valorCupom, String codigo, Date validade, Pagamento pagamento) {
        this.id = id;
        this.valorCupom = valorCupom;
        this.codigo = codigo;
        this.validade = validade;
        this.pagamento = pagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorCupom() {
        return valorCupom;
    }

    public void setValorCupom(double valorCupom) {
        this.valorCupom = valorCupom;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

}
