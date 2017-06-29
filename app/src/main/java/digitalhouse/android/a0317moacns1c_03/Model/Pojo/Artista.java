package digitalhouse.android.a0317moacns1c_03.Model.Pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alarrama on 27/06/17.
 */

public class Artista {
    private Integer id;
    private String link;
    private String name;
    private String picture;
    @SerializedName("picture_medium")
    private String pictureMedium;
    @SerializedName("nb_album")
    private Integer cantidadAlbums;
    private String tracklist;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureMedium() {
        return pictureMedium;
    }

    public void setPictureMedium(String pictureMedium) {
        this.pictureMedium = pictureMedium;
    }

    public Integer getCantidadAlbums() {
        return cantidadAlbums;
    }

    public void setCantidadAlbums(Integer cantidadAlbums) {
        this.cantidadAlbums = cantidadAlbums;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
