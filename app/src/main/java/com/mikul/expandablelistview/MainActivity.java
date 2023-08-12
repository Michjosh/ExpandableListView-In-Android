package com.mikul.expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> continents;
    private HashMap<String, List<String>> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListView);

        prepareData();

        adapter = new ExpandableListAdapter(this, continents, countries);
        expandableListView.setAdapter(adapter);
    }

    private void prepareData() {
        continents = new ArrayList<>();
        continents.add(getString(R.string.africa));
        continents.add(getString(R.string.asia));
        continents.add(getString(R.string.europe));
        continents.add(getString(R.string.north_america));
        continents.add(getString(R.string.south_america));

        countries = new HashMap<>();
        countries.put(continents.get(0), getCountriesArray(R.array.africa_countries));
        countries.put(continents.get(1), getCountriesArray(R.array.asia_countries));
        countries.put(continents.get(2), getCountriesArray(R.array.europe_countries));
        countries.put(continents.get(3), getCountriesArray(R.array.north_america_countries));
        countries.put(continents.get(4), getCountriesArray(R.array.south_america_countries));
    }

    private List<String> getCountriesArray(int arrayResourceId) {
        String[] countriesArray = getResources().getStringArray(arrayResourceId);
        List<String> countriesList = new ArrayList<>();
        for (String country : countriesArray) {
            countriesList.add(country);
        }
        return countriesList;
    }
}
