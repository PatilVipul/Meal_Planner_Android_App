package com.example.vipul.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbAdapter {

    public static final String DATABASE_NAME = "meal_planer";
    public static final int DATABASE_VERSION = '9';
    public static final String TAG = "DBAdapter";


    public static final String RECIPE_TABLE = "recipe";
    public static final String INGREDIENT_TABLE = "ingredient";
    public static final String RECIPE_INGREDIENT = "recipe_ingredient";

    public static final String RECIPE_ID = "recipe_id";
    public static final String RECIPE_NAME = "recipe_name";
    public static final String RECIPE_IMAGE_PATH = " recipe_path";
    public static final String RECIPE_PROCEDURE = "recipe_procedure";
    public static final String RECIPE_TIME = "recipe_time";


    public static final String INGREDIENT_ID = "ingredient_id";
    public static final String INGREDIENT_NAME = "ingredient_name";
    public static final String INGREDIENT_UNIT = "ingredient_unit";


    public static final String CREATE_RECIPE_TABLE = "create table recipe (recipe_id integer not null primary key autoincrement unique, " + "recipe_name text not null,recipe_path integer not null,recipe_procedure text not null,recipe_time text not null);";
    public static final String CREATE_INGREDIENT_TABLE = "create table ingredient (ingredient_id integer not null primary key autoincrement unique, " + "ingredient_name text not null, ingredient_unit text not null);";
    public static final String CREATE_RECIPE_INGREDIENT_TABLE = "create table recipe_ingredient (recipe_id integer not null , ingredient_id integer not null);";


    Context context;


    DatabaseHelper DBHelper;
    SQLiteDatabase db;


    public DbAdapter(Context ctx) {

        {
            this.context = ctx;
            DBHelper = new DatabaseHelper(context);
        }
    }

    //To open database
    public DbAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //To close database
    public void close() {
        DBHelper.close();
    }

    public long insertRecipe(String recipe_name, int recipe_image_path, String recipe_procedure, int time) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(RECIPE_NAME, recipe_name);
        initialValues.put(RECIPE_IMAGE_PATH, recipe_image_path);
        initialValues.put(RECIPE_PROCEDURE, recipe_procedure);
        initialValues.put(RECIPE_TIME, time);
        long r = db.insert(RECIPE_TABLE, null, initialValues);

        return r;


    }


    public long insertIngredients(String ingredient_name, String ingredient_value)

    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(INGREDIENT_NAME, ingredient_name);
        initialValues.put(INGREDIENT_UNIT, ingredient_value);
        long r = db.insert(INGREDIENT_TABLE, null, initialValues);
        return r;

    }

    public long insertRecipe_Ingredients(int recipe_id, int ingredient_id) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(RECIPE_ID, recipe_id);
        initialValues.put(INGREDIENT_ID, ingredient_id);
        long r = db.insert(RECIPE_INGREDIENT, null, initialValues);
        return r;

    }


    public Cursor getAllRecipes() {
        return db.query(RECIPE_TABLE, new String[]{RECIPE_ID, RECIPE_NAME, RECIPE_IMAGE_PATH, RECIPE_PROCEDURE, RECIPE_TIME}, null, null, null, null, null);
    }

    public Cursor getRecipe(long rowID) throws SQLException {
        Cursor mCursor = db.query(true, RECIPE_TABLE, new String[]{RECIPE_ID, RECIPE_NAME, RECIPE_IMAGE_PATH, RECIPE_PROCEDURE, RECIPE_TIME}, RECIPE_ID + "=" + rowID, null, null, null, null, null);

        if (mCursor != null) {

            mCursor.moveToFirst();
        }
        return mCursor;
    }


//    Select I.ingredient_name,I.ingredient_unit,RI.amount
//    from Ingredient I, Recipe_ingredient RI
//    where recipe_id IN (SELECT recipe_id from Recipe where recipe_name="pizza") AND RI.Ingredient_id=I.ingredient_id;

//    public Cursor getIngredients(String recipename)
//    {
//        db.rawQuery("Select" +   + )
//
//
//    }


    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        private DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_RECIPE_TABLE);
                db.execSQL(CREATE_INGREDIENT_TABLE);
                db.execSQL(CREATE_RECIPE_INGREDIENT_TABLE);


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "UPGRADING database from version" + oldVersion + " to " + newVersion + ",which will destroy old data ");
            db.execSQL("DROP TABLE IF EXISTS notes");
            onCreate(db);

        }


    }


}







