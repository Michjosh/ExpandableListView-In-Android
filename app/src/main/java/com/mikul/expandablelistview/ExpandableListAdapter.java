package com.mikul.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private final List<String> continents;
    private final HashMap<String, List<String>> countries;

    public ExpandableListAdapter(Context context, List<String> continents, HashMap<String, List<String>> countries) {
        this.context = context;
        this.continents = continents;
        this.countries = countries;
    }

    @Override
    public int getGroupCount() {
        return continents.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return countries.get(continents.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return continents.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return countries.get(continents.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String continent = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }
        TextView continentTextView = convertView.findViewById(R.id.continentName);
        continentTextView.setText(continent);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String country = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        TextView countryTextView = convertView.findViewById(R.id.countryName);
        countryTextView.setText(country);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
