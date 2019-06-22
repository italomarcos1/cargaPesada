package model;

public class Cliente {
    private int idcliente;
    private String nome;
    private String telefone;
    private String id_tipo_cliente;
    private String local_uf;
    private String local_ceṕ;


    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId_tipo_cliente() {
        return id_tipo_cliente;
    }

    public void setId_tipo_cliente(String id_tipo_cliente) {
        this.id_tipo_cliente = id_tipo_cliente;
    }

    public String getLocal_uf() {
        return local_uf;
    }

    public void setLocal_uf(String local_uf) {
        this.local_uf = local_uf;
    }

    public String getLocal_ceṕ() {
        return local_ceṕ;
    }

    public void setLocal_ceṕ(String local_ceṕ) {
        this.local_ceṕ = local_ceṕ;
    }
}
