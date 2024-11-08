package com.example.norbertactivity.adapters;

import com.example.norbertactivity.Fragment3;
import com.example.norbertactivity.Fragment4;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

    public class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new Fragment3();
                case 1:
                    return new Fragment4();
                default:
                    return new Fragment3();
            }
        }

        @Override
        public int getItemCount() {
            return 2; // Number of fragments
        }
    }

