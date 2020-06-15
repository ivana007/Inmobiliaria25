package com.example.inmobiliaria2.ui.perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.inmobiliaria2.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Perfil extends Fragment {
private EditText etdni,etApellido,etnombre,etTelefono,etEmail;
private Button btEditar;
private PerfilViewModel vm;
private Propietario propietarioGuardar=null;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Perfil.
     */
    // TODO: Rename and change types and number of parameters
    public static Perfil newInstance(String param1, String param2) {
        Perfil fragment = new Perfil();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);
        vm.getPropietario().observe(this, new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etdni.setText(propietario.getDni());
                etApellido.setText(propietario.getApellido());
                etnombre.setText(propietario.getNombre());
                etTelefono.setText(propietario.getTelefono());
                etEmail.setText(propietario.getMail());
                propietarioGuardar=propietario;

            }
        });
        final View view=inflater.inflate(R.layout.fragment_perfil, container, false);

        etdni =view.findViewById(R.id.dni);
        etApellido=view.findViewById(R.id.apellido);
        etnombre=view.findViewById(R.id.nombre);
        etTelefono=view.findViewById(R.id.telefono);
        etEmail=view.findViewById(R.id.email);

        btEditar=view.findViewById(R.id.btnEditar);

            btEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etdni.setEnabled(true);
                    etApellido.setEnabled(true);
                    etnombre.setEnabled(true);
                    etTelefono.setEnabled(true);
                    etEmail.setEnabled(true);

                    btEditar.setText("guardar");
                    btEditar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new AlertDialog.Builder(getContext()).setTitle("").setMessage("Desea guardar los datos?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    aceptar();

                                }
                            }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //fijarDatos(null);
                                }
                            }).show();
                            Navigation.findNavController(view).navigate(R.id.nav_home);
                        }
                    });
                }
            });
        vm.cargarDatos();
        return view;
    }
    public void aceptar(){

        propietarioGuardar.setDni(etdni.getText().toString());
        propietarioGuardar.setApellido(etApellido.getText().toString());
        propietarioGuardar.setNombre(etnombre.getText().toString());
        propietarioGuardar.setTelefono(etTelefono.getText().toString());
        propietarioGuardar.setMail(etEmail.getText().toString());
        //propietarioGuardar.setPassword(pass.getText().toString());
        vm.actualizar(propietarioGuardar);
    }

}
