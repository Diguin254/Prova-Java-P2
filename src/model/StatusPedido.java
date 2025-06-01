package model;

public class StatusPedido {

    private Integer id;
    private String progresso;

    public StatusPedido() {
    }

    public StatusPedido(Integer id, String progresso) {
        this.id = id;
        this.progresso = progresso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProgresso() {
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }

    @Override
    public String toString() {
        return "StatusPedido{" + "id=" + id + ", progresso=" + progresso + '}';
    }

    
}
