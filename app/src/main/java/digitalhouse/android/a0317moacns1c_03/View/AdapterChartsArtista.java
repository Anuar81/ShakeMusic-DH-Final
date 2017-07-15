package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;

/**
 * Created by federico on 7/2/2017.
 */

public class AdapterChartsArtista extends RecyclerView.Adapter {

    private Context context;
    private List<Artista> artistaList;
    private InformarClickArtista informable;

    public void setArtistaList(List<Artista> artistaList) {
        this.artistaList = artistaList;
    }

    public AdapterChartsArtista(Context context, List<Artista> artistaList,InformarClickArtista informable) {
        this.context = context;
        this.artistaList = artistaList;
        this.informable =  informable;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewChartArtist = inflater.inflate(R.layout.detalle_celda_chart, parent, false);
        AdapterChartsArtista.ChartArtistaViewHolder chartArtistaViewHolder = new AdapterChartsArtista.ChartArtistaViewHolder(viewChartArtist);
        return chartArtistaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Artista unArtista = artistaList.get(position);

        ChartArtistaViewHolder chartArtistaViewHolder = (ChartArtistaViewHolder) holder;

        TextView textViewChartArtista = chartArtistaViewHolder.textViewDetalleCeldaChartArtista;
        ImageView imageViewChartArtista = chartArtistaViewHolder.imageViewDetalleCeldaChartArtista;
        textViewChartArtista.setText(unArtista.getName());

        Picasso.with(context).load(unArtista.getPicture()).into(imageViewChartArtista);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informable.informarClickArtista(unArtista);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artistaList.size();
    }

    private class ChartArtistaViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewDetalleCeldaChartArtista;
        private ImageView imageViewDetalleCeldaChartArtista;
        public ChartArtistaViewHolder(View itemView) {
            super(itemView);
            textViewDetalleCeldaChartArtista = (TextView) itemView.findViewById(R.id.textViewTitle);
            imageViewDetalleCeldaChartArtista = (ImageView) itemView.findViewById(R.id.imageViewCover);
        }
    }

    public interface InformarClickArtista{
        public void informarClickArtista (Artista artista);
    }

}
