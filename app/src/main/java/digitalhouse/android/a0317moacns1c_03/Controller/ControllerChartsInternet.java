package digitalhouse.android.a0317moacns1c_03.Controller;

import android.content.Context;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.DAO.DAOArtistaInternet;
import digitalhouse.android.a0317moacns1c_03.Model.DAO.DAOChartsInternet;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.ContainerChartArtista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by federico on 6/30/2017.
 */

public class ControllerChartsInternet {
    private Context context;

    public ControllerChartsInternet(Context context) {
        this.context = context;
    }



    public void traerChartsDeArtistas(final ResultListener<List<Artista>>listenerDeVista){
        if(HTTPConnectionManager.isNetworkingOnline(context)){
            DAOChartsInternet daoChartsInternet = new DAOChartsInternet();
            daoChartsInternet.getChartArtistaFromInternet(new ResultListener<List<Artista>>() {
                @Override
                public void finish(List<Artista> artistaList) {
                    listenerDeVista.finish(artistaList);
                }
            });
        }
    }
    public void traerChartsDeAlbumes(final ResultListener<List<Album>>listenerDeVista){
        if(HTTPConnectionManager.isNetworkingOnline(context)){
            DAOChartsInternet daoChartsInternet = new DAOChartsInternet();
            daoChartsInternet.getChartAlbumFromInternet(new ResultListener<List<Album>>() {
                @Override
                public void finish(List<Album> albumList) {
                    listenerDeVista.finish(albumList);
                }
            });
        }
    }

    public void traerChartsDeTemas(final ResultListener<List<Tema>>listenerDeVista){
        if(HTTPConnectionManager.isNetworkingOnline(context)){
            DAOChartsInternet daoChartsInternet = new DAOChartsInternet();
            daoChartsInternet.getChartTemaFromInternet(new ResultListener<List<Tema>>() {
                @Override
                public void finish(List<Tema> albumTema) {
                    listenerDeVista.finish(albumTema);
                }
            });
        }
    }



}
