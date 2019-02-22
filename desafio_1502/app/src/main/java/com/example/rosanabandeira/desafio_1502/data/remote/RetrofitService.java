package com.example.rosanabandeira.desafio_1502.data.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String BASE_URL = "https://viacep.com.br/";

    private static Retrofit retrofit;

    private static Retrofit getRetrofit() {

        if (retrofit == null) {
           /* OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.readTimeout( 30, TimeUnit.SECONDS );
            httpClient.connectTimeout( 30, TimeUnit.SECONDS );
            httpClient.writeTimeout( 30, TimeUnit.SECONDS );*/

            retrofit = new Retrofit.Builder()
                    .baseUrl( BASE_URL )
                    .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                    .addConverterFactory( GsonConverterFactory.create() )
                    //.client( httpClient.build() )
                    .build();
        }

        return retrofit;
    }

    public static APIService getApiService() {
        return getRetrofit().create( APIService.class );
    }


}
