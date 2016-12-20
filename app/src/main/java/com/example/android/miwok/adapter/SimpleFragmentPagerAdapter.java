package com.example.android.miwok.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.miwok.fragment.ColorFragment;
import com.example.android.miwok.fragment.FamilyFragment;
import com.example.android.miwok.fragment.NumbersFragment;
import com.example.android.miwok.fragment.PharasesFragment;
import com.example.android.miwok.helper.Helper;

/**
 * Created by indraaguslesmana on 12/19/16.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{


    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Helper.FRAGMENT_NUMBERS:
                return new NumbersFragment();
            case Helper.FRAGMENT_FAMILY_MEMBERS:
                return new FamilyFragment();
            case Helper.FRAGMENT_COLORS:
                return new ColorFragment();
            case Helper.FRAGMENT_PHARASES:
                return new PharasesFragment();
            default:
                return new NumbersFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
