package pl.edu.pwr.recyclerapp;

import java.util.ArrayList;

/**
 * Created by bartek on 11.04.2018.
 */

public class Person implements java.io.Serializable{
    public String name;
    public String surname;
    public String born;
    public int image;


    Person(String name, String surname, String data){
        this.name = name;
        this.surname = surname;

        this.born =data;
        image =R.drawable.ic_launcher_foreground;
    }

    Person(String name, String surname, String data, int image){
        this.name = name;
        this.surname = surname;

        this.born =data;
        this.image =image;
    }



}
