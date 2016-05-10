package com.example.vipul.project;

import android.widget.Button;


public class ExpandListChild {


    private String tag;
    private int icon;
    private String name;
    private String description;
    private Button tick;
    private Button add;


    public ExpandListChild(){

        super();
    }

    public ExpandListChild(int icon, String name, String description){

        this.icon = icon;
        this.name = name;
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Button getTick() {
        return tick;
    }

    public void setTick(Button tick) {
        this.tick = tick;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
