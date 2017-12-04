package com.example.bernard.foodhunt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_meal,container,false);

        Button meal_breakfast = (Button) v.findViewById(R.id.meal_breakfast);
        Button meal_lunch = (Button) v.findViewById(R.id.meal_lunch);
        Button meal_dinner = (Button) v.findViewById(R.id.meal_dinner);


        meal_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(), FoodMain.class);
                mainIntent.putExtra("meal", "breakfast");
                startActivity(mainIntent);
            }
        });

        meal_lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(), FoodMain.class);
                mainIntent.putExtra("meal", "lunch");
                startActivity(mainIntent);
            }
        });

        meal_dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(), FoodMain.class);
                mainIntent.putExtra("meal", "dinner");
                startActivity(mainIntent);
            }
        });

        return v;
    }
}
