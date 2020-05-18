package com.example.inmobiliaria2.ui.perfil;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria2.R;

public class PerfilViewModel extends ViewModel {
private MutableLiveData<String>dni;
private MutableLiveData<String>nombre;
private MutableLiveData<String>apellido;
private MutableLiveData<String>telefono;
    private MutableLiveData<String>email;
    private MutableLiveData<String>pass;

    public LiveData<String> getDni(){
        if(dni == null){
            dni = new MutableLiveData<>();
        }
        return dni;
    }
    public LiveData<String> getNombre(){
        if(nombre == null){
            nombre = new MutableLiveData<>();
        }
        return nombre;
    }
    public LiveData<String> getApellido(){
        if(apellido== null){
            apellido = new MutableLiveData<>();
        }
        return apellido;
    }
    public LiveData<String> getTelefono(){
        if(telefono == null){
            telefono = new MutableLiveData<>();
        }
        return telefono;
    }
    public LiveData<String> getemail(){
        if(email == null){
            email = new MutableLiveData<>();
        }
        return email;
    }
    public LiveData<String> getPass(){
        if(pass == null){
            pass = new MutableLiveData<>();
        }
        return pass;
    }
public  void cargarDatos(View view){
    Propietario propietario= new Propietario("27376007","Juana","Shwan","123456","juana@j.com","juana");
    dni.setValue(propietario.getDni());

    apellido.setValue(propietario.getApellido());
    nombre.setValue(propietario.getNombre());
    telefono.setValue(propietario.getTelefono());
    email.setValue(propietario.getEmail());
    pass.setValue(propietario.getPass());
}
}
