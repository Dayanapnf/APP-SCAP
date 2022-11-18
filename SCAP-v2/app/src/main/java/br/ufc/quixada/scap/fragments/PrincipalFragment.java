package br.ufc.quixada.scap.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;

import br.ufc.quixada.scap.R;



public class PrincipalFragment extends Fragment {


    public PrincipalFragment() {
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
        View view = inflater.inflate(R.layout.fragment_principal, container, false);
        ImageCarousel carousel = (ImageCarousel) view.findViewById(R.id.carousel);

        //create list to store carousel image
        ArrayList<CarouselItem> clist = new ArrayList<>();
        clist.add(new CarouselItem(
                R.drawable.equipe,
                "Equipe PET-SI"
        ));

        clist.add(new CarouselItem(
                R.drawable.campus,
                "Campus"
        ));

        carousel.setData(clist);
        return view;



    }
}