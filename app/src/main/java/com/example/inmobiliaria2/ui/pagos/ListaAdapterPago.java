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

public class ListaAdapterPago extends ArrayAdapter {
    private Context context;
    private List<Inmueble> inmuebleList;
    private LayoutInflater li;
    public ListaAdapterPago(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context=context;
        this.inmuebleList=objects;
        this.li=li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=li.inflate(R.layout.iteminmueble,parent,false);

        }
        final Inmueble inmueble=inmuebleList.get(position);
        ImageView foto=itemView.findViewById(R.id.foto);
        foto.setImageResource(inmueble.getFoto());
        TextView direccion=itemView.findViewById(R.id.direccion);
        direccion.setText(inmueble.getDireccion());
        TextView precio=itemView.findViewById(R.id.precio);
        precio.setText(inmueble.getPrecio()+"");
        TextView idInmueble= itemView.findViewById(R.id.tvId);
        idInmueble.setText(inmueble.getId()+"");
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putInt("IdInmueble",inmueble.getId());

                Navigation.findNavController(v).navigate(R.id.detallePagoFragment,bundle);
            }
        });

        return itemView;
    }

}
