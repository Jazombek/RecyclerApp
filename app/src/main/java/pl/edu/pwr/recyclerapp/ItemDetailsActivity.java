package pl.edu.pwr.recyclerapp;

import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;

import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemDetailsActivity extends Activity  {
    TextView name,category;
    ImageButton image;
    AnimeItem item;
    FrameLayout frame;
    private final FragmentManager fm = getFragmentManager();
    private Fragment currentFragment = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        item = (AnimeItem)getIntent().getSerializableExtra("item");

        setContent();
    }
    public static void start(Context context, AnimeItem item) {
        Intent starter = new Intent(context, ItemDetailsActivity.class);
        starter.putExtra("item", item);
        context.startActivity(starter);
    }
    private void setContent(){
        name = findViewById(R.id.nameTextView);
        category = findViewById(R.id.categoryTextView);
        name.setText(item.getName());
        category.setText(item.getCategory());
        image = findViewById(R.id.detailImageView);
        image.setImageResource(item.getImage());

        frame = findViewById(R.id.frameLayout);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                swapFragments();
            }
        });

        setPicturesFragment();

    }
    private void setPersonFragment(){
        FragmentTransaction ft = this.fm.beginTransaction();

        this.currentFragment = new PersonFragment();

        ft.replace(R.id.frameLayout, this.currentFragment);
        ft.commit();
    }

    private void setPicturesFragment(){
        FragmentTransaction ft = this.fm.beginTransaction();

        this.currentFragment = new PictureFragment();

        ft.replace(R.id.frameLayout, this.currentFragment);
        ft.commit();
    }

    protected void swapFragments(){
        if (currentFragment.getClass().equals(PersonFragment.class)){
            setPicturesFragment();
        }else {
            setPersonFragment();
        }
    }

}
