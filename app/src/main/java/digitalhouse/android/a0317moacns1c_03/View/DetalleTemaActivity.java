package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import digitalhouse.android.a0317moacns1c_03.R;

public class DetalleTemaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tema);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        PlayCancionFragment playCancionFragment = new PlayCancionFragment();
        playCancionFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorTemaDetalleFragment, playCancionFragment).commit();
    }
}
