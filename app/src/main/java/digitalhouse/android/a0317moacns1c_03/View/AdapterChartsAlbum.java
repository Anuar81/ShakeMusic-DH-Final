package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Album;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Artista;
import digitalhouse.android.a0317moacns1c_03.R;

/**
 * Created by federico on 7/1/2017.
 */

public class AdapterChartsAlbum extends RecyclerView.Adapter {
    private Context context;
    private List<Album> albumList;

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public AdapterChartsAlbum(Context context, List<Album> albumList) {
        this.context = context;
        this.albumList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewChartAlbum = inflater.inflate(R.layout.fragment_fragment_principal, parent, false);
        AdapterChartsAlbum.ChartAlbumViewHolder chartAlbumViewHolder = new AdapterChartsAlbum.ChartAlbumViewHolder(viewChartAlbum)  ;
        return chartAlbumViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    private class ChartAlbumViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerViewChartAlbum;

        public ChartAlbumViewHolder(View itemView) {
            super(itemView);
            recyclerViewChartAlbum = (RecyclerView) itemView.findViewById(R.id.recyclerChartAlbums);

        }
    }
}
