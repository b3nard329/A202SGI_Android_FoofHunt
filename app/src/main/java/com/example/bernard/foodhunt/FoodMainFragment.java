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

public class FoodMainFragment extends Fragment {

    String education_level;
    private FoodDataSource datasource;
    Restaurant restaurant = null;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_main,container,false);

        final String meal = getActivity().getIntent().getStringExtra("meal");

        datasource = new FoodDataSource(getActivity());
        datasource.open();

        //Log.d("check12","data:"+datasource.checkRecord());
        if(datasource.checkRecord()==false){

            datasource.insertRecord("breakfast","Ah Lai Kopitiam","Low Price","Penang","RM5-10","7a.m.-11a.m.");
            datasource.insertRecord("breakfast","Pie Harbour","High Price","Penang","RM10-20","7a.m.-11a.m.");
            datasource.insertRecord("breakfast","Permatang Food Court","Low Price","Butterworth","RM5-10","7a.m.-11a.m.");
            datasource.insertRecord("breakfast","Garden Feel Cafe","High Price","Butterworth","RM10-20","7a.m.-11a.m.");
            datasource.insertRecord("lunch","Sungai Pinang Food Court","Low Price","Penang","RM5-10","12p.m.-6p.m.");
            datasource.insertRecord("lunch","Sakae Shusi","High Price","Penang","RM10-20","12p.m.-6p.m.");
            datasource.insertRecord("lunch","Alma Food Court","Low Price","Butterworth","RM5-10","12p.m.-6p.m.");
            datasource.insertRecord("lunch","Kopitan Classic","High Price","Butterworth","RM10-20","12p.m.-6p.m.");
            datasource.insertRecord("dinner","Karpal Sigh Food Court","Low Price","Penang","RM5-10","6p.m.-11p.m.");
            datasource.insertRecord("dinner","Spade Burger","High Price","Penang","RM10-20","6p.m.-11p.m.");
            datasource.insertRecord("dinner","Lau You Food Court","Low Price","Butterworth","RM5-10","6p.m.-11p.m.");
            datasource.insertRecord("dinner","Texas Chicken","High Price","Butterworth","RM10-20","6p.m.-11p.m.");
        }

        final Spinner dropdown = (Spinner) v.findViewById(R.id.spinner5);
        final Spinner dropdown2 = (Spinner) v.findViewById(R.id.spinner6);
        Button search_btn = (Button) v.findViewById(R.id.search_btn);

        String[] items = new String[]{"Select Your Location","Penang","Butterworth"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);


        final List<String> plantsList = new ArrayList<>(Arrays.asList(items));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                getActivity(),R.layout.spinner_item,plantsList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        dropdown.setAdapter(spinnerArrayAdapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                    education_level = dropdown.getSelectedItem().toString();
                }

                Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner5);
                String seat = spinner.getSelectedItem().toString();
                Log.d("vvv","seat2:"+seat);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        String[] items2 = new String[]{"Select Your Price Range","Low Price","High Price"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items2);


        final List<String> plantsList2 = new ArrayList<>(Arrays.asList(items2));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                getActivity(),R.layout.spinner_item,plantsList2){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinner_item);
        dropdown2.setAdapter(spinnerArrayAdapter2);

        dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if(position > 0){
                    // Notify the selected item text
                    education_level = dropdown2.getSelectedItem().toString();
                }

                Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner6);
                String seat = spinner.getSelectedItem().toString();
                Log.d("vvv","seat2:"+seat);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user_name =(EditText) getActivity().findViewById(R.id.user_name);
                Spinner spinner_location = (Spinner) getActivity().findViewById(R.id.spinner5);
                Spinner spinner_price = (Spinner) getActivity().findViewById(R.id.spinner6);

                String name = user_name.getText().toString().trim();
                String location_selected = spinner_location.getSelectedItem().toString();
                String price_range_selected = spinner_price.getSelectedItem().toString();

                Intent mainIntent = new Intent(getActivity(), FoodListActivity.class);
                mainIntent.putExtra("name", name);
                mainIntent.putExtra("location_selected", location_selected);
                mainIntent.putExtra("price_range_selected", price_range_selected);
                mainIntent.putExtra("meal", meal);

                startActivity(mainIntent);
            }
        });

        return v;
    }
}
