package com.frag.app.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frag.app.Constant;
import com.frag.app.R;
import com.frag.app.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FrgTab extends Fragment {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    public static FrgTab newInstance(String argString) {
        Bundle args = new Bundle();
        args.putString(Constant.ARGS_COUNTTIMES, argString);
        FrgTab fragment = new FrgTab();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tab, container, false);
        ButterKnife.bind(this, view);
        initTabLayout();
        return view;
    }

    private void initTabLayout() {
        String tabTitles[] = new String[]{"tab1", "tab2", "tab3"};
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(FragDemo.newInstance("这是tab1"));
        fragmentList.add(FragDemo.newInstance("这是tab2"));
        fragmentList.add(FragDemo.newInstance("这是tab3"));
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getFragmentManager(), tabTitles, fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
//        //1.MODE_SCROLLABLE模式
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //2.MODE_FIXED模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

}
