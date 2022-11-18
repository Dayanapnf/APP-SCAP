package br.ufc.quixada.scap.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.ufc.quixada.scap.Adapters.MinhasAtividadesAdapter;
import br.ufc.quixada.scap.FormAddAtividade;
import br.ufc.quixada.scap.Model.Atividades;
import br.ufc.quixada.scap.R;

public class AtividadesFragment extends Fragment {

    private RecyclerView recyclerView;
    ArrayList<Atividades> atividadesList;
    MinhasAtividadesAdapter adapter;
    Intent intent;
    FormAddAtividade f;

    public AtividadesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_atividades, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        //atividadesList = f.getAtividadesList();
        //dataInitialize();

        recyclerView = view.findViewById(R.id.lista_atividades);

        adapter = new MinhasAtividadesAdapter(atividadesList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


        adapter.notifyDataSetChanged();
    }




    /*private ListView listView;
    private String[] title_atividade;
    private String [] autor;
    private int[] imageResourceID;
    ArrayList<Atividades> atividadesList;
    ScapBD bdHelper;
    Atividades atividade;
    ArrayAdapter adapter;

    public AtividadesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_atividades, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) listView.findViewById(R.id.lista_atividades);

    }
    public void onResume() {
        super.onResume();
        dataInitialize();
    }


    private void dataInitialize() {
        bdHelper = new ScapBD(getParentFragment().getContext());
        atividadesList = bdHelper.getLista();
        bdHelper.close();

        if(atividadesList != null){
            adapter = new ArrayAdapter<Atividades>(getParentFragment().getContext(), R.layout.list_atividades);
            listView.setAdapter(adapter);
        }




    }*/


}