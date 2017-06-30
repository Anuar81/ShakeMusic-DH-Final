package digitalhouse.android.a0317moacns1c_03.Model.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dh3 on 29/06/17.
 */

public class ContainerAlbumTema {
    @SerializedName("data")
    private List<Tema>temaList;

    public List<Tema> getTemaList() {
        return temaList;
    }

    public void setTemaList(List<Tema> temaList) {
        this.temaList = temaList;
    }
}
