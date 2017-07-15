package digitalhouse.android.a0317moacns1c_03.Model.Pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dh3 on 19/06/17.
 */

public class Album {

/*    @SerializedName("genres")
    private Genero genero;*/

  /*  private String fans;

    private String link;

    private String type;

    private String nb_tracks;*/

    private String id;


     private String cover;

 //   private String share;*/

    private String title;

   /* private String cover_medium;

    private String record_type;*/

/*    @SerializedName("artist")
    private Artista artista;*/

/*    private String explicit_lyrics;

    private String genre_id;*/

/*    private Contributors[] contributors;*/

/*    private String label;*/

    private String cover_big;

    @SerializedName("tracks")
    private ContainerAlbumTema containerAlbumTema;

/*    private String cover_small;

    private String available;

    private String upc;

    private String duration;

    private String cover_xl;

    private String release_date;

    private String rating;

    private String tracklist;*/

/*    public Genero getGenero ()
    {
        return genero;
    }

    public void setGenero (Genero genero)
    {
        this.genero = genero;
    }*/

/*    public String getFans ()
    {
        return fans;
    }

    public void setFans (String fans)
    {
        this.fans = fans;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getNb_tracks ()
    {
        return nb_tracks;
    }

    public void setNb_tracks (String nb_tracks)
    {
        this.nb_tracks = nb_tracks;
    }*/

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

   /* public String getCover ()
    {
        return cover;
    }

    public void setCover (String cover)
    {
        this.cover = cover;
    }

    public String getShare ()
    {
        return share;
    }

    public void setShare (String share)
    {
        this.share = share;
    }*/

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public ContainerAlbumTema getContainerAlbumTema() {
        return containerAlbumTema;
    }

    public void setContainerAlbumTema(ContainerAlbumTema containerAlbumTema) {
        this.containerAlbumTema = containerAlbumTema;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", containerAlbumTema=" + containerAlbumTema +
                '}';
    }
}

   /* public String getCover_medium ()
    {
        return cover_medium;
    }

    public void setCover_medium (String cover_medium)
    {
        this.cover_medium = cover_medium;
    }

    public String getRecord_type ()
    {
        return record_type;
    }

    public void setRecord_type (String record_type)
    {
        this.record_type = record_type;
    }*/

/*    public Artista getArtista ()
    {
        return artista;
    }

    public void setArtista (Artista artista)
    {
        this.artista = artista;
    }*/

/*
    public String getExplicit_lyrics ()
    {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics (String explicit_lyrics)
    {
        this.explicit_lyrics = explicit_lyrics;
    }

    public String getGenre_id ()
    {
        return genre_id;
    }

    public void setGenre_id (String genre_id)
    {
        this.genre_id = genre_id;
    }
*/

/*    public Contributors[] getContributors ()
    {
        return contributors;
    }

    public void setContributors (Contributors[] contributors)
    {
        this.contributors = contributors;
    }*/

/*    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }*/

/*    public Cancion getCancion ()
    {
        return cancion;
    }

    public void setCancion (Cancion cancion)
    {
        this.cancion = cancion;
    }*/

/*    public String getCover_small ()
    {
        return cover_small;
    }

    public void setCover_small (String cover_small)
    {
        this.cover_small = cover_small;
    }

    public String getAvailable ()
    {
        return available;
    }

    public void setAvailable (String available)
    {
        this.available = available;
    }

    public String getUpc ()
    {
        return upc;
    }

    public void setUpc (String upc)
    {
        this.upc = upc;
    }

    public String getCover_big ()
    {
        return cover_big;
    }

    public void setCover_big (String cover_big)
    {
        this.cover_big = cover_big;
    }

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public String getCover_xl ()
    {
        return cover_xl;
    }

    public void setCover_xl (String cover_xl)
    {
        this.cover_xl = cover_xl;
    }

    public String getRelease_date ()
    {
        return release_date;
    }

    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }*/

/**/


/*    @Override
    public String toString()
    {
        return "ClassPojo [genero = "+genero+", fans = "+fans+", link = "+link+", type = "+type+", nb_tracks = "+nb_tracks+", id = "+id+", cover = "+cover+", share = "+share+", title = "+title+", cover_medium = "+cover_medium+", record_type = "+record_type+", artista = "+artista+", explicit_lyrics = "+explicit_lyrics+", genre_id = "+genre_id+", contributors = "+contributors+", label = "+label+", cancion = "+cancion+", cover_small = "+cover_small+", available = "+available+", upc = "+upc+", cover_big = "+cover_big+", duration = "+duration+", cover_xl = "+cover_xl+", release_date = "+release_date+", rating = "+rating+", tracklist = "+tracklist+"]";
    }
}*/



