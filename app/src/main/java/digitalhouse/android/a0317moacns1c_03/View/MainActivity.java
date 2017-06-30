package digitalhouse.android.a0317moacns1c_03.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.AlbumController;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerArtista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* codigo de prueba de Abel
        ControllerArtista artista = new ControllerArtista(this);
        artista.traerTemasDeArtista(new ResultListener<List<Tema>>() {
            @Override
            public void finish(List<Tema> temas) {
                for (Tema tema:temas
                     ) {
                    Toast.makeText(MainActivity.this, tema.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        },"1");*/





            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            final AdapterTemas adapterTemas = new AdapterTemas(this);
            recyclerView.setAdapter(adapterTemas);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


            //SOLICITO LA LISTA AL CONTROLLER (A LA VISTA NO LE IMPORTA DE DONDE TRAE ESA LISTA EL CONTROLLER
            AlbumController albumController = new AlbumController(this);
            albumController.obtenerAlbum(new ResultListener<Album>() {
                @Override
                public void finish(Album album) {

                    //RECIBO EL RESULTADO DE LA LISTA, SE LA PASO AL ADAPTER PARA QUE LA CARGUE Y LE AVISO QUE SE MODIFICARON SUS DATOS
                    adapterTemas.setTemaList(album.getContainerAlbumTema().getTemaList());
                    adapterTemas.notifyDataSetChanged();

                }
            });


        }


    }

