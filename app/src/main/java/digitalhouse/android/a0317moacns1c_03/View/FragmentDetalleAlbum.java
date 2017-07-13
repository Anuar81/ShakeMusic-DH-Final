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

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.AlbumController;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerChartsInternet;
import digitalhouse.android.a0317moacns1c_03.FragmentPrincipal;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleAlbum extends Fragment {

    public static final String ID_ALBUM_A_BUSCAR = "idAlbumABuscar";

    /*private AdapterAlbumTemas adapterAlbumTemas;
    private List<Tema> temaList;
    private String idAlbumABuscar;
    private FragmentDetalleAlbum.InformarClickFragmentDetalleAlbum escuchadorDelFragmentDetalleAlbum;
    private RecyclerView recyclerDetalleAlbum;*/

    public FragmentDetalleAlbum() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detalle_album, container, false);

        /*//RECYCLER DE ALBUMES FER

        RecyclerView recyclerDetalleAlbum = (RecyclerView) view.findViewById(R.id.recyclerViewDetalleAlbum);
        recyclerDetalleAlbum.setHasFixedSize(true);
        recyclerDetalleAlbum.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        adapterAlbumTemas = new AdapterAlbumTemas(getContext(),temaList);
        recyclerDetalleAlbum.setAdapter(adapterAlbumTemas);
        Bundle unBundle = getArguments();



        //SOLICITO LA LISTA DE TEMAS AL CONTROLLER DEL DETALLE ALBUM
        AlbumController albumController = new AlbumController(getContext());
        albumController.obtenerAlbum(new ResultListener<Album>() {

            @Override
            public void finish(Album album) {

                //RECIBO EL RESULTADO DE LA LISTA, SE LA PASO AL ADAPTER PARA QUE LA CARGUE Y LE AVISO QUE SE MODIFICARON SUS DATOS
                adapterAlbumTemas.setTemaList(album.getContainerAlbumTema().getTemaList());
                adapterAlbumTemas.notifyDataSetChanged();

            }
        },idAlbumABuscar);


        Toolbar toolbarDetalleAlbum = (Toolbar) view.findViewById(R.id.toolbarDetalleAlbum);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarDetalleAlbum);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsingToolBar);
        collapsingToolbarLayout.setTitle("ALBUMES");
        collapsingToolbarLayout.setContentScrimResource(R.color.colorPrimary);
        collapsingToolbarLayout.setStatusBarScrimResource(R.color.colorAccent);

        */
        return view;
    }

    /*

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        escuchadorDelFragmentDetalleAlbum = (FragmentDetalleAlbum.InformarClickFragmentDetalleAlbum)context;
    }




    public void informarClickAlbumTema(Tema tema) {
        escuchadorDelFragmentDetalleAlbum.informarClickenFragmentDetalleAlbum(temaList.get());
    }

    public interface InformarClickFragmentDetalleAlbum{
        public void informarClickenFragmentDetalleAlbum(Album album);
    }

    */

}
