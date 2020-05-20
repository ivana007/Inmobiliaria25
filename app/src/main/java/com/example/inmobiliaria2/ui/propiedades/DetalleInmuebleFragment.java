package com.example.inmobiliaria2.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inmobiliaria2.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleInmuebleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleInmuebleFragment extends Fragment {
    private  ImageView foto;
    private TextView direccion,ambiente,tipo,uso,precio,disponibilidad;
    private CheckBox disponible;
    private DetalleInmuebleViewModel vm;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetalleInmuebleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleInmuebleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleInmuebleFragment newInstance(String param1, String param2) {
        DetalleInmuebleFragment fragment = new DetalleInmuebleFragment();
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
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleInmuebleViewModel.class);
      vm.getdisponible().observe(this, new Observer<String>() {
          @Override
          public void onChanged(String s) {
                disponibilidad.setText(s);
          }
      });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_detalle_inmueble, container, false);

        foto=view.findViewById(R.id.ivFoto);
        direccion=view.findViewById(R.id.tvDireccion);
        ambiente=view.findViewById(R.id.tvAmbientes);
        tipo=view.findViewById(R.id.tvTipo);
        uso=view.findViewById(R.id.tvUso);
        precio=view.findViewById(R.id.tvprecio);
        disponibilidad=view.findViewById(R.id.idDisponibilidad);
        disponible=view.findViewById(R.id.cbDisponible);
        //boolean estado =disponible.isChecked();
        disponible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.cambiarDisponiblilidad(disponible.isChecked());
            }
        });

       int i=getArguments().getInt("IdInmueble");
        Inmueble inmueble1= new Inmueble(1,R.drawable.casa1,"Las Flores 123",3,"Casa","Residencial",12000,true);
        Inmueble inmueble2= new Inmueble(2,R.drawable.local1,"La Calendula  123",1,"Local","Comercial",10000,false);
        if(i == inmueble1.getId()){
            foto.setImageResource(inmueble1.getFoto());
            direccion.setText(inmueble1.getDireccion());
            ambiente.setText(inmueble1.getAmbientes()+"");
            tipo.setText(inmueble1.getTipo());
            uso.setText(inmueble1.getUso());
            precio.setText(inmueble1.getPrecio()+"");
            disponible.setChecked(inmueble1.isDisponible());
            disponibilidad.setText("Disponible");
        }
        if(i == inmueble2.getId()){
            foto.setImageResource(inmueble2.getFoto());
            direccion.setText(inmueble2.getDireccion());
            ambiente.setText(inmueble2.getAmbientes()+"");
            tipo.setText(inmueble2.getTipo());
            uso.setText(inmueble2.getUso());
            precio.setText(inmueble2.getPrecio()+"");
            disponible.setChecked(inmueble2.isDisponible());
            disponibilidad.setText("No Disponible");
        }
        return view;
    }
}
