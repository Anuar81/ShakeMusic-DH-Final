package digitalhouse.android.a0317moacns1c_03.Controller;

import android.content.Context;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.DAO.DAOShakeHistorialDB;
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

    public void obtenerShakes(final ResultListener<List<Tema>> listenerDeVista) {

        DAOShakesDB daoShakesDB = new DAOShakesDB(context);
        listenerDeVista.finish(daoShakesDB.getAllTemas());
    }

    public void agregarTemaShake (Tema tema){
        DAOShakeHistorialDB daoShakeHistorialDB = new DAOShakeHistorialDB(context);
        daoShakeHistorialDB.addTema(tema);
    }


    public void obtenerHistorial(final ResultListener<List<Tema>> listenerDeVista) {

        DAOShakeHistorialDB daoHistorialDB = new DAOShakeHistorialDB(context);
        listenerDeVista.finish(daoHistorialDB.getAllTemas());
    }

    public void agregarTemaAlHistorial (Tema tema){
        DAOShakeHistorialDB daoShakeHistorialDB = new DAOShakeHistorialDB(context);
        daoShakeHistorialDB.addTema(tema);
    }
}