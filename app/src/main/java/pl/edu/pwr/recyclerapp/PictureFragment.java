package pl.edu.pwr.recyclerapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;


public class PictureFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pictures_layout,container,false);
        AnimeItem item = (AnimeItem) getActivity().getIntent().getSerializableExtra("item");
        setimages(view,item);

        return view;
    }

    private void setimages(View view,AnimeItem item){
        ImageView image = view.findViewById(R.id.imageView1);
        image.setImageResource(item.getScreens()[0]);
        image = view.findViewById(R.id.imageView2);
        image.setImageResource(item.getScreens()[1]);
        image = view.findViewById(R.id.imageView3);
        image.setImageResource(item.getScreens()[2]);
        image = view.findViewById(R.id.imageView4);
        image.setImageResource(item.getScreens()[3]);
        image = view.findViewById(R.id.imageView5);
        image.setImageResource(item.getScreens()[4]);
        image = view.findViewById(R.id.imageView6);
        image.setImageResource(item.getScreens()[5]);
    }
}
