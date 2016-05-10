package com.example.vipul.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<ExpandListGroup>  groups;

    public ExpandListAdapter(Context context, ArrayList<ExpandListGroup> group){
        this.context = context;
        this.groups = group;
    }

    public void addItem(ExpandListChild item, ExpandListGroup group){

        //check if the group exists. If no, add it.
        if(!groups.contains(groups)){
            groups.add(group);
        }

        //extract the index of the group
        int index = groups.indexOf(group);
        ArrayList<ExpandListChild> ch = groups.get(index).getItems();

        //add the child item
        ch.add(item);

        //set the child item to the group
        groups.get(index).setItems(ch);
    }

    public Object getChild(int groupPosition, int childPosition){
        ArrayList<ExpandListChild> ch = groups.get(groupPosition).getItems();
        return ch.get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition){
        return childPosition;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view,ViewGroup parent){
        ExpandListChild child = (ExpandListChild) getChild(groupPosition, childPosition);
        if(view == null){
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.expandlist_child_item, null);
        }
        TextView description = (TextView) view.findViewById(R.id.description);
        description.setText(child.getDescription().toString());
        description.setTag(child.getTag());

        TextView name= (TextView) view.findViewById(R.id.name);
        name.setText(child.getName().toString());
        name.setTag(child.getTag());

        ImageView image = (ImageView) view.findViewById(R.id.food_image);
        image.setImageResource(child.getIcon());
        return view;
    }

    public int getChildrenCount(int groupPosition) {
        ArrayList<ExpandListChild> chList = groups.get(groupPosition).getItems();
        return chList.size();
    }

    public Object getGroup(int groupPosition){
        return groups.get(groupPosition);
    }

    public int getGroupCount(){
        return groups.size();
    }

    public long getGroupId(int groupPosition){
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup parent) {
        ExpandListGroup group = (ExpandListGroup) getGroup(groupPosition);
        if(view == null){
            LayoutInflater inf = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.expandlist_group_item, null);
        }
        TextView tv = (TextView) view.findViewById(R.id.tvGroup);
        tv.setText(group.getName());
        // TODO Auto-generated method stub
        return view;
    }

    public boolean hasStableIds() {
        return true;
    }
    public boolean isChildSelectable(int arg0, int arg1){
        return true;
    }
  }
