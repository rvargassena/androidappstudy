package com.example.rvarg.actionbar.Galeria;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rvarg.actionbar.R;

/**
 * Created by rvarg on 01/09/2017.
 */

public class ComidasPrincipal extends AppCompatActivity {
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mViewPager=(ViewPager) findViewById(R.id.pager);
        setUpViewPager(mViewPager);
        TabLayout pestana=(TabLayout) findViewById(R.id.Tabs);
        pestana.setupWithViewPager(mViewPager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar Volver=getSupportActionBar();
        Volver.setDisplayHomeAsUpEnabled(true);
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter= new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(Fragmentgrid.newInstance(1),"Desayunos");
        adapter.addFragment(Fragmentgrid.newInstance(2),"Almuerzos");
        adapter.addFragment(Fragmentgrid.newInstance(3),"Postres");
        adapter.addFragment(Fragmentgrid.newInstance(4),"Ensaladas");
        viewPager.setAdapter(adapter);
    }


}
