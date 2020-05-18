package com.example.inmobiliaria2.ui.propiedades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmobiliaria2.R;

import java.util.List;

public class ListaAdapterInmueble extends ArrayAdapter {
    private Context context;
    private List<Inmueble> inmuebleList;
    private LayoutInflater li;
    public ListaAdapterInmueble(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
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
        Inmueble inmueble=inmuebleList.get(position);
        ImageView foto=itemView.findViewById(R.id.foto);
        foto.setImageResource(inmueble.getFoto());
        TextView direccion=itemView.findViewById(R.id.direccion);
        direccion.setText(inmueble.getDireccion());
        TextView precio=itemView.findViewById(R.id.precio);
        precio.setText(inmueble.getPrecio()+"");
        return itemView;
    }

}
