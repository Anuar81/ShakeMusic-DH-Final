package digitalhouse.android.a0317moacns1c_03.Model.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by federico on 6/29/2017.
 */

public class ContainerChartTema {

    @SerializedName("data")
    private List<Tema> listaTemas;

    public List<Tema> getListaTemas() {
        return listaTemas;
    }

    public void setListaTemas(List<Tema> listaTemas) {
        this.listaTemas = listaTemas;
    }
}
