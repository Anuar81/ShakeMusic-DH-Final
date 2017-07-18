package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.R;

/**
 * Created by federico on 7/2/2017.
 */

public class AdapterChartsTema extends RecyclerView.Adapter {
    private Context context;
    private List<Tema> temaList;
    private InformarClickTema informable;

    public AdapterChartsTema(Context context, List<Tema> temaList,InformarClickTema informable) {
        this.context = context;
        this.temaList = temaList;
        this.informable =  informable;
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
        final Tema unTema = temaList.get(position);
        ChartTemaViewHolder chartTemaViewHolder = (ChartTemaViewHolder) holder;
        TextView textViewChartTema = chartTemaViewHolder.textViewDetalleCeldaChartTema;
        ImageView imageViewChartTema = chartTemaViewHolder.imageViewDetalleCeldaChartTema;
        textViewChartTema.setText(unTema.getName());

        imageViewChartTema.setImageResource(R.drawable.notamusicalvermelhahi);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                informable.informarClickTema(unTema);
            }
        });
    }

    @Override
    public int getItemCount() {
        return temaList.size();
    }

    private class ChartTemaViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDetalleCeldaChartTema;
        ImageView imageViewDetalleCeldaChartTema;


        public ChartTemaViewHolder(View itemView) {
            super(itemView);
            textViewDetalleCeldaChartTema = (TextView) itemView.findViewById(R.id.textViewTitle);
            imageViewDetalleCeldaChartTema = (ImageView) itemView.findViewById(R.id.imageViewCover);

        }
    }

    public interface InformarClickTema{
        public void informarClickTema (Tema tema);
    }

}

