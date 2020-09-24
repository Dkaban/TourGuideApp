//***********************************************************
//  FragmentInfo.java
//  Tour Guide App
//
//  Dustin Kaban
//  September 23rd, 2020
//
//  This class handles the location information functionality via a Fragment
//***********************************************************
package com.example.tourguide;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentInfo extends Fragment
{
    private TextView frag_locationInformationText;
    private OnFragmentInteractionListener mListener;

    //The array to hold all of the information, to display to the user
    String[] data;

    public FragmentInfo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //We need to access strings.xml to get the array for info
        Resources res = getResources();
        //We then populate the data array with the info strings
        data = res.getStringArray(R.array.info);
        frag_locationInformationText = (TextView) getActivity().findViewById(R.id.textView_locationInformation);
    }

    public void updateText(int position)
    {
        //We pass the position, using it as in index in our data array
        frag_locationInformationText.setText(data[position]);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentInfo.OnFragmentInteractionListener)
        {
            mListener = (FragmentInfo.OnFragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener
    {
        void onFragmentInteraction(int position);
    }
}
