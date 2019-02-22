package com.example.rosanabandeira.desafio_1502.data.remote;

import com.example.rosanabandeira.desafio_1502.model.AddressResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {

    @GET("ws/{CEP}/json")
    Observable<AddressResponse> getRemoteAddress(@Path("CEP") String Cep);


}
