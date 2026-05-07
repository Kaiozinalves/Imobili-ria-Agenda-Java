package com.kaiozinalvez.imobiliaria_agendamento.models;

public class Imovel {
    private static Integer nextId = 1;
    private Integer idImovel;
    private TipoImovel tipo;
    private Integer proprietarioId;
    private Double lat, lng;
    private Double preco;
    private String endereco;

    public Imovel(TipoImovel tipo, Integer proprietarioId, Double lat, Double lng, Double preco, String endereco) {
        this.idImovel = nextId;
        this.tipo = tipo;
        this.proprietarioId = proprietarioId;
        this.lat = lat;
        this.lng = lng;
        this.preco = preco;
        this.endereco = endereco;
        nextId++;
    }

    public Integer getIdImovel() {
        return idImovel;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }

    public Integer getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Integer proprietarioId) {
        this.proprietarioId = proprietarioId;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
