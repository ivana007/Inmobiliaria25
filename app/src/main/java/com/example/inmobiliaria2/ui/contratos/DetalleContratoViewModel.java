package com.example.inmobiliaria2.ui.contratos;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.ui.inquilinos.Inquilino;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;

import java.time.LocalDate;

public class DetalleContratoViewModel extends ViewModel {
    private MutableLiveData<Contrato>contratoMutableLiveData;


    public LiveData<Contrato> getcontratoMutableLiveData(){
        if(contratoMutableLiveData == null){
            contratoMutableLiveData = new MutableLiveData<>();
        }
        return contratoMutableLiveData;
    }


    public void cargarDatos(int idInmueble)
    {
        Inmueble inmueble1= new Inmueble(1, R.drawable.casa1,"Las Flores 123",3,"Casa","Residencial",12000,true);
        Inmueble inmueble2= new Inmueble(2,R.drawable.local1,"La Calendula  123",1,"Local","Comercial",10000,false);
        Inquilino i= new Inquilino(1,"33444555","Jose","Perez","123456");
        Inquilino i2= new Inquilino(2,"34666777","Martin","Pechz","123456");
        Contrato contrato1=new Contrato(1, "2020-01-01","2020-12-13","27678009",inmueble1.getId(),i.getIdInquilino(),inmueble1,i,inmueble1.getPrecio());
        Contrato contrato2=new Contrato(2, "2020-03-01","2021-03-01","34567987",inmueble2.getId(),i2.getIdInquilino(),inmueble2,i2,inmueble2.getPrecio());
        if(idInmueble == inmueble1.getId()){
            contratoMutableLiveData.setValue(contrato1);
        }
        if(idInmueble == inmueble2.getId()){
            contratoMutableLiveData.setValue(contrato2);
        }
    }
}
