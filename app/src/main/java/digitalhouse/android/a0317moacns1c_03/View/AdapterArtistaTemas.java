package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;

/**
 * Created by federico on 6/29/2017.
 */

public class AdapterArtistaTemas extends RecyclerView.Adapter/* implements View.OnClickListener */{

    private Context context;
    private List<Tema> temaList;
    private InformarClickFragmentDetalleArtistaTema escuchador;

    public AdapterArtistaTemas(Context context, List<Tema> temaList,InformarClickFragmentDetalleArtistaTema escuchador) {
        this.context = context;
        this.temaList = temaList;
        this.escuchador = escuchador;
    }

    public void setTemaList(List<Tema> temaList) {
        this.temaList = temaList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.detalle_item_artista, parent, false);
        TemaViewHolder temaViewHolder = new TemaViewHolder(view);
        return temaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TemaViewHolder temaViewHolder = (TemaViewHolder) holder;
        final Tema tema = temaList.get(position);
        temaViewHolder.bindTema(tema);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escuchador.informarClickenFragmentDetalleArtistaTema(tema);
            }
        });
    }

    @Override
    public int getItemCount() {
        return temaList.size();
    }

    public class TemaViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewArtistaTitle;
        /*private ImageView imageViewThumbnailUrl;*/

        public TemaViewHolder(View itemView) {
            super(itemView);
            textViewArtistaTitle = (TextView) itemView.findViewById(R.id.textViewTitleTemaArtista);
           /* imageViewThumbnailUrl = (ImageView) itemView.findViewById(R.id.imageView);*/

        }

        public void bindTema(Tema tema){
            textViewArtistaTitle.setText(tema.getName());
            /*Picasso.with(context).load(album.getThumbnailUrl()).into(imageViewThumbnailUrl);*/
        }
    }

    public interface InformarClickFragmentDetalleArtistaTema{
        public void informarClickenFragmentDetalleArtistaTema(Tema tema);
    }

}
