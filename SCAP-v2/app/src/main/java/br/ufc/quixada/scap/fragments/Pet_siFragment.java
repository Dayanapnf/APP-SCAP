package br.ufc.quixada.scap.fragments;

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

import br.ufc.quixada.scap.Adapters.PetSiAdapter;
import br.ufc.quixada.scap.Model.Integrante;
import br.ufc.quixada.scap.R;

public class Pet_siFragment  extends Fragment {

    private ArrayList<Integrante> integrantesList;
    private String[] integrantesCargo;
    private String [] integrantesNome;
    private String[] integrantesEmail;
    private int[] imageResourceID;
    private RecyclerView recyclerview;

    public Pet_siFragment() {
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
        return inflater.inflate(R.layout.fragment_pet_si, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        recyclerview = view.findViewById(R.id.recycle_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        PetSiAdapter petAdapter = new PetSiAdapter(getContext(), integrantesList);
        recyclerview.setAdapter(petAdapter);
        petAdapter.notifyDataSetChanged();

    }

    private void dataInitialize() {
        integrantesList = new ArrayList<>();
        integrantesCargo = new String[]{
                getString(R.string.tutor),
                getString(R.string.bolsista),
                getString(R.string.bolsista),
                getString(R.string.bolsista),
                getString(R.string.bolsista),
                getString(R.string.bolsista),
                getString(R.string.bolsista),
                getString(R.string.bolsista),
                getString(R.string.bolsista),
                getString(R.string.bolsista),
                getString(R.string.bolsista)
        };

        imageResourceID = new int[]{
                R.drawable.tutor,
                R.drawable.bolsista01,
                R.drawable.bolsista02,
                R.drawable.bolsista03,
                R.drawable.bolsista04,
                R.drawable.bolsista05,
                R.drawable.bolsista06,
                R.drawable.bolsista07,
                R.drawable.bolsista08,
                R.drawable.bolsista09,
                R.drawable.bolsista10

        };
        integrantesNome = getResources().getStringArray(R.array.nome_array);
        integrantesEmail = getResources().getStringArray(R.array.email_array);

        for (int i = 0; i < integrantesCargo.length; i++){
            Integrante integrante = new Integrante(integrantesCargo[i], integrantesNome[i],integrantesEmail[i], imageResourceID[i]);
            integrantesList.add(integrante);
        }

    }
}