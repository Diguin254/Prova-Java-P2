package model;

public class IngredienteRemover {

    private Integer id;
    private String nome;
    private IngredienteEscolha ingredienteEscolha;

    public IngredienteRemover() {
    }

    public IngredienteRemover(Integer id, String nome, IngredienteEscolha ingredienteEscolha) {
        this.id = id;
        this.nome = nome;
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

    public IngredienteEscolha getIngredienteEscolha() {
        return ingredienteEscolha;
    }

    public void setIngredienteEscolha(IngredienteEscolha ingredienteEscolha) {
        this.ingredienteEscolha = ingredienteEscolha;
    }

    @Override
    public String toString() {
        return "IngredienteRemover{" + "id=" + id + ", nome=" + nome + ", ingredienteEscolha=" + ingredienteEscolha + '}';
    }

}
