//***********************************************************
//  FragmentLocations.java
//  Tour Guide App
//
//  Dustin Kaban
//  Student ID: T00663749
//  September 23rd, 2020
//
//  This class handles the location functionality via a Fragment
//***********************************************************
package com.example.tourguide;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentLocations extends Fragment
{
    ArrayAdapter<String> adapter;
    String[] data;
    private OnFragmentInteractionListener mListener;

    public FragmentLocations()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_locations,container,false);//view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        //Populate the Array using the locations array created in the strings.xml file
        Resources res = getResources();
        //We populate the array with the locations array determined in strings.xml
        data = res.getStringArray(R.array.locations);

        //We need to obtain the list view to populate it with data
        ListView listView = (ListView) getActivity().findViewById(R.id.idListView);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "Fragment Log ->>> Item " + position + " selected!");
                if(mListener != null)
                {
                    mListener.onFragmentInteraction(position);
                }
            }
        });
    }

    public interface OnFragmentInteractionListener
    {
        void onFragmentInteraction(int position);
    }
}