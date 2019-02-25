package com.example.rosanabandeira.desafio_1502.viewmodel;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.util.Log;
import android.widget.ImageView;

import com.example.rosanabandeira.desafio_1502.R;
import com.example.rosanabandeira.desafio_1502.data.remote.APIService;
import com.example.rosanabandeira.desafio_1502.data.remote.RetrofitService;
import com.example.rosanabandeira.desafio_1502.model.AddressResponse;
import com.example.rosanabandeira.desafio_1502.model.Customers;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CustomerViewModel extends ViewModel {

    public String imageView = "";
    public String fullName = "";
    public String address = "";
    public String born = "";
    public String idUser = "";
    public Customers customers;

    public ObservableField<String> obsCep;
    public ObservableField<String> obsRua;
    public ObservableField<String> obsNumero;
    public ObservableField<String> obsComplemento;
    public ObservableField<String> obsUF;
    public ObservableField<String> obsBairro;
    public ObservableField<String> obsCidade;


    public CustomerViewModel() {
        this.customers = new Customers();

        this.obsCep = new ObservableField<>();
        this.obsRua = new ObservableField<>();
        this.obsNumero = new ObservableField<>();
        this.obsComplemento = new ObservableField<>();
        this.obsUF = new ObservableField<>();
        this.obsBairro = new ObservableField<>();
        this.obsCidade = new ObservableField<>();


    }

    public MutableLiveData<ArrayList<CustomerViewModel>> arrayListMutableLiveData = new MutableLiveData<>();

    private ArrayList<CustomerViewModel> arrayList;

    public String getImageUrl() {
        return "https://www.urbanarts.com.br/imagens/produtos/067980/0/Ampliada/coringa-classico.jpg";
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {

        Picasso.get()
                .load( "https://www.urbanarts.com.br/imagens/produtos/067980/0/Ampliada/coringa-classico.jpg" )
                .placeholder( R.drawable.user )
                .into( imageView );

    }

    public CustomerViewModel(Customers customers) {

        this();

        this.imageView = customers.imageView;
        this.fullName = customers.fullName;
        this.address = customers.address;
        this.born = customers.born;
        this.idUser = customers.idUser;

    }

    public MutableLiveData<ArrayList<CustomerViewModel>> getArrayListMutableLiveData() {

        arrayList = new ArrayList<>();

        Customers customers = new Customers( getImageUrl(), "Andre", "Rua Boa Vista", "19/02/89", "123.456.789-00" );
        CustomerViewModel customerViewModel = new CustomerViewModel( customers );
        customers.setImageView( "https://www.urbanarts.com.br/imagens/produtos/067980/0/Ampliada/coringa-classico.jpg" );
        arrayList.add( customerViewModel );

        Customers customers1 = new Customers( getImageUrl(), "Coringa", "Inferno", "666666", "xxxxx" );
        CustomerViewModel customerViewModel1 = new CustomerViewModel( customers1 );
        customers.setImageView( "https://www.urbanarts.com.br/imagens/produtos/067980/0/Ampliada/coringa-classico.jpg" );
        arrayList.add( customerViewModel1 );


        arrayListMutableLiveData.setValue( arrayList );
        return arrayListMutableLiveData;


    }

    public void loadImage() {

    }

    public void searchCep() {

        APIService retrofit = RetrofitService.getApiService();

        final Observable<AddressResponse> observable = retrofit.getRemoteAddress( obsCep.get() );


        observable.subscribeOn( Schedulers.newThread() ).subscribe( new io.reactivex.Observer<AddressResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(AddressResponse addressResponse) {
                Log.i( "entrou", "onNext: " + addressResponse.getBairro() );
                obsBairro.set( addressResponse.getBairro() );
            }

            @Override
            public void onError(Throwable e) {

                Log.i( "entrou", "onError: " + e.getMessage() );

            }

            @Override
            public void onComplete() {

            }
        } );
    }

    public void afterCepTextChanged (CharSequence charSequence){
        obsCep.set( charSequence.toString() );
    }


}