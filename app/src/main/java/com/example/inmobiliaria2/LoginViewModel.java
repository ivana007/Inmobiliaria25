package com.example.inmobiliaria2;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.io.*;
public class LoginViewModel extends AndroidViewModel {
    //private MutableLiveData<String> email;
    //private MutableLiveData<String>pass;
    private MutableLiveData<String>cartel;
    private Context context;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public MutableLiveData<String> getCartel() {
        if(cartel==null){
            cartel= new MutableLiveData<String>();
        }
        return cartel;
    }


    public void validardatos(String email, String pass){

        if(email.equals("") || pass.equals("")) {
            cartel.setValue("debe completar todos los datos");

        }else
        {
            Usuario usuario= new Usuario(email,pass);

            Call<String>dato= ApiClient.getMyApiClient().login(usuario);
            dato.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()){

                        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        String d="Bearer"+ " " +response.body();
                        editor.putString("token",d);
                        editor.commit();
                        Log.d("token guaradado",d);
                        Intent intent= new Intent(getApplication().getApplicationContext(),MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplication().getApplicationContext().startActivity(intent);
                    }else {

                        cartel.postValue("error,Email o contraseña incorrectos");
                        Toast.makeText(context,response.errorBody().toString(),Toast.LENGTH_LONG).show();


                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(context,"on failure",Toast.LENGTH_LONG).show();
                }
            });


        }/*else {
                cartel.setValue("Email o contraseña incorrectos");

        }*/


    }
}
