package com.example.inmobiliaria2.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;

import java.util.List;

public class DetalleInmuebleViewModel extends ViewModel {
    private MutableLiveData<String>disponible;


    public LiveData<String> getdisponible(){
        if(disponible == null){
            disponible = new MutableLiveData<>();
        }
        return disponible;
    }

    public void cambiarDisponiblilidad(boolean e){

        if(e){
            disponible.setValue("Disponible");
        }else{
            disponible.setValue("No Disponible");
        }
    }
}
