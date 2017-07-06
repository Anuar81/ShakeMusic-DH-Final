package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.R;

/**
 * Created by federico on 7/2/2017.
 */

public class AdapterChartsArtista extends RecyclerView.Adapter {

    private Context context;
    private List<Artista> artistaList;

    public AdapterChartsArtista(Context context, List<Artista> artistaList) {
        this.context = context;
        this.artistaList = artistaList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewChartArtist = inflater.inflate(R.layout.detalle_celda_album, parent, false);
        AdapterChartsArtista.ChartArtistaViewHolder chartArtistaViewHolder = new AdapterChartsArtista.ChartArtistaViewHolder(viewChartArtist);
        return chartArtistaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Artista unArtista = artistaList.get(position);
        ChartArtistaViewHolder chartArtistaViewHolder = (ChartArtistaViewHolder) holder;
        TextView textViewChartArtista = chartArtistaViewHolder.textViewDetalleCeldaChartArtista;
        ImageView imageViewChartArtista = chartArtistaViewHolder.imageViewDetalleCeldaChartArtista;
        textViewChartArtista.setText(unArtista.getName());
        Picasso.with(context).load(unArtista.getPicture()).into(imageViewChartArtista);

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


}
