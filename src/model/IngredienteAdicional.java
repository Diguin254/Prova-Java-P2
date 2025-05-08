package model;

public class IngredienteAdicional {

    private Integer id;
    private String nome;
    private double valor;
    private IngredienteEscolha ingredienteEscolha;

    public IngredienteAdicional() {
    }

    public IngredienteAdicional(Integer id, String nome, double valor, IngredienteEscolha ingredienteEscolha) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ingredienteEscolha = ingredienteEscolha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public IngredienteEscolha getIngredienteEscolha() {
        return ingredienteEscolha;
    }

    public void setIngredienteEscolha(IngredienteEscolha ingredienteEscolha) {
        this.ingredienteEscolha = ingredienteEscolha;
    }

}

