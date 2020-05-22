package com.example.inmobiliaria2.ui.pagos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.inmobiliaria2.R;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;

import java.util.List;

public class ListaAdapterDetallePago extends ArrayAdapter {
    private Context context;
    private List<Pago> pagoList;
    private LayoutInflater li;
    public ListaAdapterDetallePago(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context=context;
        this.pagoList=objects;
        this.li=li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=li.inflate(R.layout.itempago,parent,false);

        }
        final Pago pago=pagoList.get(position);
        TextView numeroPago=itemView.findViewById(R.id.tvNumeroPago);
        numeroPago.setText(pago.getNumeroPago()+"");
        TextView fechapago= itemView.findViewById(R.id.tvFechaPago);
        fechapago.setText(pago.getFechaPago());
        TextView numeroContrato=itemView.findViewById(R.id.tvNumeroContrato);
           numeroContrato.setText(pago.getIdContrato()+"");
        TextView importe=itemView.findViewById(R.id.tvImportePago);
            importe.setText(pago.getImporte()+"");

        return itemView;
    }

}
