package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //RootView has been created.
            //Populating the fragment with some dummy data's.

            //Creating dummy datas for the list view.
            //Format of data is- "Day - Weather - MaxTemp/MinTemp".
            String[] forecastArray={
                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/43",
                    "Wed - Fucked - 90/70",
                    "Thurs - Squirt - 45/23",
                    "Fri - Badass - 76/53",
                    "Sat - Wet - 57/35",
                    "Sun - OhYeah - 50/40"
            };
            //Changing list into an ArrayList.
            List<String> weekForecast= new ArrayList<String>(
                    Arrays.asList(forecastArray));

            //Initializing the Adapter.
            //The List will access the Adapter which will provide it with the data.
            //Adapter knows how to manage. It is programmed as such.
            //Syntax: ArrayAdapter<String>.
            //Parameters: Context, ID of List Item Layout, ID of TextView, list of data.
            mForecastAdapter = new ArrayAdapter<String>(
                    //Context(Parents Fragment Activity.
                    getActivity(),
                    //ID of the List Item Layout.
                    R.layout.list_item_forecast,
                    //ID of the TextView in Layout.
                    R.id.list_item_forecast_textview,
                    //List of Forecast Data.
                    weekForecast);

            //Get reference to to the ListView, and attach this adapter to Forecast Adapter.
            ListView listView=(ListView) rootView.findViewById(R.id.listView_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
