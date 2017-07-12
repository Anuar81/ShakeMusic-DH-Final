package digitalhouse.android.a0317moacns1c_03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.ControllerShakes;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.View.AdapterChartsTema;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentShakes extends Fragment {

    private RecyclerView recyclerViewShakes;
    private List<Tema> listaDeTemas;
    private AdapterChartsTema adapterdeShakes;



    public FragmentShakes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listaDeTemas = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_shakes, container, false);
        recyclerViewShakes= (RecyclerView)view.findViewById(R.id.recyclerShakes);
        recyclerViewShakes.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        adapterdeShakes = new AdapterChartsTema(getActivity(),listaDeTemas);

        cargarRecyclerShakes();


        return view;
    }

    private void cargarRecyclerShakes (){
        ControllerShakes controllerShakes = new ControllerShakes(getContext());
        controllerShakes.obtenerShakes(new ResultListener<List<Tema>>() {
            @Override
            public void finish(List<Tema> temaList) {
                listaDeTemas.addAll(temaList);
                adapterdeShakes.notifyDataSetChanged();
            }
        });
    }
}
