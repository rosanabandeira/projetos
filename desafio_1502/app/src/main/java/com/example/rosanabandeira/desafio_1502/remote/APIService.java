package com.example.rosanabandeira.desafio_1502.remote;

import com.example.rosanabandeira.desafio_1502.model.AddressResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {

    @GET("ws/01001000/json")
    Observable<AddressResponse> getRemoteAddress();

}
