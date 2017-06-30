package digitalhouse.android.a0317moacns1c_03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPrincipal extends Fragment {

    private List<Artista>listaDeArtistas;
    private List<Album>listaDeAlbums;
    private List<Tema>listaDeTemas;

    public FragmentPrincipal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_principal, container, false);
    }

}
