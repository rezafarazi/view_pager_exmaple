package com.sorapp.view_pager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{

    //Main Function Start
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetComponenst();
    }
    //Main Function End

    //Get Initialize Function Start
    public void GetComponenst()
    {
        TabLayout tab=(TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);

        tab.addTab(tab.newTab().setText("one"));
        tab.addTab(tab.newTab().setText("Two"));

        Adap s=new Adap(getSupportFragmentManager(),tab.getTabCount());
        viewPager.setAdapter(s);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    //Get Initialize Function End



    //TabView Adaptor
    class Adap extends FragmentPagerAdapter
    {

        private int count;

        public Adap(FragmentManager fm,int count)
        {
            super(fm);
            this.count=count;
        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            if(position==0)
            {
                fragment_one f1 = new fragment_one();
                return f1;
            }
            else if(position==1)
            {
                fragment_two f2=new fragment_two();
                return f2;
            }
            else
            {
                return null;
            }
        }

        @Override
        public int getCount()
        {
            return this.count;
        }
    }


}