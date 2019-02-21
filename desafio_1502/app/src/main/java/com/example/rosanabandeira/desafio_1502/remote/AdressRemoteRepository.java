package com.example.rosanabandeira.desafio_1502.remote;

import com.example.rosanabandeira.desafio_1502.model.AddressResponse;

import io.reactivex.Observable;

public class AdressRemoteRepository {

    public Observable<AddressResponse> getRemoteAddress() {
        return RetrofitService.getApiService().getRemoteAddress();
    }
}
