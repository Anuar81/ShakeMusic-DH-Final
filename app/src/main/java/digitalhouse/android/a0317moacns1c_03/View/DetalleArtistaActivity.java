package digitalhouse.android.a0317moacns1c_03.View;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;

public class DetalleArtistaActivity extends AppCompatActivity implements FragmentDetalleArtista.InformarClickFragmentDetalleArtistaTema{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_artista);
        cargarFragmentDetalleArtista();
    }

    public void cargarFragmentDetalleArtista() {
        //Creo un Fragment Manager que me permite hacer cosas con los fragments
        FragmentManager unFragmentManager = getSupportFragmentManager();

        //creo FragmentTransaction que me permite poner un fragment en un activity
        FragmentTransaction fragmentTransaction = unFragmentManager.beginTransaction();

        //Acá creo una instancia del nuevo fragment
        FragmentDetalleArtista fragmentDetalleArtista = new FragmentDetalleArtista();

//        Bundle unBundle = new Bundle();
        fragmentDetalleArtista.setArguments(getIntent().getExtras());

        fragmentTransaction.replace(R.id.contenedorDelFragmentDetalleArtistaActivity, fragmentDetalleArtista);

        fragmentTransaction.commit();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void informarClickenFragmentDetalleArtistaTema(Tema tema, Artista artista, View imageView) {
        Intent intent = new Intent(DetalleArtistaActivity.this,DetalleTemaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PlayCancionFragment.ID_TEMA,String.valueOf(tema.getId()));
        bundle.putString(PlayCancionFragment.RUTA_FOTO_ARTISTA_CANCION,artista.getPictureMedium());
        bundle.putString(PlayCancionFragment.NOMBRE_CANCION,tema.getName());
        bundle.putString(PlayCancionFragment.RUTA_PREVIEW_CANCION, tema.getPreview());
        bundle.putString(PlayCancionFragment.ID_ARTISTA, artista.getId());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(DetalleArtistaActivity.this,
                Pair.create(imageView, ViewCompat.getTransitionName(imageView)));

        intent.putExtras(bundle);
        startActivity(intent, options.toBundle());
    }
}
