package com.example.inmobiliaria2.ui.contratos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.ui.inquilinos.DetalleInquilinoViewModel;
import com.example.inmobiliaria2.ui.inquilinos.Inquilino;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleContratoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleContratoFragment extends Fragment {
    private TextView tvNumeroContrato,tvFechaAlta,tvFechaBaja,tvPrecio,tvNombreInquilino,tvDireccionInmueble,tvdniGarante;
    private DetalleContratoViewModel vm;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetalleContratoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleContratoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleContratoFragment newInstance(String param1, String param2) {
        DetalleContratoFragment fragment = new DetalleContratoFragment();
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
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleContratoViewModel.class);
        vm.getcontratoMutableLiveData().observe(this, new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
                tvNumeroContrato.setText(contrato.getNumeroContrato()+"");
                tvFechaAlta.setText(contrato.getFechaAlta());
                tvFechaBaja.setText(contrato.getFechaBaja());
                tvNombreInquilino.setText(contrato.getInquilino().getNombre()+" "+contrato.getInquilino().getApellido());
                tvPrecio.setText(contrato.getPrecio()+"");
                tvDireccionInmueble.setText(contrato.getInmueble().getDireccion());
                tvdniGarante.setText(contrato.getDniGarante());

            }
        });
        View view=inflater.inflate(R.layout.fragment_detalle_contrato, container, false);
        tvNumeroContrato=view.findViewById(R.id.idNumeroContrato);
        tvFechaAlta=view.findViewById(R.id.fechaAltaContrato);
        tvFechaBaja=view.findViewById(R.id.fechaBajaContrato);
        tvNombreInquilino=view.findViewById(R.id.nombreInquilinoContrato);

        tvPrecio=view.findViewById(R.id.precioContrato);
        tvDireccionInmueble=view.findViewById(R.id.direccionInmuebleContrato);
        tvdniGarante=view.findViewById(R.id.dniGarante);
        int i=getArguments().getInt("IdInmueble");
        vm.cargarDatos(i);
        return view;
    }
}
