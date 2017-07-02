package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        this.artistaList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewChartArtist = inflater.inflate(R.layout.fragment_fragment_principal, parent, false);
        AdapterChartsArtista.ChartArtistaViewHolder chartArtistaViewHolder = new AdapterChartsArtista.ChartArtistaViewHolder(viewChartArtist);
        return chartArtistaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return artistaList.size();
    }

    private class ChartArtistaViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerViewArtista;

        public ChartArtistaViewHolder(View itemView) {
            super(itemView);
            recyclerViewArtista = (RecyclerView) itemView.findViewById(R.id.recyclerChartArtists);

        }
    }


}
