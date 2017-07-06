package com.delta.smt.ui.ManagingBusiness;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delta.smt.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ManagingBusinessFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ManagingBusinessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ManagingBusinessFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_managing_business2, container, false);
    }


}
