package pl.edu.pwr.recyclerapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonFragment extends Fragment {

    ListView listV;
    List<Person> personList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout,container,false);
        // Initializing the ListView
        listV = (ListView) view.findViewById(R.id.listView);
        // Adapter will get the values from array and then show in the listView
        personList=new ArrayList<>();
        //list.add(new Person("adsf","fds","34"));
        AnimeItem item = (AnimeItem)getActivity().getIntent().getSerializableExtra("item");
        personList=item.getCast();
        ListAdapter adapter = new ListAdapter(getActivity(),personList);
        listV.setAdapter(adapter);
        //setListener();
        return view;
    }

    private void setListener(){
        listV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ItemDetailsActivity)getActivity()).swapFragments();
            }
        });
    }




}
