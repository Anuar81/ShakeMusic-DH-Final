package digitalhouse.android.a0317moacns1c_03.Controller;

import android.content.Context;

import digitalhouse.android.a0317moacns1c_03.Model.DAO.DAOTemaInternet;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by alarr on 23/6/2017.
 */

public class ControllerTema {
    private Context context;

    public ControllerTema(Context context) {
        this.context = context;
    }

    public void buscarCancion(final ResultListener<Tema> listenerDeVista, String idCancionABuscar){
        if(HTTPConnectionManager.isNetworkingOnline(context)){
            DAOTemaInternet daoTemaInternet = new DAOTemaInternet();
            daoTemaInternet.buscarTemaInternet(new ResultListener<Tema>() {
                @Override
                public void finish(Tema tema) {
                    listenerDeVista.finish(tema);
                }
            },idCancionABuscar);
        }
    }
}
