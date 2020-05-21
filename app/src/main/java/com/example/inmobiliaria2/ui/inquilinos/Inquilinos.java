package com.example.inmobiliaria2.ui.inquilinos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;
import com.example.inmobiliaria2.ui.propiedades.ListaAdapterInmueble;
import com.example.inmobiliaria2.ui.propiedades.PropiedadesViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Inquilinos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Inquilinos extends Fragment {
    private ListView lv;
    private InquilinoViewModel vm;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Inquilinos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Inquilinos.
     */
    // TODO: Rename and change types and number of parameters
    public static Inquilinos newInstance(String param1, String param2) {
        Inquilinos fragment = new Inquilinos();
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
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);


        vm.getListaDeInmuebles().observe(this, new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
               ListaAdapterInquilino adapter =new ListaAdapterInquilino(getContext(),R.layout.iteminmueble,inmuebles,getLayoutInflater());
                lv.setAdapter(adapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_inquilinos, container, false);
        lv=view.findViewById(R.id.propiedadesInquilino);//hago referencia al listView
        vm.cargarDatos();

        return view;
    }
}
