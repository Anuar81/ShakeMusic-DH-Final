package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import digitalhouse.android.a0317moacns1c_03.FragmentPrincipal;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;

public class DetalleAlbumActivity extends AppCompatActivity implements FragmentDetalleAlbum.InformarClickFragmentDetalleAlbumTema{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_album);
        cargarFragmentDetalleAlbum();
    }


    public void cargarFragmentDetalleAlbum() {
        //Creo un Fragment Manager que me permite hacer cosas con los fragments
        FragmentManager unFragmentManager = getSupportFragmentManager();

        //creo FragmentTransaction que me permite poner un fragment en un activity
        FragmentTransaction fragmentTransaction = unFragmentManager.beginTransaction();

        //Acá creo una instancia del nuevo fragment
        FragmentDetalleAlbum fragmentDetalleAlbum = new FragmentDetalleAlbum();

//        Bundle unBundle = new Bundle();
        fragmentDetalleAlbum.setArguments(getIntent().getExtras());

        fragmentTransaction.replace(R.id.contenedorDelFragmentDetalleAlbumActivity, fragmentDetalleAlbum);

        fragmentTransaction.commit();

    }



    //@Override
    public void informarClickenFragmentDetalleAlbumTema(Album album) {

        Intent intent = new Intent(this,DetalleAlbumActivity.class);
        Bundle bundle = new Bundle();
        String idAlbumABuscar = album.getId();
        bundle.putString(FragmentDetalleAlbum.ID_ALBUM_A_BUSCAR, idAlbumABuscar);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void informarClickenFragmentDetalleAlbumTema(Tema tema) {

    }
}
