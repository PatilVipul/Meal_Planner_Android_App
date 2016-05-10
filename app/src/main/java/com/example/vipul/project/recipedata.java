package com.example.vipul.project;

import java.io.Serializable;

public class recipedata implements Serializable {

    private String recipe_name;
    private String time;
    private String procedure;
    private int icon;
    private String ingredients;


    public recipedata(String recipe_name, String time, String procedure, int icon, String ingredients) {
        this.recipe_name = recipe_name;
        this.time = time;
        this.procedure = procedure;
        this.icon = icon;
        this.ingredients = ingredients;
    }


    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
