package com.example.inmobiliaria2.ui.contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class ContratoViewModel extends ViewModel {
    private MutableLiveData<List<Inmueble>> ListaDeInmuebles;

    public LiveData<List<Inmueble>> getListaDeInmuebles(){
        if(ListaDeInmuebles == null){
            ListaDeInmuebles = new MutableLiveData<>();
        }
        return ListaDeInmuebles;
    }

    public void cargarDatos(){
        ArrayList<Inmueble> listaPropiedades= new ArrayList<>();
        Inmueble inmueble1= new Inmueble(1, R.drawable.casa1,"Las Flores 123",3,"Casa","Residencial",12000,true);
        Inmueble inmueble2= new Inmueble(2,R.drawable.local1,"La Calendula  123",1,"Local","Comercial",10000,false);
        listaPropiedades.add(inmueble1);//debo cargar los inmuebles en la lista
        listaPropiedades.add(inmueble2);
        ListaDeInmuebles.setValue(listaPropiedades);
    }
}
