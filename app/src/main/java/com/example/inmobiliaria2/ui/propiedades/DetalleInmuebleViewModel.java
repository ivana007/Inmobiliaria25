package com.example.inmobiliaria2.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class DetalleInmuebleViewModel extends ViewModel {
    private MutableLiveData<Integer>foto;
    private MutableLiveData<String>direccion;
    private MutableLiveData<String>precio;
    public LiveData<Integer> getfoto(){
        if(foto == null){
            foto = new MutableLiveData<>();
        }
        return foto;
    }
    public LiveData<String> getdireccion(){
        if(direccion == null){
            direccion = new MutableLiveData<>();
        }
        return direccion;
    }
    public LiveData<String> getprecio(){
        if(precio == null){
            precio = new MutableLiveData<>();
        }
        return precio;
    }
    public void ObtenerDatos(){

    }
}
