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

    public void obtenerArtista(final ResultListener<Artista> resultListenerFromView,String idArtistaABuscar){

        if(HTTPConnectionManager.isNetworkingOnline(context)){

            DAOArtistaInternet daoArtistaInternet = new DAOArtistaInternet();
            daoArtistaInternet.buscarArtistaInternet(new ResultListener<Artista>() {
                @Override
                public void finish(Artista artista) {
                    resultListenerFromView.finish(artista);
                }
            },idArtistaABuscar);
        }
        else {
            //SI NO HAY CONEXION UTILIZO LOS DATOS ALMACENADOS EN LA BASE DE DATOS.

        }
    }



    public void obtenerPlayListArtista(final ResultListener<List<Tema>> resultListenerFromView,String idArtistaABuscar){

        if(HTTPConnectionManager.isNetworkingOnline(context)){

            DAOArtistaInternet daoArtistaInternet = new DAOArtistaInternet();
            daoArtistaInternet.buscarPlayListArtistaInternet(new ResultListener<List<Tema>>() {
                @Override
                public void finish(List<Tema> temaList) {
                    resultListenerFromView.finish(temaList);
                }
            },idArtistaABuscar);
        }
        else {
            //SI NO HAY CONEXION UTILIZO LOS DATOS ALMACENADOS EN LA BASE DE DATOS.

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
