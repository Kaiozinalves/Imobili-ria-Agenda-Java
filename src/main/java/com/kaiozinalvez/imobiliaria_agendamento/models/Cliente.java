package com.kaiozinalvez.imobiliaria_agendamento.models;

public class Cliente {
    private static Integer nextId = 1;
    private Integer idCliente;
    private String nomeCliente;
    private String telefone;

    public Cliente(String nomeCliente, String telefone) {
        this.idCliente = nextId;
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        nextId++;
    }

    public static Integer getNextId() {
        return nextId;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
