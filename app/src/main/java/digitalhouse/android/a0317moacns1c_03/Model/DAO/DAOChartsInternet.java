package digitalhouse.android.a0317moacns1c_03.Model.DAO;

import android.os.AsyncTask;

import com.google.gson.Gson;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.ContainerChartAlbum;
import digitalhouse.android.a0317moacns1c_03.utils.DAOException;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by federico on 6/29/2017.
 */

public class DAOChartsInternet {

    public void getChartAlbumFromInternet(ResultListener<ContainerChartAlbum> listenerController){

        DAOChartsInternet.RetrieveChartsAlbumTask unRetrieveChartsAlbumTask = new DAOChartsInternet.RetrieveChartsAlbumTask();
        unRetrieveChartsAlbumTask.setListenerController(listenerController);
        unRetrieveChartsAlbumTask.execute();

    }

    public class RetrieveChartsAlbumTask extends AsyncTask<Object, Object, ContainerChartAlbum> {
        private ResultListener<ContainerChartAlbum> listenerController;
        public void setListenerController(ResultListener<ContainerChartAlbum> listenerController) {
            this.listenerController = listenerController;
        }

        @Override
        protected ContainerChartAlbum doInBackground(Object... params) {
            try {
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String stringJSON = httpConnectionManager.getRequestString("http://api.deezer.com/chart/0/albums");

                Gson gson = new Gson();
                ContainerChartAlbum containerChartAlbum = gson.fromJson(stringJSON, ContainerChartAlbum.class);


                return containerChartAlbum;

            } catch (DAOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ContainerChartAlbum containerChartAlbum) {
            listenerController.finish(containerChartAlbum);
        }
    }


}
