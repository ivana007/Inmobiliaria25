package com.example.inmobiliaria2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail,etPass;
    private TextView tvCartelError;
    private Button btnIngresar;
    private LoginViewModel lvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarVista();
    }
    public  void iniciarVista(){
        etEmail=findViewById(R.id.etMail);
        etPass=findViewById(R.id.etPass);
        etEmail.setText("");
        etPass.setText("");

    }
    public void validar(View v){
        boolean res=lvm.validardatos(etEmail.getText(), etPass.getText());

    }
}
