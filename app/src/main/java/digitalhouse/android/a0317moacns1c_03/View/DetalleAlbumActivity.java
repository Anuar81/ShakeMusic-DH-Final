package digitalhouse.android.a0317moacns1c_03.View;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void informarClickenFragmentDetalleAlbumTema(Tema tema, Album album,View imageView) {
        Intent intent = new Intent(DetalleAlbumActivity.this,DetalleTemaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PlayCancionFragment.ID_TEMA,String.valueOf(tema.getId()));
        bundle.putString(PlayCancionFragment.RUTA_FOTO_ARTISTA_CANCION,album.getCover_big());
        bundle.putString(PlayCancionFragment.NOMBRE_CANCION,tema.getName());
        bundle.putString(PlayCancionFragment.RUTA_PREVIEW_CANCION, tema.getPreview());
        bundle.putString(PlayCancionFragment.ID_ALBUM, album.getId());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(DetalleAlbumActivity.this,
                Pair.create(imageView, ViewCompat.getTransitionName(imageView)));



        intent.putExtras(bundle);
        startActivity(intent, options.toBundle());
    }

}
