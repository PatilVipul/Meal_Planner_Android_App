package com.example.vipul.project;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class recipedescription extends ActionBarActivity {


    TextView recipe_name;
    TextView recipe_procedure;
    ImageView imageView;


    recipedata Currentrecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipedescription);
        Currentrecipe = (recipedata) getIntent().getSerializableExtra("formattedRecipe");
        recipe_name = (TextView) findViewById(R.id.rname);
        recipe_procedure = (TextView) findViewById(R.id.procedure);
        imageView = (ImageView) findViewById(R.id.imageView);


//        animalName.setText(currentAnimal.getAnimal_name());
//        animalImage.setImageResource(currentAnimal.getLarge_display_id());
//        animalLargeDesp.setText(currentAnimal.getAnimal_large_desp());


        recipe_name.setText(Currentrecipe.getRecipe_name());
        recipe_procedure.setText(Currentrecipe.getProcedure());
        imageView.setImageResource(Currentrecipe.getIcon());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recipedescription, menu);
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
}
