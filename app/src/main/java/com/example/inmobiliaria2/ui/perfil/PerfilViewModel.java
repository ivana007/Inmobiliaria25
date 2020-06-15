package com.example.inmobiliaria2.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;

import request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {
private MutableLiveData<Propietario>propietario;
private Context context;
    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }


    public LiveData<Propietario> getPropietario(){
        if(propietario == null){
            propietario = new MutableLiveData<>();
        }
        return propietario;
    }

public  void cargarDatos(){
    SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
    String claveToken=sharedPreferences.getString("token","-1");
    Call<Propietario> prop= ApiClient.getMyApiClient().buscarpropietario(claveToken);
    prop.enqueue(new Callback<Propietario>() {
        @Override
        public void onResponse(Call<Propietario> call, Response<Propietario> response) {
            if(response.isSuccessful()){
                Propietario propietario1=response.body();
                Toast.makeText(context,propietario1.getNombre()+"",Toast.LENGTH_LONG).show();
                propietario.postValue(propietario1);
            }else{
                Toast.makeText(context,"estoy en el else",Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onFailure(Call<Propietario> call, Throwable t) {
            Toast.makeText(context,"on failure",Toast.LENGTH_LONG).show();
                t.printStackTrace();
        }
    });
    //Propietario p= new Propietario("27376007","Juana","Shwan","123456","juana@j.com","juana");
    //propietario.setValue(p);
}
public void actualizar(Propietario p){
    SharedPreferences sharedPreferences=context.getSharedPreferences("token",0);
    String claveToken=sharedPreferences.getString("token","-1");
    Call<Propietario>prop=ApiClient.getMyApiClient().actualizar(claveToken,p);
    prop.enqueue(new Callback<Propietario>() {
        @Override
        public void onResponse(Call<Propietario> call, Response<Propietario> response) {
            if(response.isSuccessful()){
                Toast.makeText(context,"Datos Guardados",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<Propietario> call, Throwable t) {
            Toast.makeText(context,"No Guardado",Toast.LENGTH_LONG).show();
        }
    });
}


}
