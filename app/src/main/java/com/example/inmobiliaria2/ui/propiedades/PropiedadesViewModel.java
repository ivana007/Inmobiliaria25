package com.example.inmobiliaria2.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesViewModel extends ViewModel {
    private MutableLiveData<List<Inmueble>> ListaDeInmuebles;

    public LiveData<List<Inmueble>> getListaDeInmuebles(){
        if(ListaDeInmuebles == null){
            ListaDeInmuebles = new MutableLiveData<>();
        }
        return ListaDeInmuebles;
    }

    public void cargarDatos(){
        ArrayList<Inmueble> listaPropiedades= new ArrayList<>();
        Inmueble inmueble1= new Inmueble(1,R.drawable.casa1,"Las Flores 123",3,"Casa","Residencial",12000,true);
        Inmueble inmueble2= new Inmueble(2,R.drawable.local1,"La Calendula  123",1,"Local","Comercial",10000,true);
        listaPropiedades.add(inmueble1);//debo cargar los inmuebles en la lista
        listaPropiedades.add(inmueble2);
        ListaDeInmuebles.setValue(listaPropiedades);
    }
}
