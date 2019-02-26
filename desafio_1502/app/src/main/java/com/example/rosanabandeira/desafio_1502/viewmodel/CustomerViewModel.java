package com.example.rosanabandeira.desafio_1502.viewmodel;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.util.Log;
import android.widget.ImageView;

import com.example.rosanabandeira.desafio_1502.R;
import com.example.rosanabandeira.desafio_1502.data.local.Dao.CustomersDao;
import com.example.rosanabandeira.desafio_1502.data.local.Database.DatabaseRoom;
import com.example.rosanabandeira.desafio_1502.data.remote.APIService;
import com.example.rosanabandeira.desafio_1502.data.remote.RetrofitService;
import com.example.rosanabandeira.desafio_1502.model.Address;
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

    public String cep = "";
    public String rua = "";
    public String numero = "";
    public String complemento = "";
    public String bairro = "";
    public String uf = "";
    public String cidade = "";

    public ObservableField<String> obsCep;
    public ObservableField<String> obsRua;
    public ObservableField<String> obsNumero;
    public ObservableField<String> obsComplemento;
    public ObservableField<String> obsUF;
    public ObservableField<String> obsBairro;
    public ObservableField<String> obsCidade;
    public ObservableField<String> obsFullName;
    public ObservableField<String> obsCPF;
    public ObservableField<String> obsBorn;

    public CustomersDao customersDao;


    private Context context;


    public CustomerViewModel(Context context) {
        this();
        this.context = context;
    }

    public CustomerViewModel() {

        this.customers = new Customers();

        this.obsCep = new ObservableField<>();
        this.obsRua = new ObservableField<>();
        this.obsNumero = new ObservableField<>();
        this.obsComplemento = new ObservableField<>();
        this.obsUF = new ObservableField<>();
        this.obsBairro = new ObservableField<>();
        this.obsCidade = new ObservableField<>();
        this.obsFullName = new ObservableField<>();
        this.obsCPF = new ObservableField<>();
        this.obsBorn = new ObservableField<>();


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
        this.born = customers.born;
        this.idUser = customers.idUser;

    }

    public void init(Context context) {
        this.context = context;
    }


    public MutableLiveData<ArrayList<CustomerViewModel>> getArrayListMutableLiveData(Context context) {


        arrayList = new ArrayList<>();

        /*Customers customers = new Customers( getImageUrl(), "Andre", "19/02/89", "123.456.789-00" );
        CustomerViewModel customerViewModel = new CustomerViewModel( customers );
        customers.setImageView( "https://www.urbanarts.com.br/imagens/produtos/067980/0/Ampliada/coringa-classico.jpg" );
        arrayList.add( customerViewModel );*/

        Customers customers1 = new Customers( getImageUrl(), "Coringa", "666666", "xxxxx" );
        CustomerViewModel customerViewModel1 = new CustomerViewModel( customers1 );
        customerViewModel1.init( context );
        customers.setImageView( "https://www.urbanarts.com.br/imagens/produtos/067980/0/Ampliada/coringa-classico.jpg" );
        arrayList.add( customerViewModel1 );


        arrayListMutableLiveData.setValue( arrayList );
        this.context = context;
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
                obsRua.set( addressResponse.getLogradouro() );
                obsCidade.set( addressResponse.getLocalidade() );
                obsUF.set( addressResponse.getUnidade() );
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

    public void afterCepTextChanged(CharSequence charSequence) {
        obsCep.set( charSequence.toString() );
    }

    public void saveCustomer() {
        customers = new Customers();

        Address address = new Address();
        address.setBairro( obsBairro.get() );
        address.setCep( obsCep.get() );
        address.setComplemento( obsComplemento.get() );
        address.setLocalidade( obsCidade.get() );
        address.setLogradouro( obsRua.get() );
        address.setNumero( obsNumero.get() );
        address.setUf( obsUF.get() );

        customers.setAddress( address );

        customers.setFullName( obsFullName.get() );
        customers.setBorn( obsFullName.get() );
        customers.setIdUser( obsCPF.get() );

        DatabaseRoom room = DatabaseRoom.getDatabase( context );
        customersDao = room.customersDao();

        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                customersDao.insert( customers );
            }
        } );

        thread.start();

    }


    public void afterCpfTextChanged(CharSequence charSequence) {
        obsCPF.set( charSequence.toString() );
    }

    public void afterFullNameTextChanged(CharSequence charSequence) {
        obsFullName.set( charSequence.toString() );
    }

    public void afterBornTextChanged(CharSequence charSequence) {
        obsBorn.set( charSequence.toString() );
    }


}