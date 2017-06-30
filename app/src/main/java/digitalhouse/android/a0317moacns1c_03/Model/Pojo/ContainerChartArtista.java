package digitalhouse.android.a0317moacns1c_03.Model.Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by federico on 6/29/2017.
 */

public class ContainerChartArtista {
    @SerializedName("data")
    private List<Artista> listaArtistas;

    public List<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(List<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }
}
