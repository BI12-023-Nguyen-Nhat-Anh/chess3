package vn.edu.usth.ldchess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Header_Navbar_Lesson3_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_navbar_lesson3);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager3 = findViewById(R.id.viewPager2);

        tabLayout.addTab(tabLayout.newTab().setText("Lesson"));
        tabLayout.addTab(tabLayout.newTab().setText("Disscustion"));


        FragmentManager fragmentManager = getSupportFragmentManager();
        Adapter3 adapter = new Adapter3(fragmentManager,getLifecycle());
        viewPager3.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager3.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
        viewPager3.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                tabLayout.selectTab(tabLayout.getTabAt(position));

            }
        });
    }
}