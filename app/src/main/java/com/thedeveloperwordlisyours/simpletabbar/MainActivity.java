package com.thedeveloperwordlisyours.simpletabbar;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.thedeveloperwordlisyours.simpletabbar.adapters.TabsAdapter;
import com.thedeveloperwordlisyours.simpletabbar.utils.Constants;


public class MainActivity extends ActionBarActivity implements  android.support.v7.app.ActionBar.TabListener {

    private ViewPager tabsviewPager;
    private ActionBar mActionBar;
    private TabsAdapter mTabsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createTabBar();
    }


    public void createTabBar(){
        tabsviewPager = (ViewPager) findViewById(R.id.tabspager);

        mTabsAdapter = new TabsAdapter(getSupportFragmentManager());

        tabsviewPager.setAdapter(mTabsAdapter);

        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab gridTab = getSupportActionBar().newTab().setText(R.string.first_title).setTabListener(this);
        ActionBar.Tab listTab = getSupportActionBar().newTab().setText(R.string.second_title).setTabListener(this);

        getSupportActionBar().addTab(gridTab);
        getSupportActionBar().addTab(listTab);

        //This helps in providing swiping effect for v7 compat library
        tabsviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onTabReselected(ActionBar.Tab arg0, FragmentTransaction arg1) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab selectedtab, FragmentTransaction arg1) {
        tabsviewPager.setCurrentItem(selectedtab.getPosition()); //update tab position on tap
    }

    @Override
    public void onTabUnselected(ActionBar.Tab arg0, FragmentTransaction arg1) {

    }



}

