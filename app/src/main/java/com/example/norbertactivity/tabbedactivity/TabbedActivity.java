//package com.example.norbertactivity.tabbedactivity;
//
//import android.os.Bundle;
//import com.example.norbertactivity.R;
//import com.example.norbertactivity.adapters.ViewPagerAdapter; // Adjust the package as necessary
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager2.widget.ViewPager2;
//import com.google.android.material.tabs.TabLayout;
//import com.google.android.material.tabs.TabLayoutMediator;
//
//public class TabbedActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tabbed);
//
//        ViewPager2 viewPager = findViewById(R.id.view_pager);
//        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
//        viewPager.setAdapter(adapter);
//
//        TabLayout tabLayout = findViewById(R.id.tab_layout);
//        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
//            switch (position) {
//                case 0:
//                    tab.setText("Fragment 3");
//                    break;
//                case 1:
//                    tab.setText("Fragment 4");
//                    break;
//            }
//        }).attach();
//    }
//}