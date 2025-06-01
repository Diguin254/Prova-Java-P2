package model;

import java.util.List;

public class Cliente {

    private Integer id;
    private String nome;
    private List<Telefone> telefones;
    private List<Pedido> pedidos;
    private List<Entrega> entregas;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, List<Telefone> telefones, List<Pedido> pedidos, List<Entrega> entregas) {
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
        this.pedidos = pedidos;
        this.entregas = entregas;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", telefones=" + telefones + ", pedidos=" + pedidos + ", entregas=" + entregas + '}';
    }

}
