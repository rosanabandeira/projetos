package com.example.rosanabandeira.desafio_1502.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

@Entity(tableName = "customer")
public class Address {

    @ColumnInfo(name = "bairro")
    private String bairro;
    @ColumnInfo(name = "cep")
    private String cep;
    @ColumnInfo(name = "logradouro")
    private String logradouro;
    @ColumnInfo(name = "localidade")
    private String localidade;
    @ColumnInfo(name = "uf")
    private String uf;
    @ColumnInfo(name = "complemento")
    private String complemento;
    @ColumnInfo(name = "numero")
    private String numero;


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
