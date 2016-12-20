package com.example.android.miwok.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.example.android.miwok.R;
import com.example.android.miwok.fragment.ColorFragment;
import com.example.android.miwok.fragment.FamilyFragment;
import com.example.android.miwok.fragment.NumbersFragment;
import com.example.android.miwok.fragment.PharasesFragment;
import com.example.android.miwok.helper.Helper;

/**
 * Created by indraaguslesmana on 12/19/16.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{
    private static final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "Number", "Family", "Color", "Pharases" };
    private Context mContext;

    //define image resource, not used right now
    private int[] imageResId_white = {
//            R.drawable.number_one,
            R.drawable.ic_looks_one_white_18dp,
            R.drawable.ic_looks_two_white_18dp,
            R.drawable.ic_looks_3_white_18dp,
            R.drawable.ic_looks_4_white_18dp
    };

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
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
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        // return tabTitles[position];
        Drawable image = ContextCompat.getDrawable(mContext, imageResId_white[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString("   "+ tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;


//        return tabTitles[position];
    }
}
