package com.example.rvarg.actionbar.Galeria;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rvarg.actionbar.ListFragments.ListaProductosActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rvarg on 02/09/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private  final List<Fragment> mFragments=new ArrayList<>();
    private List<String> mFragmentsTitles=new ArrayList<>();
    public  SectionsPagerAdapter(FragmentManager fm){super(fm);}
    @Override
    public Fragment getItem(int position){
        return mFragments.get(position);
    }
    @Override
    public int getCount(){
        return mFragments.size();
    }

    public  void addFragment(Fragment fragment, String title){
        mFragments.add(fragment);
        mFragmentsTitles.add(title);
    }
    public CharSequence getPageTitle(int position){
        return mFragmentsTitles.get(position);
    }
}
