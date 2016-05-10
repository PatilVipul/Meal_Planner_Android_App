package com.example.vipul.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//Adding to git


public class Recipepage extends ActionBarActivity {

    DbAdapter dbAdapter;
    private ListView lister;
    private List<recipedata> myRecipes = new ArrayList<recipedata>();
    private int itemClickedPosition;
    private boolean debugger = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipepage);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        openDatabase();
        if (!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.commit();

            insertValues();
        }

        populateListview();
        listenForListClick();

    }

    private void populateListview() {


        lister = (ListView) findViewById(R.id.listView);


        Cursor cursor = dbAdapter.getAllRecipes();
        List<recipedata> array = new ArrayList<recipedata>();

        while (cursor.moveToNext()) {
            //String recipename = cursor.getString(cursor.getColumnIndex("recipe_name"));
            myRecipes.add(new recipedata(cursor.getString(cursor.getColumnIndex("recipe_name")), "Time to Cook : " + cursor.getString(cursor.getColumnIndex("recipe_time")), cursor.getString(cursor.getColumnIndex("recipe_procedure")), Integer.parseInt(cursor.getString(cursor.getColumnIndex("recipe_path"))), " "));
        }

        dbAdapter.close();


        ArrayAdapter<recipedata> adapter = new MyListAdapter();
        lister.setAdapter(adapter);
        //** onclick listener for list view*/



    }


    private void listenForListClick() {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewclicked, int position, long id) {
                itemClickedPosition = position;
                //Only for the last animal alert box should be displayed
                Toast.makeText(Recipepage.this, "Clicked Item" + (position), Toast.LENGTH_SHORT).show();
                LargeDescription();


            }
        });

    }

    private void LargeDescription() {

        recipedata clickedrecipe = myRecipes.get(itemClickedPosition);


        Intent newIntent = new Intent(Recipepage.this, recipedescription.class);
        newIntent.putExtra("formattedRecipe", clickedrecipe);
        newIntent.putExtra("debugger", debugger);

        startActivity(newIntent);


    }

    private void insertValues() {

        Toast.makeText(getApplicationContext(), "Inserting values to db", Toast.LENGTH_SHORT).show();

        //InsertRecipes

        dbAdapter.insertRecipe("Pizza", R.mipmap.burger, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 2);
        dbAdapter.insertRecipe("Bronco burger", R.mipmap.pavbhaji, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 1);
        dbAdapter.insertRecipe("Taco salad", R.mipmap.pizza, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 30);
        dbAdapter.insertRecipe("Noodles", R.mipmap.tacosalad, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 45);
        dbAdapter.insertRecipe("pav bhaji", R.mipmap.pavbhaji, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 50);
        dbAdapter.insertRecipe("Pizza", R.mipmap.pizza, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 2);
        dbAdapter.insertRecipe("Bronco burger", R.mipmap.burger, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 1);
        dbAdapter.insertRecipe("Taco salad", R.mipmap.pizza, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 30);
        dbAdapter.insertRecipe("Noodles", R.mipmap.tacosalad, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 45);
        dbAdapter.insertRecipe("pav bhaji", R.mipmap.pavbhaji, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 50);
        dbAdapter.insertRecipe("Pizza", R.mipmap.pizza, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 2);
        dbAdapter.insertRecipe("Bronco burger", R.mipmap.burger, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 1);
        dbAdapter.insertRecipe("Taco salad", R.mipmap.pizza, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 30);
        dbAdapter.insertRecipe("Noodles", R.mipmap.tacosalad, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 45);
        dbAdapter.insertRecipe("pav bhaji", R.mipmap.pavbhaji, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 50);

        dbAdapter.insertRecipe("Pizza", R.mipmap.pizza, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 2);
        dbAdapter.insertRecipe("Bronco burger", R.mipmap.burger, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 1);
        dbAdapter.insertRecipe("Taco salad", R.mipmap.pizza, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 30);
        dbAdapter.insertRecipe("Noodles", R.mipmap.tacosalad, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 45);
        dbAdapter.insertRecipe("pav bhaji", R.mipmap.pavbhaji, " Put yeast, sugar, salt, and dry milk in a large (2 qt.) bowl. Add water and stir to mix well. Allow to sit for two minutes. Add oil and stir again. Add flour and stir until dough forms and flour is absorbed.", 50);


        //Insert Ingredients
        dbAdapter.insertIngredients("salt", "tablespoon");
        dbAdapter.insertIngredients("Sugar", "tablespoon");
        dbAdapter.insertIngredients("Olive oil", "Tablesppon");
        dbAdapter.insertIngredients("Bread", "slices");
        dbAdapter.insertIngredients("Egg", "number");
        dbAdapter.insertIngredients("Garlic", "number");
        dbAdapter.insertIngredients("cheese", "slice");
        dbAdapter.insertIngredients("onion", "number");

        //Mapping recipes to Ingredients
        dbAdapter.insertRecipe_Ingredients(1, 1);
        dbAdapter.insertRecipe_Ingredients(1, 2);
        dbAdapter.insertRecipe_Ingredients(1, 3);
        dbAdapter.insertRecipe_Ingredients(1, 4);
        dbAdapter.insertRecipe_Ingredients(2, 1);
        dbAdapter.insertRecipe_Ingredients(2, 2);
        dbAdapter.insertRecipe_Ingredients(2, 8);
        dbAdapter.insertRecipe_Ingredients(2, 6);
        dbAdapter.insertRecipe_Ingredients(3, 3);
        dbAdapter.insertRecipe_Ingredients(3, 4);
        dbAdapter.insertRecipe_Ingredients(3, 5);
        dbAdapter.insertRecipe_Ingredients(3, 8);
        dbAdapter.insertRecipe_Ingredients(3, 2);
        dbAdapter.insertRecipe_Ingredients(4, 1);
        dbAdapter.insertRecipe_Ingredients(4, 3);
        dbAdapter.insertRecipe_Ingredients(4, 4);
        dbAdapter.insertRecipe_Ingredients(4, 5);
        dbAdapter.insertRecipe_Ingredients(5, 2);
        dbAdapter.insertRecipe_Ingredients(5, 4);
        dbAdapter.insertRecipe_Ingredients(5, 3);
//        dbAdapter.insertRecipe_Ingredients(5,5);


    }

    private void openDatabase() {


        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipepage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyListAdapter extends ArrayAdapter<recipedata> {

        public MyListAdapter() {
            super(Recipepage.this, R.layout.row_recipe, myRecipes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.row_recipe, parent, false);

            }
            //Find animal
            // fill view
            recipedata currentRecipe = myRecipes.get(position);


            ImageView imageView = (ImageView) (itemView.findViewById(R.id.item_icon));
            imageView.setImageResource(currentRecipe.getIcon());


            TextView recipeNameView = (TextView) (itemView.findViewById(R.id.recipe_title));
            recipeNameView.setText(currentRecipe.getRecipe_name());


            TextView recipecook = (TextView) (itemView.findViewById(R.id.recipecook));
            recipecook.setText(currentRecipe.getTime());

            return itemView;
        }
    }


}




