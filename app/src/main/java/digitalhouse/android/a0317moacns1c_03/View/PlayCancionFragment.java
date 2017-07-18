package digitalhouse.android.a0317moacns1c_03.View;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.ControllerAlbum;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerShakes;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerTema;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

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

    private Tema temaElegido = new Tema();
    private ControllerShakes controllerShakes;


    public PlayCancionFragment() {
        // Required empty public constructor
    }

    private Button btnPlay;
    private MediaPlayer player;
    private List<Tema> listaTemas;

    @Override
    public void onStart() {
        super.onStart();
        if (player.isPlaying()){
            player.stop();
            btnPlay.setText("Play");
        }

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
        final String preview = bundle.getString(RUTA_PREVIEW_CANCION);
        String idAlbum = bundle.getString(ID_ALBUM);
        String idArtista = bundle.getString(ID_ARTISTA);

        //llamo e intento traer la lista de temas del album
        ControllerAlbum controllerAlbum = new ControllerAlbum(getContext());
        controllerAlbum.obtenerAlbum(new ResultListener<Album>() {
            @Override
            public void finish(Album album) {
                listaTemas = album.getContainerAlbumTema().getTemaList();
            }
        }, idAlbum);




        ImageView fotoArtista = (ImageView)view.findViewById(R.id.imageViewFotoCancionSeleccionada);
        TextView nombreCanciontv = (TextView)view.findViewById(R.id.textViewTituloCancionSeleccionada);
        btnPlay = (Button)view.findViewById(R.id.btnPlayCancionSeleccionada);
        final Button btnMisShakesAdd = (Button)view.findViewById(R.id.btnMisShakesAdd);
        controllerShakes = new ControllerShakes(getActivity());

        //Traemos el tema entero con el id

        ControllerTema controllerTema = new ControllerTema(getActivity());
        controllerTema.buscarCancion(new ResultListener<Tema>() {
            @Override
            public void finish(Tema tema) {
                temaElegido = tema;
            }
        }, idTema);


        //me fijo si no viene vacio
        if(fotoArtistaCancion != null){
            Picasso.with(getActivity()).load(fotoArtistaCancion).into(fotoArtista);}


        nombreCanciontv.setText(nombreCancion);


        //code para que suene modificado de PLM
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player.isPlaying()){
                    player.stop();
                    btnPlay.setText("Play");
                }else{
                    try {
                        player.setDataSource(preview);
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                    } catch (SecurityException e) {
                        Toast.makeText(getContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                    } catch (IllegalStateException e) {
                        Toast.makeText(getContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        player.prepare();
                    } catch (IllegalStateException e) {
                        Toast.makeText(getContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        Toast.makeText(getContext(), "You might not set the URI correctly!", Toast.LENGTH_LONG).show();
                    }
                    player.start();
                    btnPlay.setText("Stop");
                    //agrego el tema escuchado al historial
                    controllerShakes.agregarTemaAlHistorial(temaElegido);

                }



            }
        });

        btnMisShakesAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controllerShakes.agregarTemaShake(temaElegido);
            }
        });

        return view;
    }



}
