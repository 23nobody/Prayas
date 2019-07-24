package android.example.com.prayas;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

class SimpleFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext=context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Set1();
        } else if (position == 1){
            return new Set2();
        }
        else{
            return new Set3();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Set-1";
        } else if (position == 1) {
            return "Set-2";
        }
         else {
            return "Set-3";
        }



    }
}
