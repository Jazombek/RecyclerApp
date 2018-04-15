package pl.edu.pwr.recyclerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends ArrayAdapter<Person> {
    private List<Person> list = new ArrayList<>();

    ListAdapter(Context context, List<Person> users) {

        super(context, 0, users);
        this.list=users;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Person item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.person_layout, parent, false);
        }

        TextView imie =  convertView.findViewById(R.id.nameTextView);
        TextView nazwisko =  convertView.findViewById(R.id.surnameTextView);
        TextView wiek =  convertView.findViewById(R.id.ageTextView);
        ImageView image = convertView.findViewById(R.id.personImageView);

        imie.setText(item.name);
        nazwisko.setText(item.surname);
        wiek.setText(item.born);
        image.setImageResource(item.image);


        return convertView;
    }
}
