package com.example.vipul.project;

public class ObjectDrawerItem {

    public int icon;
    public String name;

    // Constructor.
    public ObjectDrawerItem(int icon, String name) {

        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
