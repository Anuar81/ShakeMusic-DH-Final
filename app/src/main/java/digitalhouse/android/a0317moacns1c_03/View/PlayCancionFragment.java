package digitalhouse.android.a0317moacns1c_03.View;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import digitalhouse.android.a0317moacns1c_03.Controller.ControllerAlbum;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerArtista;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerShakes;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerTema;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;
import digitalhouse.android.a0317moacns1c_03.utils.ShakeDetector;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayCancionFragment extends Fragment {

    public static final String ID_TEMA = "id_tema";
    public static final String NOMBRE_CANCION = "nombreCancion";
    public static final String RUTA_FOTO_ARTISTA_CANCION = "Chartok deja de morfar!!!";
    public static final String RUTA_PREVIEW_CANCION = "Entrega a la profe de Marketing - Venezolano feo!!!";
    public static final String ID_ALBUM = "Edu Gato";
    public static final String ID_ARTISTA = "Aguante Maduro - Edu boton";
    private Boolean play = false;
    private Tema temaElegido = new Tema();

    //cosas para usar con el shake
    private ControllerShakes controllerShakes;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private TextView nombreCanciontv;
    private String preview;


    public PlayCancionFragment() {
        // Required empty public constructor
    }

    private ImageButton btnPlay;
    private MediaPlayer player;
    private List<Tema> listaTemas;

    @Override
    public void onStart() {
        super.onStart();
        if (player.isPlaying()){
            player.stop();
            play = false;
            //btnPlay.setText("Play");
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        player.stop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_cancion, container, false);
        Bundle bundle = getArguments();
        String idTema = bundle.getString(ID_TEMA);
        String fotoArtistaCancion = bundle.getString(RUTA_FOTO_ARTISTA_CANCION);
        String nombreCancion = bundle.getString(NOMBRE_CANCION);
        preview = bundle.getString(RUTA_PREVIEW_CANCION);
        String idAlbum = bundle.getString(ID_ALBUM);
        String idArtista = bundle.getString(ID_ARTISTA);

        //llamo e intento traer la lista de temas del album
        if (idAlbum != null){
            ControllerAlbum controllerAlbum = new ControllerAlbum(getContext());
            controllerAlbum.obtenerAlbum(new ResultListener<Album>() {
                @Override
                public void finish(Album album) {
                    listaTemas = album.getContainerAlbumTema().getTemaList();
                }
            }, idAlbum);
        }

        //llamo e intento traer la lista de temas del artista
        if (idArtista != null){
            ControllerArtista controllerArtista = new ControllerArtista(getContext());
            controllerArtista.traerTemasDeArtista(new ResultListener<List<Tema>>() {
                @Override
                public void finish(List<Tema> temas) {
                    listaTemas = temas;
                }
            }, idArtista);
        }

        //busco todas las basofias del XML
        ImageView fotoArtista = (ImageView)view.findViewById(R.id.imageViewFotoCancionSeleccionada);
        nombreCanciontv = (TextView)view.findViewById(R.id.textViewTituloCancionSeleccionada);
        btnPlay = (ImageButton)view.findViewById(R.id.btnPlayCancionSeleccionada);
        ImageButton btnMisShakesAdd = (ImageButton)view.findViewById(R.id.btnMisShakesAdd);
        controllerShakes = new ControllerShakes(getActivity());

        //Traemos el tema entero con el id
        ControllerTema controllerTema = new ControllerTema(getActivity());
        controllerTema.buscarCancion(new ResultListener<Tema>() {
            @Override
            public void finish(Tema tema) {
                temaElegido = tema;
            }
        }, idTema);

        //agrego a base
        btnMisShakesAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controllerShakes.agregarTemaShake(temaElegido);
            }
        });


        //me fijo si no viene vacio
        if(fotoArtistaCancion != null){
            Picasso.with(getActivity()).load(fotoArtistaCancion).error(R.drawable.ic_launcher_round3).into(fotoArtista);
        }


        nombreCanciontv.setText(nombreCancion);


        //code para que suene modificado de PLM
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escucharTema(preview);
            }
        });



        //meto el shake
        // ShakeDetector initialization
        mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
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
                //Toast.makeText(MainActivity.this, "SE SHEIKEO" + count, Toast.LENGTH_SHORT).show();
                handleShakeEvent(count);
            }
        });


        return view;
    }

    private void escucharTema(String preview){
        if (player.isPlaying()){
            player.stop();
            player.reset();//agregado para que resetee el tema y se pueda escuchar con shakes
            //btnPlay.setText("Play");
            play=false;
        }else{
            try {
                player.setDataSource(preview);
            } catch (IllegalArgumentException e) {
                Toast.makeText(getContext(), "1", Toast.LENGTH_LONG).show();
            } catch (SecurityException e) {
                Toast.makeText(getContext(), "2", Toast.LENGTH_LONG).show();
            } catch (IllegalStateException e) {
                //Toast.makeText(getContext(), "3", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                player.prepare();
            } catch (IllegalStateException e) {
                Toast.makeText(getContext(), "4", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(getContext(), "5", Toast.LENGTH_LONG).show();
            }
            player.start();
           // btnPlay.setText("Stop");
            //agrego el tema escuchado al historial
            controllerShakes.agregarTemaAlHistorial(temaElegido);
            play = true;

        }
    }

    private void handleShakeEvent(int count){
        if (listaTemas.size() > 0){
            Random random = new Random();
            Integer numRandom = random.nextInt(listaTemas.size());
            Tema tema = listaTemas.get(numRandom);
            nombreCanciontv.setText(tema.getName());
            //no mirar, codigo feo, fuiraaaaaaaaa...
            if (play.equals(true)){
                escucharTema(tema.getPreview());
                play = false;
            }
            //u lala esto si se puede ver...
            escucharTema(tema.getPreview());
        }
    }



}
