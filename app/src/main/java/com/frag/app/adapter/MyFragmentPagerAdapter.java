package com.frag.app.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YangBin on 2016/10/13.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[];
    private List<Fragment> fragmentList;

    public MyFragmentPagerAdapter(FragmentManager fm, String tabTitles[], List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
