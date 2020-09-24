//***********************************************************
//  MainActivity.java
//  Tour Guide App
//
//  Dustin Kaban
//  Student ID: T00663749
//  September 22nd, 2020
//
//  This class handles the main functionality of our Tour Guide App
//***********************************************************
package com.example.tourguide;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentLocations.OnFragmentInteractionListener, FragmentInfo.OnFragmentInteractionListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(int position)
    {
        //Logs for seeing how the data is passing between listeners and fragments
        Log.d("TAG", "Main Activity Log ->>> Item " + position + " selected!");

        //We need to access the other fragment to pass it the relevant position
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentInfo fragmentInfo = (FragmentInfo) fragmentManager.findFragmentById(R.id.fragment_info);
        fragmentInfo.updateText(position);
    }
}