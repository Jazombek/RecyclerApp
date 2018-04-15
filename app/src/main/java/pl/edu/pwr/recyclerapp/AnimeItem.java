package pl.edu.pwr.recyclerapp;


import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnimeItem implements Serializable {
    private int image;
    private String name;
    private String category;
    private List<Person> cast;
    private int[] screens;

    AnimeItem(String name, String category){
        setImage(R.drawable.ic_launcher_background);
        this.setName(name);
        this.setCategory(category);
    }

    AnimeItem(String name, String category, int image, int[] screens){
        this.setImage(image);
        this.setName(name);
        this.setCategory(category);
        this.setScreens(screens);
    }


    public int getImage() {
        return image;
    }

    public void setImage(int imageName) {
        this.image = imageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Person> getCast() {
        return cast;
    }

    public void setCast(List<Person> cast) {
        this.cast = cast;
    }

    public int[] getScreens() {
        return screens;
    }

    public void setScreens(int[] screens) {
        this.screens = screens;
    }
}
