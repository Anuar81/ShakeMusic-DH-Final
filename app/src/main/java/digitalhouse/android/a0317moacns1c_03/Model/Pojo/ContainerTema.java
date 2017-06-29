package digitalhouse.android.a0317moacns1c_03.Model.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alarrama on 29/06/17.
 */

public class ContainerTema {
    @SerializedName("Data")
    private List<Tema>listaDeTemas;

    public List<Tema> getListaDeTemas() {
        return listaDeTemas;
    }

    public void setListaDeTemas(List<Tema> listaDeTemas) {
        this.listaDeTemas = listaDeTemas;
    }
}
