package digitalhouse.android.a0317moacns1c_03.Model.DAO;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.ContainerTema;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.utils.DAOException;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by alarrama on 27/06/17.
 */

public class DAOArtistaInternet {

    String idArtistaABuscar;
    Integer limite;
    Integer inicio;


    public void buscarArtistaInternet(ResultListener<Artista> artistaDeController, String idArtistaABuscar){
        this.idArtistaABuscar = idArtistaABuscar;
        MinionArtista minionArtista = new MinionArtista();
        minionArtista.setArtistaController(artistaDeController);
        minionArtista.execute();
    }

    public void buscarPlayListArtistaInternet(ResultListener<List<Tema>> artistaDeController, String idArtistaABuscar){
        this.idArtistaABuscar=idArtistaABuscar;
        MinionListaCancionesArtista minionArtista = new MinionListaCancionesArtista();
        minionArtista.setListenerDeController(artistaDeController);
        minionArtista.execute();
    }

    public void buscarCancionesDeArtistaPaginado(ResultListener<List<Tema>>listenerDeControllerPaginacion, String idArtistaABuscar, Integer limite, Integer inicio){
        this.idArtistaABuscar = idArtistaABuscar;
        this.limite = limite;
        this.inicio = inicio;
        MinionListaCancionesArtista listaCancionesArtistaMinion = new MinionListaCancionesArtista();
        listaCancionesArtistaMinion.setListenerDeController(listenerDeControllerPaginacion);
        listaCancionesArtistaMinion.execute();
    }

    class MinionArtista extends AsyncTask<String, Void,Artista>{
        private ResultListener<Artista> artistaController;

        public void setArtistaController(ResultListener<Artista> artistaController) {
            this.artistaController = artistaController;
        }

        @Override
        protected Artista doInBackground(String... params) {
            Artista artista = new Artista();

            try{
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String stringApi = httpConnectionManager.getRequestString("https://api.deezer.com/artist/" + idArtistaABuscar);
                Gson gson = new Gson();
                artista = gson.fromJson(stringApi,Artista.class);
                return artista;

            }catch (DAOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Artista artista) {
            artistaController.finish(artista);
        }
    }

    class MinionListaCancionesArtista extends AsyncTask<String, Void, List<Tema>>{
        private ResultListener<List<Tema>> listenerDeController;

        public void setListenerDeController(ResultListener<List<Tema>> listenerDeController) {
            this.listenerDeController = listenerDeController;
        }

        @Override
        protected List<Tema> doInBackground(String... params) {
            List<Tema>listaTemasArtistaPaginado = new ArrayList<>();

            try{
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String stringApi = httpConnectionManager.getRequestString("https://api.deezer.com/artist/"+idArtistaABuscar+"/top?limit="+limite+"&index="+inicio);
                Gson gson = new Gson();
                ContainerTema containerParseado = gson.fromJson(stringApi, ContainerTema.class);
                listaTemasArtistaPaginado = containerParseado.getListaDeTemas();
                return listaTemasArtistaPaginado;

            }catch (DAOException e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<Tema> temas) {
            listenerDeController.finish(temas);
        }
    }

}
