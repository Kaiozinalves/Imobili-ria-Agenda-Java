package com.kaiozinalvez.imobiliaria_agendamento.models;

public class Corretor {
    private static Integer nextID = 1;
    private Integer idCorretor;
    private String nomeCorretor;
    private String telefone;
    private Boolean avaliador;
    private Double lat, lng;

    public Corretor(String nomeCorretor, String telefone, Boolean avaliador, Double lat, Double lng) {
        this.idCorretor = nextID;
        this.nomeCorretor = nomeCorretor;
        this.telefone = telefone;
        this.avaliador = avaliador;
        this.lat = lat;
        this.lng = lng;
        nextID++;
    }

    public Integer getIdCorretor() {
        return idCorretor;
    }

    public String getNomeCorretor() {
        return nomeCorretor;
    }

    public void setNomeCorretor(String nomeCorretor) {
        this.nomeCorretor = nomeCorretor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Boolean avaliador) {
        this.avaliador = avaliador;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
