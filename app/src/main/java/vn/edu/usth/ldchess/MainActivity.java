package vn.edu.usth.ldchess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import vn.edu.usth.ldchess.Adapter.AdapterView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="Main Activity";
    ViewPager2 viewpager ;
    AdapterView adapterView;
    BottomNavigationView nav_bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: Sucess");

        viewpager = findViewById(R.id.viewpager);
        nav_bottom = findViewById(R.id.nav_bottom);

        adapterView = new AdapterView(this);
        viewpager.setAdapter(adapterView);
        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        nav_bottom.setSelectedItemId(R.id.home);
                        break;
                    case 1:
                        nav_bottom.setSelectedItemId(R.id.lesson);
                        break;
                    case 2:
                        nav_bottom.setSelectedItemId(R.id.profile);
                        break;
                }
                super.onPageSelected(position);
            }
        });
        nav_bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();//                    case R.id.home_nav:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.home_nav);
//                        break;
                if (itemId == R.id.lesson) {
                    viewpager.setCurrentItem(1);
                    return true;
                } else if (itemId == R.id.profile) {
                    viewpager.setCurrentItem(2);
                    return true;
                }
                else if (itemId == R.id.home) {
                    viewpager.setCurrentItem(0);
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: This is a log message.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: This is a log message.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: This is a log message.");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: This is a log message.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStart: This is a log message.");
    }
}