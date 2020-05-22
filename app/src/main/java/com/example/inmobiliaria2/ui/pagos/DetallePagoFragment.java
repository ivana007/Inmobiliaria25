package com.example.inmobiliaria2.ui.pagos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmobiliaria2.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetallePagoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetallePagoFragment extends Fragment {
    private TextView tvNumeroPago,tvFechaPago,tvNumeroContrato,tvPrecioPago;
    private ListView lv;
    private DetallePagoViewModel vm;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetallePagoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetallePagoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetallePagoFragment newInstance(String param1, String param2) {
        DetallePagoFragment fragment = new DetallePagoFragment();
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
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetallePagoViewModel.class);
        vm.getlistaPagoMutableLiveData().observe(this, new Observer<ArrayList<Pago>>() {
            @Override
            public void onChanged(ArrayList<Pago> pagos) {
                ListaAdapterDetallePago adapter=new ListaAdapterDetallePago(getContext(),R.layout.itempago,pagos,getLayoutInflater());
                lv.setAdapter(adapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_detalle_pago, container, false);
        lv=view.findViewById(R.id.lvlistaPagos);
        int i=getArguments().getInt("IdInmueble");
        vm.cargarDatos(i);
        return view;
    }
}
