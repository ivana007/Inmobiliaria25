package com.example.inmobiliaria2.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.inmobiliaria2.ui.propiedades.Inmueble;

import request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NuevoInmuebleViewModel extends AndroidViewModel {
    private Context context;
    public NuevoInmuebleViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }
    public void guardarInmueble(Inmueble inmueble){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<Inmueble> inmuebleCall= ApiClient.getMyApiClient().CrearInmueble(claveToken,inmueble);
        inmuebleCall.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context,"  guardado",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context," No guardado",Toast.LENGTH_LONG).show();
            }
        });
    }
}
