package com.example.vipul.project;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FrontPage extends ActionBarActivity implements AdapterView.OnItemClickListener {

    Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView listview;
    private ExpandListAdapter ExpAdapter;
    private ArrayList<ExpandListGroup> ExpListItems;
    private ExpandableListView ExpandList;
    private String[] mDrawerTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private List<ObjectDrawerItem> myDrawer = new ArrayList<ObjectDrawerItem>();

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);


        populateADrawer();


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        mDrawerTitles = getResources().getStringArray(R.array.drawer_items);
        mDrawerList = (ListView) findViewById(R.id.drawerList);
//        mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDrawerTitles));
        ArrayAdapter<ObjectDrawerItem> adapter = new MyListAdapter();
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        //toolbar = (Toolbar) findViewById(R.id.tool_bar);


//        ArrayAdapter<ObjectDrawerItem> adapter = new MyListAdapter();
//        ListView list = (ListView) findViewById(R.id.drawerList);
//        list.setAdapter(adapter);

        ExpandList = (ExpandableListView) findViewById(R.id.ExpList);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(FrontPage.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "Child:" + childPosition, Toast.LENGTH_LONG).show();
                if (groupPosition == 0) {
                    if (childPosition == 0) {
                        Intent i = new Intent(getApplicationContext(), LoginSignupActivity.class);
                        startActivity(i);
                    }
                    Toast.makeText(getApplicationContext(), "Group: " + groupPosition, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Child: " + childPosition, Toast.LENGTH_LONG).show();


                }
                return true;
            }

        });


