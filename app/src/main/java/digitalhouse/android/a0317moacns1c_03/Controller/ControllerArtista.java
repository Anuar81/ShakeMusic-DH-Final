package digitalhouse.android.a0317moacns1c_03.Controller;

import android.content.Context;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.DAO.DAOArtistaInternet;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by alarrama on 29/06/17.
 */

public class ControllerArtista {
    private Context context;

    public ControllerArtista(Context context) {
        this.context = context;
    }

    public void buscarArtista(final ResultListener<Artista>listenerDeVista, String idArtista){
        if(HTTPConnectionManager.isNetworkingOnline(context)){
            DAOArtistaInternet daoArtistaInternet = new DAOArtistaInternet();
            daoArtistaInternet.buscarArtistaInternet(new ResultListener<Artista>() {
                @Override
                public void finish(Artista artista) {
                    listenerDeVista.finish(artista);
                }
            },idArtista);
        }
    }

    public void traerTemasDeArtista(final ResultListener<List<Tema>>listenerDeVista, String idArtista){
        if(HTTPConnectionManager.isNetworkingOnline(context)){
            DAOArtistaInternet daoArtistaInternet = new DAOArtistaInternet();
            daoArtistaInternet.buscarCancionesDeArtistaPaginado(new ResultListener<List<Tema>>() {
                @Override
                public void finish(List<Tema> temas) {
                    listenerDeVista.finish(temas);
                }
            },idArtista,50,0);

        }
    }
}
