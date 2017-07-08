package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        this.temaList = temaList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewChartTemas = inflater.inflate(R.layout.detalle_celda_chart, parent, false);
        AdapterChartsTema.ChartTemaViewHolder chartTemaViewHolder = new AdapterChartsTema.ChartTemaViewHolder(viewChartTemas);
        return chartTemaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Tema unTema = temaList.get(position);
        ChartTemaViewHolder chartTemaViewHolder = (ChartTemaViewHolder) holder;
        TextView textViewChartTema = chartTemaViewHolder.textViewDetalleCeldaChartTema;
        textViewChartTema.setText(unTema.getName());
    }

    @Override
    public int getItemCount() {
        return temaList.size();
    }

    private class ChartTemaViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDetalleCeldaChartTema;

        public ChartTemaViewHolder(View itemView) {
            super(itemView);
            textViewDetalleCeldaChartTema = (TextView) itemView.findViewById(R.id.textViewTitle);

        }
    }
}
