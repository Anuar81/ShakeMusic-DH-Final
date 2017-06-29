package digitalhouse.android.a0317moacns1c_03.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.ControllerArtista;
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
    }
}
