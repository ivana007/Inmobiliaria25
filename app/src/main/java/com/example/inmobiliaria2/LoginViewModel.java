package com.example.inmobiliaria2;

import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<String> email;
    private MutableLiveData<String>pass;
    private MutableLiveData<String>cartel;

    public LiveData<String> getEmail(){
        if(email==null){
            email= new MutableLiveData<String>();
        }
        return email;
    }
    public LiveData<String>getPass(){
        if(pass==null){
            pass= new MutableLiveData<String>();
        }
        return pass;
    }

    public MutableLiveData<String> getCartel() {
        if(cartel==null){
            cartel= new MutableLiveData<String>();
        }
        return cartel;
    }

    public Boolean validardatos(Editable email, Editable pass){
        if(email.equals("") || pass.equals("")){
            cartel.setValue("debe completar todos los datos");
            return false;
        }else{
            if(email.equals("ivanalau31@gmail.com") && pass.equals("ivana")){
                return true;
            }else {
                cartel.setValue("Email o contraseña incorrectos");
                return false;
            }
        }

    }
}