//        int[
//
// ] icon;
//        icon = new int[]{R.mipmap.ic_three, R.mipmap.ic_launcher, R.mipmap.ic_four
//                , R.mipmap.ic_three, R.mipmap.ic_launcher};


        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,
                toolbar,/* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {

            /**
             * Called when a drawer has settled in a completely closed state.
             */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);


            }

            /**
             * Called when a drawer has settled in a completely open state.
             */
            public void onDrawerOpened(View drawerView) {
                String mTitle = getResources().getString(R.string.mTitle);
                super.onDrawerOpened(drawerView);

            }


        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    private void populateADrawer() {

        drawerItemGenerator gsanimal = new drawerItemGenerator();
        myDrawer = gsanimal.drawerItemGenerator();

    }

    private void selectItem(int position) {
        //Add code here if clicked on planner
        if (position == 0) {
            //joj
            Toast.makeText(this, " clicked on planner ", Toast.LENGTH_SHORT).show();
            //Call the method, actions to take place when clicked on planner
        }
        //add code if clicked on Recipes
        else if (position == 1) {
            Toast.makeText(this, "clicked on recipes", Toast.LENGTH_SHORT).show();
            //Call the method, actions to take place when clicked on recipes
            Intent intent = new Intent(FrontPage.this, Recipepage.class);
            startActivity(intent);

        } else if (position == 2) {

            Toast.makeText(this, "clicked on Grocery", Toast.LENGTH_SHORT).show();
            //Call the method, actions to take place when clicked on grocery
        } else if (position == 3)

        {
            Toast.makeText(this, "clicked on groups", Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<ExpandListGroup> SetStandardGroups() {
        ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
        ArrayList<ExpandListChild> list2 = new ArrayList<ExpandListChild>();
        ArrayList<ExpandListChild> list3 = new ArrayList<ExpandListChild>();
        ArrayList<ExpandListChild> list4 = new ArrayList<ExpandListChild>();
        ArrayList<ExpandListChild> list5 = new ArrayList<ExpandListChild>();
        ArrayList<ExpandListChild> list6 = new ArrayList<ExpandListChild>();
        ArrayList<ExpandListChild> list7 = new ArrayList<ExpandListChild>();
        ArrayList<ExpandListChild> list8 = new ArrayList<ExpandListChild>();


        DbAdapter dbAdapter;



        // Group1 ,contains food item "PAVBHAJi " & "DOsa"
        ExpandListGroup gru1 = new ExpandListGroup();
        gru1.setName("Monday");
        ExpandListChild ch1_1 = new ExpandListChild();
        ch1_1.setName("Pav Bhaji");
        ch1_1.setIcon(R.drawable.pb);
        ch1_1.setDescription("This is pav bhaji");
        ch1_1.setTag(null);
        list2.add(ch1_1);

        ExpandListChild ch1_2 = new ExpandListChild();
        ch1_2.setName("Dosa");
        ch1_2.setIcon(R.drawable.dsa);
        ch1_2.setDescription("This is Dosa");
        ch1_2.setTag(null);
        list2.add(ch1_2);
        gru1.setItems(list2);

        ExpandListGroup gru2 = new ExpandListGroup();
        gru2.setName("Tuesday");
        ExpandListChild ch2_1 = new ExpandListChild();
        ch2_1.setName("Idly");
        ch2_1.setIcon(R.drawable.idli);
        ch2_1.setDescription("This is Idly");
        ch2_1.setTag(null);
        list3.add(ch2_1);

        ExpandListChild ch2_2 = new ExpandListChild();
        ch2_2.setName("Kachhi Dabeli");
        ch2_2.setIcon(R.drawable.vipul);
        ch2_2.setDescription("This is Kachhi Dabeli");
        ch2_2.setTag(null);
        list3.add(ch2_2);
        gru2.setItems(list3);

        ExpandListGroup gru3 = new ExpandListGroup();
        gru3.setName("Wednesday");
        ExpandListChild ch3_2 = new ExpandListChild();
        ch3_2.setName("Pani Puru");
        ch3_2.setIcon(R.drawable.pp);
        ch3_2.setDescription("This is Pani Puri");
        ch3_2.setTag(null);
        list4.add(ch3_2);
        gru3.setItems(list4);

        ExpandListGroup gru4 = new ExpandListGroup();
        gru4.setName("Thursday");
        ExpandListChild ch4_1 = new ExpandListChild();
        ch4_1.setName("SEV BATATA DAHI PURI ");
        ch4_1.setIcon(R.drawable.pp);
        ch4_1.setDescription("This is SBDP");
        ch4_1.setTag(null);
        list5.add(ch4_1);
        gru4.setItems(list5);


        ExpandListGroup gru5 = new ExpandListGroup();
        gru5.setName("Friday");
        ExpandListChild ch5_1 = new ExpandListChild();
        ch5_1.setName("Chole ");
        ch5_1.setIcon(R.drawable.chole);
        ch5_1.setDescription("");
        ch5_1.setTag(null);
        list6.add(ch5_1);
        gru5.setItems(list6);


        ExpandListGroup gru6 = new ExpandListGroup();
        gru6.setName("Saturday ");
        ExpandListChild ch6_1 = new ExpandListChild();
        ch6_1.setName("Dhokla ");
        ch6_1.setIcon(R.drawable.dkla);
        ch6_1.setDescription("");
        ch6_1.setTag(null);
        list7.add(ch6_1);
        gru6.setItems(list7);

        /*ExpandListGroup gru7 = new ExpandListGroup();
        gru6.setName("Sunday ");
        ExpandListChild ch7_1 = new ExpandListChild();
        ch6_1.setName("Dhokla ");
        ch6_1.setIcon(R.drawable.dhokla);
        ch6_1.setDescription("");
        ch6_1.setTag(null);
        list8.add(ch6_1);
        gru7.setItems(list8);*/

        list.add(gru1);
        list.add(gru2);
        list.add(gru3);
        list.add(gru4);
        list.add(gru5);
        list.add(gru6);
        //list.add(gru7);

        return list;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //   Toast.makeText(this,side_menu[position] + " was selected",Toast.LENGTH_SHORT).show();
        selectItem(position);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }


    }


    private class MyListAdapter extends ArrayAdapter<ObjectDrawerItem> {
        public MyListAdapter() {

            super(FrontPage.this, R.layout.navigationdrawer, myDrawer);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.navigationdrawer, parent, false);

            }
            //Find animal
            // fill view
            ObjectDrawerItem drawerItem = myDrawer.get(position);


            ImageView imageView = (ImageView) (itemView.findViewById(R.id.drawericon));
            imageView.setImageResource(drawerItem.getIcon());


            TextView recipeNameView = (TextView) (itemView.findViewById(R.id.drawertitle));
            recipeNameView.setText(drawerItem.getName());


            return itemView;
        }

    }


}
