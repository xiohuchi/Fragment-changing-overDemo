package com.frag.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frag.app.Constant;
import com.frag.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragDemo extends Fragment {

    @BindView(R.id.textView)
    TextView textView;

    public static FragDemo newInstance(String argString) {
        Bundle args = new Bundle();
        args.putString(Constant.ARGS_COUNTTIMES, argString);
        FragDemo fragment = new FragDemo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_demo, container, false);
        ButterKnife.bind(this, view);
        String argString = getArguments().getString(Constant.ARGS_COUNTTIMES); if (argString != null)
        textView.setText(argString);
        return view;
    }
}
