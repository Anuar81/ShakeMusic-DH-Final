package digitalhouse.android.a0317moacns1c_03.View;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.ControllerAlbum;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerArtista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleArtista extends Fragment implements AdapterArtistaTemas.InformarClickFragmentDetalleArtistaTema{

    public static final String ID_ARTISTA_A_BUSCAR = "idArtistaABuscar";

    private AdapterArtistaTemas adapterArtistaTemas;
    private List<Tema> temaList;
    private String idArtistaABuscar;
    private FragmentDetalleArtista.InformarClickFragmentDetalleArtistaTema escuchadorDelFragmentDetalleArtistaTema;
    private RecyclerView recyclerDetalleArtista;
    private Artista artistaEncontrado;
    private ImageView imageViewArtista;

    public FragmentDetalleArtista() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        escuchadorDelFragmentDetalleArtistaTema = (InformarClickFragmentDetalleArtistaTema) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detalle_artista, container, false);

        temaList = new ArrayList<>();

        //RECYCLER DE ALBUMES FER

        final RecyclerView recyclerDetalleAlbum = (RecyclerView) view.findViewById(R.id.recyclerViewDetalleArtista);

        Bundle unBundle = getArguments();
        idArtistaABuscar = unBundle.getString(ID_ARTISTA_A_BUSCAR);
        imageViewArtista = (ImageView) view.findViewById(R.id.imageViewDetalleArtista);
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsingToolBar);


        //SOLICITO LA LISTA DE TEMAS AL CONTROLLER DEL DETALLE ALBUM
        final ControllerArtista controllerArtista = new ControllerArtista(getContext());
        controllerArtista.obtenerArtista(new ResultListener<Artista>() {

            @Override
            public void finish(Artista artista) {

                //RECIBO EL RESULTADO DE LA LISTA, SE LA PASO AL ADAPTER PARA QUE LA CARGUE Y LE AVISO QUE SE MODIFICARON SUS DATOS
                //adapterArtistaTemas.setTemaList(artista.getContainerArtistaTema().getTemaList());
                //adapterArtistaTemas.notifyDataSetChanged();
                Picasso.with(getContext()).load(artista.getPictureMedium()).into(imageViewArtista);
                artistaEncontrado = artista;
                        String id = artista.getId();
                controllerArtista.traerTemasDeArtista(new ResultListener<List<Tema>>() {
                    @Override
                    public void finish(List<Tema> temaList) {
                        recyclerDetalleAlbum.setHasFixedSize(true);
                        recyclerDetalleAlbum.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        adapterArtistaTemas = new AdapterArtistaTemas(getContext(),temaList,FragmentDetalleArtista.this);
                        recyclerDetalleAlbum.setAdapter(adapterArtistaTemas);

                    }
                },idArtistaABuscar);
                collapsingToolbarLayout.setTitle(artistaEncontrado.getName());



            }
        },idArtistaABuscar);

        Toolbar toolbarDetalleArtista = (Toolbar) view.findViewById(R.id.toolbarDetalleArtista);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarDetalleArtista);



        collapsingToolbarLayout.setContentScrimResource(R.color.colorPrimary);
        collapsingToolbarLayout.setStatusBarScrimResource(R.color.colorAccent);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.TextAppearance_MyApp_Title_Collapsed);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.TextAppearance_MyApp_Title_Expanded);

        return view;

    }

    @Override
    public void informarClickenFragmentDetalleArtistaTema(Tema tema) {
        escuchadorDelFragmentDetalleArtistaTema.informarClickenFragmentDetalleArtistaTema(tema, artistaEncontrado, imageViewArtista);
    }

    public interface InformarClickFragmentDetalleArtistaTema {
        public void informarClickenFragmentDetalleArtistaTema(Tema tema, Artista artista,View imagaView);
    }
}
