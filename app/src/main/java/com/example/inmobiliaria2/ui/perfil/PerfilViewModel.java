package com.example.inmobiliaria2.ui.perfil;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;

public class PerfilViewModel extends ViewModel {
private MutableLiveData<Propietario>propietario;


    public LiveData<Propietario> getPropietario(){
        if(propietario == null){
            propietario = new MutableLiveData<>();
        }
        return propietario;
    }

public  void cargarDatos(){
    Propietario p= new Propietario("27376007","Juana","Shwan","123456","juana@j.com","juana");
    propietario.setValue(p);
}


}
