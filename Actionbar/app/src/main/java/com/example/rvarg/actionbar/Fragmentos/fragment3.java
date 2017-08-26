package com.example.rvarg.actionbar.Fragmentos;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.rvarg.actionbar.R;

public class fragment3 extends Fragment {
    TextView text1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3,container, false);
    }

   /* @Override
    public void onActivityCreated(Bundle savedInstanceState) {

    }
    public void onSelected(boolean selected){
        text1=getView().findViewById(R.id.textview1);
    }*/

}
