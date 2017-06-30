package digitalhouse.android.a0317moacns1c_03.Model.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by federico on 6/29/2017.
 */

public class ContainerChartAlbum {

    @SerializedName("data")
    private List<Album> listaAlbumes;

    public List<Album> getListaAlbum() {
        return listaAlbumes;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbumes = listaAlbum;
    }
}
