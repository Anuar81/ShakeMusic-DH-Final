package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import digitalhouse.android.a0317moacns1c_03.FragmentHistorial;
import digitalhouse.android.a0317moacns1c_03.FragmentPrincipal;
import digitalhouse.android.a0317moacns1c_03.FragmentShakes;
import digitalhouse.android.a0317moacns1c_03.GeoShakeActivity;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ShakeDetector;

public class MainActivity extends AppCompatActivity implements FragmentPrincipal.InformarClickFragment {

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private String idAlbumABuscar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //metodo de Edu Gato
        // Get the shared preferences
        SharedPreferences preferences =  getSharedPreferences("my_preferences", MODE_PRIVATE);
        if(!preferences.getBoolean("onboarding_complete",false)) {
            Intent intent = new Intent(MainActivity.this,OnBoardingActivity.class);
            startActivity(intent);
            finish();
            return;
        }

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
                Toast.makeText(MainActivity.this, "SE SHEIKEO" + count, Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this,DetalleAlbumActivity.class);
        Bundle bundle = new Bundle();
        String idAlbumABuscar = album.getId();
        bundle.putString(FragmentDetalleAlbum.ID_ALBUM_A_BUSCAR, idAlbumABuscar);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void informarClickenFragment(Tema tema) {
        Intent intent = new Intent(MainActivity.this, DetalleTemaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PlayCancionFragment.ID_TEMA, String.valueOf(tema.getId()));
        bundle.putString(PlayCancionFragment.RUTA_FOTO_ARTISTA_CANCION, tema.getName());
        bundle.putString(PlayCancionFragment.NOMBRE_CANCION, tema.getName());
        bundle.putString(PlayCancionFragment.RUTA_PREVIEW_CANCION, tema.getPreview());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void informarClickenFragment(Artista artista) {
        Intent intent = new Intent(MainActivity.this,DetalleArtistaActivity.class);
        Bundle bundle = new Bundle();
        String idArtistaABuscar = artista.getId();
        bundle.putString(FragmentDetalleArtista.ID_ARTISTA_A_BUSCAR, idArtistaABuscar);
        intent.putExtras(bundle);
        startActivity(intent);
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

                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();


            }

            if (item.getItemId() == R.id.geoShakes) {

                Intent intent = new Intent(MainActivity.this, GeoShakeActivity.class);
                startActivity(intent);


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

                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

            }

            return true;
        }
    }
}
