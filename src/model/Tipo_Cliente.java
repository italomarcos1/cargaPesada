package model;

public class Tipo_Cliente {
    private int id_tipo_cliente;
    private String nome;
    private String numcad;

    public int getId_tipo_cliente() {
        return id_tipo_cliente;
    }

    public void setId_tipo_cliente(int id_tipo_cliente) {
        this.id_tipo_cliente = id_tipo_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumcad() {
        return numcad;
    }

    public void setNumcad(String numcad) {
        this.numcad = numcad;
    }
}
