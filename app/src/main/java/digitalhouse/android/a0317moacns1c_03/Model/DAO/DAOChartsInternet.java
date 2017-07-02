package digitalhouse.android.a0317moacns1c_03.Model.DAO;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.ContainerChartAlbum;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.ContainerChartArtista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.ContainerChartTema;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.utils.DAOException;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by federico on 6/29/2017.
 */

public class DAOChartsInternet {

    public void getChartAlbumFromInternet(ResultListener<List<Album>> listenerControllerAlbum){

        DAOChartsInternet.RetrieveChartsAlbumTask unRetrieveChartsAlbumTask = new DAOChartsInternet.RetrieveChartsAlbumTask();
        unRetrieveChartsAlbumTask.setListenerController(listenerControllerAlbum);
        unRetrieveChartsAlbumTask.execute();


    }

    public void getChartArtistaFromInternet(ResultListener<List<Artista>> listenerControllerArtista) {

        DAOChartsInternet.RetrieveChartsArtistTask unRetrieveChartsArtistTask = new DAOChartsInternet.RetrieveChartsArtistTask();
        unRetrieveChartsArtistTask.setListenerController(listenerControllerArtista);
        unRetrieveChartsArtistTask.execute();
    }

    public void getChartTemaFromInternet(ResultListener<List<Tema>> listenerControllerTema) {

        DAOChartsInternet.RetrieveChartsTemaTask unRetrieveChartsTemaTask = new DAOChartsInternet.RetrieveChartsTemaTask();
        unRetrieveChartsTemaTask.setListenerController(listenerControllerTema);
        unRetrieveChartsTemaTask.execute();
    }


    public class RetrieveChartsAlbumTask extends AsyncTask<Object, Object, List<Album>> {
        private ResultListener<List<Album>> listenerControllerAlbum;
        public void setListenerController(ResultListener<List<Album>> listenerControllerAlbum) {
            this.listenerControllerAlbum = listenerControllerAlbum;
        }

        @Override
        protected List<Album> doInBackground(Object... params) {
            try {
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String stringJSON = httpConnectionManager.getRequestString("http://api.deezer.com/chart/0/albums");

                Gson gson = new Gson();
                ContainerChartAlbum containerChartAlbum = gson.fromJson(stringJSON, ContainerChartAlbum.class);


                return containerChartAlbum.getListaAlbum();

            } catch (DAOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Album> albumList) {
            listenerControllerAlbum.finish(albumList);
        }
    }

    public class RetrieveChartsArtistTask extends AsyncTask<Object, Object, List<Artista>> {
        private ResultListener<List<Artista>> listenerControllerArtista;
        public void setListenerController(ResultListener<List<Artista>> listenerControllerArtista) {
            this.listenerControllerArtista = listenerControllerArtista;
        }

        @Override
        protected List<Artista> doInBackground(Object... params) {
            try {
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String stringJSON = httpConnectionManager.getRequestString("http://api.deezer.com/chart/0/artists");

                Gson gson = new Gson();
                ContainerChartArtista containerChartArtista = gson.fromJson(stringJSON, ContainerChartArtista.class);


                return containerChartArtista.getListaArtistas();

            } catch (DAOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Artista> artistaList) {
            listenerControllerArtista.finish(artistaList);
        }
    }

    public class RetrieveChartsTemaTask extends AsyncTask<Object, Object, List<Tema>> {
        private ResultListener<List<Tema>> listenerControllerTema;
        public void setListenerController(ResultListener<List<Tema>> listenerControllerTema) {
            this.listenerControllerTema = listenerControllerTema;
        }

        @Override
        protected List<Tema> doInBackground(Object... params) {
            try {
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String stringJSON = httpConnectionManager.getRequestString("http://api.deezer.com/chart/0/tracks");

                Gson gson = new Gson();
                ContainerChartTema containerChartTema = gson.fromJson(stringJSON, ContainerChartTema.class);


                return containerChartTema.getListaTemas();

            } catch (DAOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Tema> temaList) {
            listenerControllerTema.finish(temaList);
        }
    }



}
