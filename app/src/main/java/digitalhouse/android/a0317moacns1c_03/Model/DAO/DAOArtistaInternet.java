package digitalhouse.android.a0317moacns1c_03.Model.DAO;

import android.os.AsyncTask;

import com.google.gson.Gson;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.utils.DAOException;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by alarrama on 27/06/17.
 */

public class DAOArtistaInternet {

    String idArtistaABuscar;

    public void buscarArtistaInternet(ResultListener<Artista> artistaDeController, String idArtistaABuscar){
        this.idArtistaABuscar = idArtistaABuscar;

    }

    class MinionArtista extends AsyncTask<String, Void,Artista>{
        private ResultListener<Artista> artistaController;

        public MinionArtista(ResultListener<Artista> artistaController) {
            this.artistaController = artistaController;
        }

        @Override
        protected Artista doInBackground(String... params) {

            try{
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String stringApi = httpConnectionManager.getRequestString("https://api.deezer.com/artist/" + idArtistaABuscar);
                Gson gson = new Gson();
                Artista artistBuscado = gson.fromJson(stringApi,Artista.class);

            }catch (DAOException e){
                e.printStackTrace();
            }

            return null;
        }
    }

}
