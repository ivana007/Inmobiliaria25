package com.example.inmobiliaria2.ui.inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.ui.perfil.Propietario;

public class DetalleInquilinoViewModel extends ViewModel {
    private MutableLiveData<Inquilino> inquilino;


    public LiveData<Inquilino> getInquilino(){
        if(inquilino == null){
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public  void cargarDatos(int idPropiedad){
        Inquilino i= new Inquilino(1,"33444555","Jose","Perez","123456");
        Inquilino i2= new Inquilino(2,"34666777","Martin","Pechz","123456");
        if(idPropiedad==1){
            inquilino.setValue(i);
        }
        if(idPropiedad==2){
            inquilino.setValue(i2);
        }

    }

}
