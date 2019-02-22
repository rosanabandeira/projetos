package com.example.rosanabandeira.desafio_1502;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.rosanabandeira.desafio_1502.adapter.ZipCodeListener;
import com.facebook.stetho.common.Util;

public class AddressActivity extends AppCompatActivity {

    private EditText etZipCode;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_adress );

        etZipCode = findViewById( R.id.et_zip_code );
        etZipCode.addTextChangedListener( new ZipCodeListener( this ) );

        Spinner spStates = findViewById( R.id.sp_state );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource( this,
                        R.array.states,
                        android.R.layout.simple_spinner_item );
        spStates.setAdapter( adapter );

    }

    private String getZipCode() {
        return etZipCode.getText().toString();
    }

    public String getUriRequest() {
        return "https://viacep.com.br/ws/" + getZipCode() + "/json/";
    }

    public void lockFields(boolean isToLock) {
        appUtil.lockFields( isToLock );
    }


    public void searchZipCode(View view) {

    }
}
