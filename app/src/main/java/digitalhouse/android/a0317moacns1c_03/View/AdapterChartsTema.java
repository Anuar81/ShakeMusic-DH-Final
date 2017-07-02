package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;

/**
 * Created by federico on 7/2/2017.
 */

public class AdapterChartsTema extends RecyclerView.Adapter {
    private Context context;
    private List<Tema> temaList;

    public AdapterChartsTema(Context context, List<Tema> temaList) {
        this.context = context;
        this.temaList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewChartTemas = inflater.inflate(R.layout.fragment_fragment_principal, parent, false);
        AdapterChartsTema.ChartTemaViewHolder chartTemaViewHolder = new AdapterChartsTema.ChartTemaViewHolder(viewChartTemas);
        return chartTemaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return temaList.size();
    }

    private class ChartTemaViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerViewTema;

        public ChartTemaViewHolder(View itemView) {
            super(itemView);
            recyclerViewTema = (RecyclerView) itemView.findViewById(R.id.recyclerChartTracks);

        }
    }
}