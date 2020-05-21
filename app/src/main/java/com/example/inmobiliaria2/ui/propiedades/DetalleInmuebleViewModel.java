package com.example.inmobiliaria2.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;

import java.util.List;

public class DetalleInmuebleViewModel extends ViewModel {
    private MutableLiveData<String>disponible;
    private MutableLiveData<Inmueble>inmuebleMutableLiveData;


    public LiveData<String> getdisponible(){
        if(disponible == null){
            disponible = new MutableLiveData<>();
        }
        return disponible;
    }
    public LiveData<Inmueble> getinmuebleMutableLiveData(){
        if(inmuebleMutableLiveData == null){
            inmuebleMutableLiveData = new MutableLiveData<>();
        }
        return inmuebleMutableLiveData;
    }

    public void cambiarDisponiblilidad(boolean e){

        if(e){
            disponible.setValue("Disponible");
        }else{
            disponible.setValue("No Disponible");
        }
    }
    public void cargarDatos(int idInmueble){
        Inmueble inmueble1= new Inmueble(1,R.drawable.casa1,"Las Flores 123",3,"Casa","Residencial",12000,true);
        Inmueble inmueble2= new Inmueble(2,R.drawable.local1,"La Calendula  123",1,"Local","Comercial",10000,false);
        if(idInmueble == inmueble1.getId()){
            inmuebleMutableLiveData.setValue(inmueble1);

        }
        if(idInmueble == inmueble2.getId()){
            inmuebleMutableLiveData.setValue(inmueble2);
        }
    }
}
