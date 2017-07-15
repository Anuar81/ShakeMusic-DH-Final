package digitalhouse.android.a0317moacns1c_03.Controller;

import android.content.Context;


import digitalhouse.android.a0317moacns1c_03.Model.DAO.DAOAlbumInternet;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by dh3 on 19/06/17.
 */

public class ControllerAlbum {

    private Context context;

    public ControllerAlbum(Context context) {
        this.context = context;
    }

    public void obtenerAlbum(final ResultListener<Album> resultListenerFromView,String idAlbumABuscar){

        if(HTTPConnectionManager.isNetworkingOnline(context)){

            //SI HAY CONEXION PIDO A INTERNET LOS DATOS Y LOS ALMACENO EN LA BASE DE DATOS.

            DAOAlbumInternet daoAlbumInternet = new DAOAlbumInternet();
            daoAlbumInternet.getAlbumFromInternet(new ResultListener<Album>() {

                @Override
                public void finish(Album album) {

 /*                   //EL RESULTADO DE LA LISTA DE TRACKS SE GUARDA EN LA BASE DE DATOS
                    DAOAlbumDataBase daoAlbumDataBase = new DAOAlbumDataBase(context);
                    daoAlbumDataBase.addAlbum(album);*/

                    resultListenerFromView.finish(album);
                }
            },idAlbumABuscar);
        }
        else {
            //SI NO HAY CONEXION UTILIZO LOS DATOS ALMACENADOS EN LA BASE DE DATOS.
/*
            DAOAlbumDataBase daoAlbumDatabase = new DAOAlbumDataBase(context);
            Album album = daoAlbumDatabase.getAllAlbums();
            resultListenerFromView.finish(album);*/
        }
    }
}
