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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.ControllerAlbum;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleAlbum extends Fragment implements AdapterAlbumTemas.InformarClickFragmentDetalleAlbumTema{

    public static final String ID_ALBUM_A_BUSCAR = "idAlbumABuscar";

    private AdapterAlbumTemas adapterAlbumTemas;
    private List<Tema> temaList;
    private String idAlbumABuscar;
    private FragmentDetalleAlbum.InformarClickFragmentDetalleAlbumTema escuchadorDelFragmentDetalleAlbumTema;
    private RecyclerView recyclerDetalleAlbum;
    private Album albumEncontrado;
    private ImageView imageViewAlbum;

    public FragmentDetalleAlbum() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        escuchadorDelFragmentDetalleAlbumTema = (FragmentDetalleAlbum.InformarClickFragmentDetalleAlbumTema)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detalle_album, container, false);

        temaList = new ArrayList<>();

        //RECYCLER DE ALBUMES FER

        RecyclerView recyclerDetalleAlbum = (RecyclerView) view.findViewById(R.id.recyclerViewDetalleAlbum);
        recyclerDetalleAlbum.setHasFixedSize(true);
        recyclerDetalleAlbum.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapterAlbumTemas = new AdapterAlbumTemas(getContext(),temaList,this);
        recyclerDetalleAlbum.setAdapter(adapterAlbumTemas);
        Bundle unBundle = getArguments();
        idAlbumABuscar = unBundle.getString(ID_ALBUM_A_BUSCAR);
        imageViewAlbum = (ImageView) view.findViewById(R.id.imageViewDetalleAlbum);


        Toolbar toolbarDetalleAlbum = (Toolbar) view.findViewById(R.id.toolbarDetalleAlbum);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarDetalleAlbum);

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsingToolBar);

        collapsingToolbarLayout.setContentScrimResource(R.color.colorPrimary);
        collapsingToolbarLayout.setStatusBarScrimResource(R.color.colorAccent);
        collapsingToolbarLayout.setTitle("");



        //SOLICITO LA LISTA DE TEMAS AL CONTROLLER DEL DETALLE ALBUM
        ControllerAlbum controllerAlbum = new ControllerAlbum(getContext());
        controllerAlbum.obtenerAlbum(new ResultListener<Album>() {

            @Override
            public void finish(Album album) {

                //RECIBO EL RESULTADO DE LA LISTA, SE LA PASO AL ADAPTER PARA QUE LA CARGUE Y LE AVISO QUE SE MODIFICARON SUS DATOS
                adapterAlbumTemas.setTemaList(album.getContainerAlbumTema().getTemaList());
                adapterAlbumTemas.notifyDataSetChanged();
                albumEncontrado = album;
                Picasso.with(getContext()).load(album.getCover_big()).into(imageViewAlbum);
                collapsingToolbarLayout.setTitle(albumEncontrado.getTitle());




            }
        },idAlbumABuscar);




        return view;
    }



    @Override
    public void informarClickenFragmentDetalleAlbumTema(Tema tema) {
        escuchadorDelFragmentDetalleAlbumTema.informarClickenFragmentDetalleAlbumTema(tema, albumEncontrado);
    }

    public interface InformarClickFragmentDetalleAlbumTema{
        public void informarClickenFragmentDetalleAlbumTema(Tema tema, Album album);
    }



}
