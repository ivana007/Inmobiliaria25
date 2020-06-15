package com.example.inmobiliaria2.ui.pagos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.ui.contratos.Contrato;
import com.example.inmobiliaria2.ui.inquilinos.Inquilino;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class DetallePagoViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Pago>> listaPagoMutableLiveData;

    public LiveData<ArrayList<Pago>> getlistaPagoMutableLiveData(){
        if(listaPagoMutableLiveData == null){
            listaPagoMutableLiveData = new MutableLiveData<>();
        }
        return listaPagoMutableLiveData;
    }
public  void cargarDatos(int inmu){
      /*ArrayList<Pago>listapago=new ArrayList<>();
    Inmueble inmueble1= new Inmueble(1, R.drawable.casa1,"Las Flores 123",3,"Casa","Residencial",12000,true);
    Inmueble inmueble2= new Inmueble(2,R.drawable.local1,"La Calendula  123",1,"Local","Comercial",10000,false);
    Inquilino i= new Inquilino(1,"33444555","Jose","Perez","123456");
    Inquilino i2= new Inquilino(2,"34666777","Martin","Pechz","123456");
    Contrato contrato1=new Contrato(1, "2020-01-01","2020-12-13","27678009",inmueble1.getId(),i.getIdInquilino(),inmueble1,i,inmueble1.getPrecio());
    Contrato contrato2=new Contrato(2, "2020-03-01","2021-03-01","34567987",inmueble2.getId(),i2.getIdInquilino(),inmueble2,i2,inmueble2.getPrecio());
    Pago pago1=new Pago(1,"01-01-2020",1,1,contrato1,12000);
    Pago pago2=new Pago(2,"01-02-2020",2,1,contrato1,12000);
    Pago pago3=new Pago(3,"01-03-2020",3,1,contrato1,12000);
    Pago pago4=new Pago(4,"01-03-2020",1,2,contrato2,12000);
    Pago pago5=new Pago(5,"05-04-2020",2,2,contrato2,12000);
    Pago pago6=new Pago(6,"07-05-2020",3,2,contrato2,12000);
    if(inmu==inmueble1.getId()){
        listapago.add(pago1);
        listapago.add(pago2);
        listapago.add(pago3);
        listaPagoMutableLiveData.setValue(listapago);
    }
    if(inmu==inmueble2.getId()){
        listapago.add(pago4);
        listapago.add(pago5);
        listapago.add(pago6);
        listaPagoMutableLiveData.setValue(listapago);
    }*/

}
}
