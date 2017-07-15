package digitalhouse.android.a0317moacns1c_03.Model.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dh1 on 15/07/17.
 */

public class ContainerArtistaTema {
    @SerializedName("data")
    private List<Tema> temaList;

    public List<Tema> getTemaList() {
        return temaList;
    }

    public void setTemaList(List<Tema> temaList) {
        this.temaList = temaList;
    }
}
