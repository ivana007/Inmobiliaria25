package request;

import android.util.Log;

import com.example.inmobiliaria2.Usuario;
import com.example.inmobiliaria2.ui.perfil.Propietario;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiClient {
    private static final String PATH="http://192.168.101.233:45455/api/";
    private static  MyApiInterface myApiInteface;


    public static MyApiInterface getMyApiClient(){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
    }
    public interface MyApiInterface {

    @POST("propietarios/login")
        Call<String> login(@Body Usuario usuario);
    @GET("propietarios")
        Call<Propietario>buscarpropietario(@Header("Authorization")String token);


         @PUT("propietarios/{id}")
        Call<Propietario>actualizar(@Header("Authorization")String token,@Body Propietario propietario);

        @GET("inmuebles")
        Call<List<Inmueble>>misInmuebles(@Header("Authorization")String token);

        @DELETE("inmuebles/{id}")
        Call<Inmueble>EliminarInmueble(@Header("Authorization")String token,@Body Inmueble inmueble);
        @PUT("inmuebles/{id}")
        Call<Inmueble>CambiarInmueble(@Header("Authorization")String token,@Body Inmueble inmueble);
        @POST("inmuebles")
        Call<Inmueble>CrearInmueble(@Header("Authorization")String token,@Body Inmueble inmueble);

        //listarClientes.php
        //@GET("listarClientes.php")
        //Call<List<Cliente>> getClientes();

        //@GET("insertarClientes.php")
        //Call<Cliente> createCliente(@Query("dni") int dni, @Query("apellido") String apellido, @Query("nombre") String nombre);
    }

}




