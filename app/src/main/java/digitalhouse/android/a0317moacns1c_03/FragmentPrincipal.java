package digitalhouse.android.a0317moacns1c_03;


import android.net.sip.SipAudioCall;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.ControllerArtista;
import digitalhouse.android.a0317moacns1c_03.Controller.ControllerChartsInternet;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.View.AdapterChartsAlbum;
import digitalhouse.android.a0317moacns1c_03.View.AdapterChartsArtista;
import digitalhouse.android.a0317moacns1c_03.View.AdapterChartsTema;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPrincipal extends Fragment {

    private List<Artista>listaDeArtistas;
    private List<Album>listaDeAlbums;
    private List<Tema>listaDeTemas;
    private RecyclerView recyclerViewAlbums;
    private RecyclerView recyclerViewArtistas;
    private RecyclerView recyclerViewTemas;
    private AdapterChartsAlbum adapterChartsAlbum;
    private AdapterChartsArtista adapterChartsArtista;
    private AdapterChartsTema adapterChartsTema;
    public FragmentPrincipal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_principal, container, false);
        recyclerViewAlbums = (RecyclerView)view.findViewById(R.id.recyclerChartAlbums);
        recyclerViewArtistas = (RecyclerView)view.findViewById(R.id.recyclerChartArtists);
        recyclerViewTemas = (RecyclerView)view.findViewById(R.id.recyclerChartTracks);
        Bundle unBundle = getArguments();
        cargarChartsArtists();
        cargarChartsTemas();
        cargarChartsAlbums();

        return view;
    }

    private void cargarChartsAlbums(){
        ControllerChartsInternet controllerChartsInternet = new ControllerChartsInternet(getContext());
         controllerChartsInternet.traerChartsDeAlbumes(new ResultListener<List<Album>>() {
            @Override
            public void finish(List<Album> albumList) {

            }
        });
        recyclerViewAlbums.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        adapterChartsAlbum = new AdapterChartsAlbum(getContext(),listaDeAlbums);
        recyclerViewAlbums.setAdapter(adapterChartsAlbum);

    }

    private void cargarChartsArtists(){
        ControllerChartsInternet controllerChartsInternet = new ControllerChartsInternet(getContext());
        controllerChartsInternet.traerChartsDeArtistas(new ResultListener<List<Artista>>() {
            @Override
            public void finish(List<Artista> artistaList) {

            }
        });
        recyclerViewArtistas.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
         adapterChartsArtista= new AdapterChartsArtista(getContext(),listaDeArtistas);
        recyclerViewArtistas.setAdapter(adapterChartsArtista);

    }

    private void cargarChartsTemas(){
        ControllerChartsInternet controllerChartsInternet = new ControllerChartsInternet(getContext());
        controllerChartsInternet.traerChartsDeTemas(new ResultListener<List<Tema>>() {
            @Override
            public void finish(List<Tema> temaList) {

            }
        });
        recyclerViewTemas.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        adapterChartsTema= new AdapterChartsTema(getContext(),listaDeTemas);
        recyclerViewTemas.setAdapter(adapterChartsTema);
    }

}
