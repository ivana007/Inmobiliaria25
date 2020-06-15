package com.example.inmobiliaria2.ui.propiedades;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.ui.perfil.Propietario;

import java.util.ArrayList;
import java.util.List;

import request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropiedadesViewModel extends AndroidViewModel {
    private MutableLiveData<List<Inmueble>> ListaDeInmuebles;
    private Context context;

    public PropiedadesViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<List<Inmueble>> getListaDeInmuebles(){
        if(ListaDeInmuebles == null){
            ListaDeInmuebles = new MutableLiveData<>();
        }
        return ListaDeInmuebles;
    }

    public void cargarDatos(){
        //ArrayList<Inmueble> listaPropiedades= new ArrayList<>();
        //Inmueble inmueble1= new Inmueble(1,R.drawable.casa1,"Las Flores 123",3,"Casa","Residencial",12000,true);
        //Inmueble inmueble2= new Inmueble(2,R.drawable.local1,"La Calendula  123",1,"Local","Comercial",10000,true);
        //listaPropiedades.add(inmueble1);//debo cargar los inmuebles en la lista
        //listaPropiedades.add(inmueble2);
        //ListaDeInmuebles.setValue(listaPropiedades);
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<List<Inmueble>> inmu= ApiClient.getMyApiClient().misInmuebles(claveToken);
        inmu.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
              if(response.isSuccessful()){
                  ListaDeInmuebles.postValue(response.body());
                  Toast.makeText(context,"lista cargada",Toast.LENGTH_LONG).show();
              }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
                Toast.makeText(context,"lista No cargada",Toast.LENGTH_LONG).show();
            }
        });
    }
}
