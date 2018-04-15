package pl.edu.pwr.recyclerapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

public class RecyclerMenu extends AppCompatActivity implements RecyclerItemSwipeHelper.RecyclerItemTouchHelperListener {

    private List<AnimeItem> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyRecyclerAdapter mAdapter;





        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycler_menu);


            setRecyclerViev();

            prepareData();

            addRecyclerListener();

    }

    private void addRecyclerListener(){
        recyclerView.addOnItemTouchListener(new RecyclerOnClickListener(getApplicationContext(), recyclerView, new RecyclerOnClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                AnimeItem item = movieList.get(position);
                ItemDetailsActivity.start(getApplicationContext(),item);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void setRecyclerViev(){
        recyclerView =  findViewById(R.id.recycler);

        mAdapter = new MyRecyclerAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemSwipeHelper(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(mAdapter);
    }



    private void prepareData(){
        int[] screens = new int[6];
        screens[0]=R.drawable.fma;
        screens[1]=R.drawable.edelr;
        screens[2]=R.drawable.alpel;
        screens[3]=R.drawable.naruto;
        screens[4]=R.drawable.winry;
        screens[5]=R.drawable.naruto;
        AnimeItem item = new AnimeItem("Fullmetal Alchemist: Brotherhood", "Adventure", R.drawable.fma,screens);
        ArrayList<Person>cast=new ArrayList<>();
        cast.add(new Person("Edward","Elric","18",R.drawable.edelr));
        cast.add(new Person("Alphonse","Elric","17",R.drawable.alpel));
        cast.add(new Person("Winry","Rockbell","18",R.drawable.winry));
        item.setCast(cast);
        movieList.add(item);
        screens[0]=R.drawable.bebop;
        screens[1]=R.drawable.narutou;
        screens[2]=R.drawable.spike;
        screens[3]=R.drawable.kakashi;
        screens[4]=R.drawable.winry;
        screens[5]=R.drawable.ein;
        item = new AnimeItem("Cowboy Bebop", "Drama", R.drawable.bebop,screens);
        cast=new ArrayList<>();
        cast.add(new Person("Spike","Spiegel","27",R.drawable.spike));
        cast.add(new Person("Jet","Black","36",R.drawable.jet));
        cast.add(new Person("Faye","Valentine","24",R.drawable.faye));
        cast.add(new Person("Ein","","3",R.drawable.ein));
        item.setCast(cast);
        movieList.add(item);
        screens[0]=R.drawable.pp;
        screens[1]=R.drawable.bebop;
        screens[2]=R.drawable.shinya;
        screens[3]=R.drawable.akane;
        screens[4]=R.drawable.shougo;
        screens[5]=R.drawable.shuusei;
        item = new AnimeItem("Psycho Pass", "Crime", R.drawable.pp,screens);
        cast=new ArrayList<>();
        cast.add(new Person("Shinya","Kogami","28", R.drawable.shinya));
        cast.add(new Person("Akane","Tsunemori","20", R.drawable.akane));
        cast.add(new Person("Shougo","Makishima","27", R.drawable.shougo));
        cast.add(new Person("Shuusei","Kagari","23", R.drawable.shuusei));
        item.setCast(cast);
        movieList.add(item);
        screens[0]=R.drawable.narutou;
        screens[1]=R.drawable.naruto;
        screens[2]=R.drawable.sasuke;
        screens[3]=R.drawable.kakashi;
        screens[4]=R.drawable.fma;
        screens[5]=R.drawable.pp;
        item = new AnimeItem("Naruto Shippuuden", "Action", R.drawable.naruto,screens);
        cast=new ArrayList<>();
        cast.add(new Person("Naruto","Uzumaki","17", R.drawable.narutou));
        cast.add(new Person("Kakashi","Hatake","33", R.drawable.kakashi));
        cast.add(new Person("Sasuke","Uchiha","17", R.drawable.sasuke));
        item.setCast(cast);
        movieList.add(item);
        screens[0]=R.drawable.dn;
        screens[1]=R.drawable.light;
        screens[2]=R.drawable.ryuuk;
        screens[3]=R.drawable.l;
        screens[4]=R.drawable.sasuke;
        screens[5]=R.drawable.narutou;
        item = new AnimeItem("Death Note", "thriller",R.drawable.dn,screens);
        cast=new ArrayList<>();
        cast.add(new Person("Light","Yagami","23", R.drawable.light));
        cast.add(new Person("L","Lawliet","25", R.drawable.l));
        cast.add(new Person("Ryuuk","","?", R.drawable.ryuuk));
        item.setCast(cast);
        movieList.add(item);


    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        mAdapter.removeItem(viewHolder.getAdapterPosition());
    }
}
