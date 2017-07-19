package digitalhouse.android.a0317moacns1c_03;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Controller.ControllerShakes;
import digitalhouse.android.a0317moacns1c_03.Model.Pojo.Tema;
import digitalhouse.android.a0317moacns1c_03.View.AdapterChartsTema;
import digitalhouse.android.a0317moacns1c_03.utils.ResultListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHistorial extends Fragment implements AdapterChartsTema.InformarClickTema {

    private RecyclerView recyclerViewHistorial;
    private List<Tema> listaDeTemas;
    private AdapterChartsTema adapterDeHistorial;
    private InformarClickFragment escuchadorDelFragment;

    public FragmentHistorial() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listaDeTemas = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_historial, container, false);
        recyclerViewHistorial= (RecyclerView)view.findViewById(R.id.recyclerHistorial);
        recyclerViewHistorial.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        adapterDeHistorial = new AdapterChartsTema(getActivity(),listaDeTemas,FragmentHistorial.this);
        recyclerViewHistorial.setAdapter(adapterDeHistorial);
        Bundle unBundle = getArguments();

        cargarRecyclerHistorial();


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        escuchadorDelFragment = (InformarClickFragment)context;
    }

    private void cargarRecyclerHistorial (){
        ControllerShakes controllerShakes = new ControllerShakes(getContext());
        controllerShakes.obtenerHistorial(new ResultListener<List<Tema>>() {
            @Override
            public void finish(List<Tema> temaList) {
                listaDeTemas.addAll(temaList);
                adapterDeHistorial.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void informarClickTema(Tema tema) {
        escuchadorDelFragment.informarClickenFragment(tema);
    }



    public interface InformarClickFragment{
        public void informarClickenFragment(Tema tema);

    }
}

