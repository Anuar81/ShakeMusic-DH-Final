package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dh3 on 19/06/17.
 */

public class AdapterAlbumTemas extends RecyclerView.Adapter{

    private Context context;
    private List<Tema> temaList;

    public AdapterAlbumTemas(Context context) {
        this.context = context;
        temaList = new ArrayList<>();
    }

    public void setTemaList(List<Tema> temaList) {
        this.temaList = temaList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.detalle_item_album, parent, false);
        TemaViewHolder temaViewHolder = new TemaViewHolder(view);
        return temaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TemaViewHolder temaViewHolder = (TemaViewHolder) holder;
        temaViewHolder.bindTema(temaList.get(position));
    }

    @Override
    public int getItemCount() {
        return temaList.size();
    }

    public class TemaViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTemaTitle;
        /*private ImageView imageViewThumbnailUrl;*/

        public TemaViewHolder(View itemView) {
            super(itemView);
            textViewTemaTitle = (TextView) itemView.findViewById(R.id.textViewTitleTemaAlbum);
           /* imageViewThumbnailUrl = (ImageView) itemView.findViewById(R.id.imageView);*/

        }

        public void bindTema(Tema tema){
            textViewTemaTitle.setText(tema.getName());
            /*Picasso.with(context).load(album.getThumbnailUrl()).into(imageViewThumbnailUrl);*/
        }
    }





   /* VER ADAPTER DEL TOOLBAR (Dato sería Album)

   private List<Dato> lista;

    public MiAdapter(List<Dato> lista){
        this.lista = lista;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.cargarDato(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }

        public void cargarDato(Dato dato){
            title.setText(dato.getTitle());
            description.setText(dato.getDescription());
        }
    }*/









}
