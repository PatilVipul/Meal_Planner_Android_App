package com.example.vipul.project;

import java.util.ArrayList;


public class ExpandListGroup {
    private String name;
    private ArrayList<ExpandListChild> Items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ExpandListChild> getItems() {
        return Items;
    }

    public void setItems(ArrayList<ExpandListChild> items) {
        Items = items;
    }
}
