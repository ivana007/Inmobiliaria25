package com.example.inmobiliaria2.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.inmobiliaria2.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NuevoInmuebleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NuevoInmuebleFragment extends Fragment {
    private Button guardar;
    private EditText etDireccion,etCantAmbientes,etTipoInmueble,etUso,etPrecio;
    private NuevoInmuebleViewModel vm;
    private Inmueble inmueble;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NuevoInmuebleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NuevoInmuebleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NuevoInmuebleFragment newInstance(String param1, String param2) {
        NuevoInmuebleFragment fragment = new NuevoInmuebleFragment();
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
           vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(NuevoInmuebleViewModel.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_nuevo_inmueble, container, false);
        etDireccion=view.findViewById(R.id.etDireccionInmueble);
        etCantAmbientes=view.findViewById(R.id.etCantAmb);
        etTipoInmueble=view.findViewById(R.id.etTipoInmueble);
        etUso=view.findViewById(R.id.etUsoInmueble);
        etPrecio=view.findViewById(R.id.etPrecio);
        guardar=view.findViewById(R.id.btGuardarInmueble);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inmueble=new Inmueble();
                inmueble.setDireccion(etDireccion.getText().toString());
                inmueble.setCantHambientes(Integer.parseInt(etCantAmbientes.getText().toString()));
                inmueble.setUso(etUso.getText().toString());
                inmueble.setTipoInmueble(etTipoInmueble.getText().toString());
                inmueble.setPrecio(Double.parseDouble(etPrecio.getText().toString()));
                inmueble.setEstado("Disponible");
                inmueble.setIdInmueble(0);//se genera cuando lo guardo
                inmueble.setIdPropietario(0);//lo recupero con el token
                vm.guardarInmueble(inmueble);
            }
        });
        return view;
    }

}
