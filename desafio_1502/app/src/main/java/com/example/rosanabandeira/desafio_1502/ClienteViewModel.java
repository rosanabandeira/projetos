package com.example.rosanabandeira.desafio_1502;


import android.databinding.ObservableField;

public class ClienteViewModel {

    public ObservableField<String> nomeCompleto = new ObservableField<>();
    public ObservableField<String> cpf = new ObservableField<>();
    public ObservableField<String> endereco = new ObservableField<>();
    public ObservableField<String> dataDeNascimento = new ObservableField<>();

}
