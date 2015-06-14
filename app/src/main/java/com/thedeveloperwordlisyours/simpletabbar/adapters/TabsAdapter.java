package com.thedeveloperwordlisyours.simpletabbar.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.thedeveloperwordlisyours.simpletabbar.fragments.FirstTabFragment;
import com.thedeveloperwordlisyours.simpletabbar.fragments.SecondTabFragment;
import com.thedeveloperwordlisyours.simpletabbar.utils.Constants;

/**
 * Created by javiergonzalezcabezas on 14/6/15.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {

    private int mType;

    public TabsAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return new FirstTabFragment();

            case 1:
                return new SecondTabFragment();
        }

        return null;
    }



    @Override
    public int getItemPosition(Object object) {

        //don't return POSITION_NONE, avoid fragment recreation.
        return super.getItemPosition(object);
    }


    @Override
    public int getCount() {
        return Constants.TOTAL_TABS;
    }

}
