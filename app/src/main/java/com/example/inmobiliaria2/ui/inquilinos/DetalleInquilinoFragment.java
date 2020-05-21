package com.example.inmobiliaria2.ui.inquilinos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliaria2.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetalleInquilinoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleInquilinoFragment extends Fragment {
    private DetalleInquilinoViewModel vm;
    private TextView tvDni,tvNombre,tvApellido,tvTelefono;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetalleInquilinoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleInquilinoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleInquilinoFragment newInstance(String param1, String param2) {
        DetalleInquilinoFragment fragment = new DetalleInquilinoFragment();
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
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(DetalleInquilinoViewModel.class);
        vm.getInquilino().observe(this, new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                tvDni.setText(inquilino.getDni());
                tvNombre.setText(inquilino.getNombre());
                tvApellido.setText(inquilino.getApellido());
                tvTelefono.setText(inquilino.getTelefono());

            }
        });
        View view=inflater.inflate(R.layout.fragment_detalle_inquilino, container, false);
        tvDni=view.findViewById(R.id.tvDniInquilino);
        tvNombre=view.findViewById(R.id.tvNombreInquilino);
        tvApellido=view.findViewById(R.id.tvApellidoInquilino);
        tvTelefono=view.findViewById(R.id.tvTelefonoInquilino);
        int i=getArguments().getInt("IdInmueble");
        vm.cargarDatos(i);
        return view;

    }
}
