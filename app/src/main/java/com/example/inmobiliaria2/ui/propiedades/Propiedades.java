package com.example.inmobiliaria2.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmobiliaria2.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Propiedades#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Propiedades extends Fragment {
    private ListView lv;
    private PropiedadesViewModel pvm;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Propiedades() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Propiedades.
     */
    // TODO: Rename and change types and number of parameters
    public static Propiedades newInstance(String param1, String param2) {
        Propiedades fragment = new Propiedades();
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
            pvm= new PropiedadesViewModel();
           pvm= ViewModelProviders.of(this).get(PropiedadesViewModel.class);
            pvm.getListaDeInmuebles().observe(this, new Observer<List<Inmueble>>() {
                @Override
                public void onChanged(List<Inmueble> inmuebles) {
                    ArrayAdapter<Inmueble> adapter =new ListaAdapterInmueble(getContext(),R.layout.iteminmueble,inmuebles,getLayoutInflater());
                    //ArrayAdapter<Inmueble>adapter=new ArrayAdapter<Inmueble>(getContext(),R.layout.iteminmueble,inmuebles);
                    lv.setAdapter(adapter);
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_propiedades, container, false);
        lv=view.findViewById(R.id.propiedades);//hago referencia al listView
        pvm.cargarDatos();

        return view;
    }
}
