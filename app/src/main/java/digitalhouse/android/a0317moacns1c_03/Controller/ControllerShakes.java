package digitalhouse.android.a0317moacns1c_03.Controller;

import android.content.Context;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.DAO.DAOShakesDB;
import digitalhouse.android.a0317moacns1c_03.Model.DAO.DAOTemaInternet;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.utils.HTTPConnectionManager;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;

/**
 * Created by dh3 on 05/07/17.
 */

public class ControllerShakes {

    private Context context;

    public ControllerShakes(Context context) {
        this.context = context;
    }

    public void obtenerShakes(final ResultListener<List<Tema>> listenerDeVista, String idShakeABuscar) {

        DAOShakesDB daoShakesDB = new DAOShakesDB(context);
        listenerDeVista.finish(daoShakesDB.getAllTemas());
    }
}