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
import androidx.navigation.Navigation;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.ui.perfil.Propietario;

import java.util.List;

import request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleInmuebleViewModel extends AndroidViewModel {
    //private MutableLiveData<String>disponible;
    private MutableLiveData<Inmueble>inmuebleMutableLiveData;
    private Context context;
  int id=0;

    public DetalleInmuebleViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }


   /* public LiveData<String> getdisponible(){
        if(disponible == null){
            disponible = new MutableLiveData<>();
        }
        return disponible;
    }*/
    public LiveData<Inmueble> getinmuebleMutableLiveData(){
        if(inmuebleMutableLiveData == null){
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
    }

   /* public void cambiarDisponiblilidad(boolean e){

        if(e){
            disponible.setValue("Disponible");
        }else{
            disponible.setValue("No Disponible");
        }
    }*/
    public void cargarDatos(final int idInmueble){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<List<Inmueble>> inmu= ApiClient.getMyApiClient().misInmuebles(claveToken);
        inmu.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()){
                    List<Inmueble> inmuebleList=response.body();
                    for(Inmueble inmueble : inmuebleList){
                        if(idInmueble==inmueble.getIdInmueble()){
                            inmuebleMutableLiveData.postValue(inmueble);
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
                Toast.makeText(context,"inmueble No cargado",Toast.LENGTH_LONG).show();
            }
        });

       /* Inmueble inmueble1= new Inmueble(1,R.drawable.casa1,"Las Flores 123",3,"Casa","Residencial",12000,true);
        Inmueble inmueble2= new Inmueble(2,R.drawable.local1,"La Calendula  123",1,"Local","Comercial",10000,false);
        if(idInmueble == inmueble1.getId()){
            inmuebleMutableLiveData.setValue(inmueble1);

        }
        if(idInmueble == inmueble2.getId()){
            inmuebleMutableLiveData.setValue(inmueble2);
        }*/


    }
    public  void borrarInmueble(int id){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String token=sharedPreferences.getString("token","-1");


        Call<Inmueble> i= ApiClient.getMyApiClient().EliminarInmueble(token,id);
        i.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                   // Inmueble in=response.body();
                    Toast.makeText(context,"inmueble Eliminado",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context,"inmueble No Borrardo",Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }
    public void modificarInmueble(Inmueble inmu){
        SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
        String claveToken=sharedPreferences.getString("token","-1");
        Call<Inmueble> i= ApiClient.getMyApiClient().CambiarInmueble(claveToken,inmu);
        i.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context,"inmueble Modificado",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context,"inmueble No Modificado",Toast.LENGTH_LONG).show();
            }
        }) ;
    }
}
