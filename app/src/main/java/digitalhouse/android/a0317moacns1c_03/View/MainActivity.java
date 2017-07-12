package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.design.widget.NavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.AlbumController;
import digitalhouse.android.a0317moacns1c_03.FragmentHistorial;
import digitalhouse.android.a0317moacns1c_03.FragmentPrincipal;
import digitalhouse.android.a0317moacns1c_03.FragmentShakes;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;
import digitalhouse.android.a0317moacns1c_03.utils.ShakeDetector;

public class MainActivity extends AppCompatActivity implements FragmentPrincipal.InformarClickFragment {

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*        //RECYCLER DE ALBUMES FER (DETALLE ALBUM:"COMENTADO")
        RecyclerView recyclerViewDetalleAlbum = (RecyclerView) findViewById(R.id.recyclerViewDetalleAlbum);
        final AdapterAlbumTemas adapterAlbumTemas = new AdapterAlbumTemas(this);
        recyclerViewDetalleAlbum.setAdapter(adapterAlbumTemas);
        recyclerViewDetalleAlbum.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        //SOLICITO LA LISTA DE TEMAS AL CONTROLLER DEL DETALLE ALBUM
        AlbumController albumController = new AlbumController(this);
        albumController.obtenerAlbum(new ResultListener<Album>() {
            @Override
            public void finish(Album album) {

                //RECIBO EL RESULTADO DE LA LISTA, SE LA PASO AL ADAPTER PARA QUE LA CARGUE Y LE AVISO QUE SE MODIFICARON SUS DATOS
                adapterAlbumTemas.setTemaList(album.getContainerAlbumTema().getTemaList());
                adapterAlbumTemas.notifyDataSetChanged();

            }
        });*/




/*      // TOOLBAR ALBUMES FER
        // Detalle Album Toolbar
        Toolbar toolbarDetalleAlbum = (Toolbar) findViewById(R.id.toolbarDetalleAlbum);
        setSupportActionBar(toolbarDetalleAlbum);

        // Buscar Collapse ToolBar

        // Create the data model (VER)
        Album album = new Album(getResources().getString(R.string.ver), getResources().getString(R.string.ver));

        List<Album> lista = new ArrayList<>();
        for (Integer i = 0; i < 10; i++){
            lista.add(album);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbarDetalleAlbum);

        collapsingToolbarLayout.setTitle("ALBUMES");
        collapsingToolbarLayout.setContentScrimResource(R.color.colorPrimary);
        collapsingToolbarLayout.setStatusBarScrimResource(R.color.colorAccent);

        // Crear el Adapter
        MiAdapter adapter = new MiAdapter(lista);

        // Find the Recycler View
        RecyclerView recyclerViewDetalleAlbum = (RecyclerView) findViewById(R.id.recyclerViewDetalleAlbum);
        // Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // Set Adapter
        recyclerView.setAdapter(adapter);
        // Tell the recycler size will not change
        recyclerView.setHasFixedSize(true);*/


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


        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                /*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */
                handleShakeEvent(count);
            }
        });

        cargarFragmentPrincipal();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);


        NavigationViewListener navigationViewListener = new NavigationViewListener();
        navigationView.setNavigationItemSelectedListener(navigationViewListener);

    }


    private void handleShakeEvent(int count) {
        Toast.makeText(this, "SE SHEIKEO" + count, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    public void cargarFragmentPrincipal() {
        //Creo un Fragment Manager que me permite hacer cosas con los fragments
        FragmentManager unFragmentManager = getSupportFragmentManager();

        //creo FragmentTransaction que me permite poner un fragment en un activity
        FragmentTransaction fragmentTransaction = unFragmentManager.beginTransaction();

        //Acá creo una instancia del nuevo fragment
        FragmentPrincipal fragmentPrincipal = new FragmentPrincipal();

        Bundle unBundle = new Bundle();
        fragmentPrincipal.setArguments(unBundle);

        fragmentTransaction.replace(R.id.contenedorDelFragmentActivityMain, fragmentPrincipal);

        fragmentTransaction.commit();

    }

    @Override
    public void informarClickenFragment(Album album) {

    }


    private class NavigationViewListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {


            if (item.getItemId() == R.id.shakes) {

                FragmentManager unFragmentManager = getSupportFragmentManager();

                //creo FragmentTransaction que me permite poner un fragment en un activity
                FragmentTransaction fragmentTransaction = unFragmentManager.beginTransaction();

                //Acá creo una instancia del nuevo fragment
                FragmentShakes fragmentShakes = new FragmentShakes();

                Bundle unBundle = new Bundle();
                fragmentShakes.setArguments(unBundle);

                fragmentTransaction.replace(R.id.contenedorDelFragmentActivityMain, fragmentShakes);

                fragmentTransaction.commit();


            }

            if (item.getItemId() == R.id.historial) {
                FragmentManager unFragmentManager = getSupportFragmentManager();

                //creo FragmentTransaction que me permite poner un fragment en un activity
                FragmentTransaction fragmentTransaction = unFragmentManager.beginTransaction();

                //Acá creo una instancia del nuevo fragment
                FragmentHistorial fragmentHistorial = new FragmentHistorial();

                Bundle unBundle = new Bundle();
                fragmentHistorial.setArguments(unBundle);

                fragmentTransaction.replace(R.id.contenedorDelFragmentActivityMain, fragmentHistorial);

                fragmentTransaction.commit();

            }

            return true;
        }
    }
}
