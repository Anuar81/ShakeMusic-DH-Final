package digitalhouse.android.a0317moacns1c_03.Model.DAO;

import android.os.AsyncTask;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.utils.DAOException;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;
import com.google.gson.Gson;

/**
 * Created by dh3 on 19/06/17.
 */

public class DAOAlbumInternet {

    private String idAlbumABuscar;

//    "43197211"

    public void getAlbumFromInternet(ResultListener<Album> listenerController,String idAlbumABuscar){

        this.idAlbumABuscar = idAlbumABuscar;

        RetrieveAlbumTask unRetrieveAlbumTask = new RetrieveAlbumTask();
        unRetrieveAlbumTask.setListenerController(listenerController);
        unRetrieveAlbumTask.execute();

    }

    class RetrieveAlbumTask extends AsyncTask<String,Void,Album> {
        private ResultListener<Album> listenerController;


        public void setListenerController(ResultListener<Album> listenerController) {
            this.listenerController = listenerController;

        }

        @Override
        protected Album doInBackground(String... params) {
            try {
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String stringJSON = httpConnectionManager.getRequestString("https://api.deezer.com/album/"+idAlbumABuscar);

                Gson gson = new Gson();
                Album album = gson.fromJson(stringJSON, Album.class);


                return album;

            } catch (DAOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Album album) {
            listenerController.finish(album);
        }
    }

}
