package com.example.inmobiliaria2;

import android.app.Application;
import android.content.Intent;
import android.text.Editable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<String> email;
    private MutableLiveData<String>pass;
    private MutableLiveData<String>cartel;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

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

    public void validardatos(Editable email, Editable pass){
        if(email.equals("") || pass.equals("")) {
            cartel.setValue("debe completar todos los datos");

        }
        if(email.equals("i@g.com") && pass.equals("i"))
        {
                cartel.setValue("si");
                Intent intent= new Intent(getApplication().getApplicationContext(),MainActivity.class);
                getApplication().getApplicationContext().startActivity(intent);

        }else {
                cartel.setValue("Email o contraseña incorrectos");

        }


    }
}
