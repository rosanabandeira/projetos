
package com.example.rosanabandeira.desafio_1502.model;


import android.location.Address;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddressResponse {

    @SerializedName("address")

    private List<Address> newListAdress;

    //public AddressResponse(AddressActivity context) {

    //}

    @SerializedName("bairro")
    @Expose
    private String bairro;
    @SerializedName("cep")
    @Expose
    private String cep;
    @SerializedName("complemento")
    @Expose
    private String complemento;
    @SerializedName("gia")
    @Expose
    private String gia;
    @SerializedName("ibge")
    @Expose
    private String ibge;
    @SerializedName("localidade")
    @Expose
    private String localidade;
    @SerializedName("logradouro")
    @Expose
    private String logradouro;
    @SerializedName("uf")
    @Expose
    private String uf;
    @SerializedName("unidade")
    @Expose
    private String unidade;


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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void execute() {
    }
}
