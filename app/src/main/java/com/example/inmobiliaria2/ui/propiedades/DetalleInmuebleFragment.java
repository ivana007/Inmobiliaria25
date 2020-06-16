package com.example.inmobiliaria2.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
    private EditText direccion,ambiente,tipo,uso,precio,disponibilidad;
    //private CheckBox disponible;
    private Button eliminar,modificar,nuevo;
    private DetalleInmuebleViewModel vm;
    private Inmueble inmuebleElegir=null;
    private int codigo;
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
      /*vm.getdisponible().observe(this, new Observer<String>() {
          @Override
          public void onChanged(String s) {
                disponibilidad.setText(s);
          }
      });*/
      vm.getinmuebleMutableLiveData().observe(this, new Observer<Inmueble>() {
          @Override
          public void onChanged(Inmueble inmueble) {
              //foto.setImageResource(inmueble.getFoto());
              direccion.setText(inmueble.getDireccion());
              ambiente.setText(inmueble.getCantHambientes()+"");
              tipo.setText(inmueble.getTipoInmueble());
              uso.setText(inmueble.getUso());
              precio.setText(inmueble.getPrecio()+"");
              disponibilidad.setText(inmueble.getEstado());
              inmuebleElegir=inmueble;
              /*if(inmueble.getDisponible()=="Disponible")
              disponible.setChecked(true);*/
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
        eliminar=view.findViewById(R.id.btEliminar);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos();
                vm.borrarInmueble(inmuebleElegir.getIdInmueble());
                Navigation.findNavController(view).navigate(R.id.propiedades);
            }
        });
        modificar=view.findViewById(R.id.btModificar);
        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos();
                vm.modificarInmueble(inmuebleElegir);
            }
        });

        /*disponible=view.findViewById(R.id.cbDisponible);
        //boolean estado =disponible.isChecked();
        disponible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.cambiarDisponiblilidad(disponible.isChecked());
            }
        });*/
        nuevo=view.findViewById(R.id.btCrearInmueble);
        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.nuevoInmuebleFragment);
            }
        });
       int i=getArguments().getInt("IdInmueble");
       vm.cargarDatos(i);

        return view;
    }
    public  void datos(){
        inmuebleElegir.setDireccion(direccion.getText().toString());
        inmuebleElegir.setPrecio(Double.parseDouble(precio.getText().toString()));
        inmuebleElegir.setUso(uso.getText().toString());
        inmuebleElegir.setTipoInmueble(tipo.getText().toString());
        inmuebleElegir.setCantHambientes(Integer.parseInt(ambiente.getText().toString()));
        inmuebleElegir.setEstado(disponibilidad.getText().toString());
    }
}
