package com.example.inmobiliaria2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

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
        lvm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);
        lvm.getCartel().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvCartelError.setText(s);

            }
        });

    }
    public  void iniciarVista(){
        etEmail=findViewById(R.id.etMail);
        etPass=findViewById(R.id.etPass);
        tvCartelError=findViewById(R.id.etcartel);
        etEmail.setText("");
        etPass.setText("");

    }
    public void validar(View view){
            lvm.validardatos(etEmail.getText().toString(), etPass.getText().toString());

    }
}
