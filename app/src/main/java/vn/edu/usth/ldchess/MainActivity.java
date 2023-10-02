package vn.edu.usth.ldchess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

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
                        Home_Explore_Content home = new Home_Explore_Content();
                        FragmentManager fragmentHome = getSupportFragmentManager();
                        fragmentHome.beginTransaction().replace(R.id.main, home, "Home").commit();
                        break;
                    case 1:
                        List_Chess list_chess = new List_Chess();
                        FragmentManager fragmentListChess = getSupportFragmentManager();
                        fragmentListChess.beginTransaction().replace(R.id.main, list_chess, "List chess").commit();
                        break;
                    case 2:
                        List_Lesson list_lesson = new List_Lesson();
                        FragmentManager fragmenListLesson = getSupportFragmentManager();
                        fragmenListLesson.beginTransaction().replace(R.id.main, list_lesson, "List Lesson").commit();
                        break;
                    case 3:
                        HeaderProfileFragment profile = new HeaderProfileFragment();
                        FragmentManager fragmentProfile = getSupportFragmentManager();
                        fragmentProfile.beginTransaction().replace(R.id.main, profile, "Profile").commit();
                        break;
                }

            }
        });
        nav_bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.explore) {
                    viewpager.setCurrentItem(1);
                    return true;
                } else if (itemId == R.id.lesson) {
                    viewpager.setCurrentItem(2);
                    return true;
                }
                else if (itemId == R.id.home) {
                    viewpager.setCurrentItem(0);
                    return true;
                }
                else if (itemId == R.id.profile) {
                    viewpager.setCurrentItem(3);
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
        Log.i(TAG, "onStop: This is a log message.");
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.main);
        if (currentFragment instanceof Home_Explore_Content) {
            Home_Explore_Content home = (Home_Explore_Content) currentFragment;
            home.onBackPressed();
        }
        else if (currentFragment instanceof List_Chess) {
            List_Chess list_chess = (List_Chess) currentFragment;
            list_chess.onBackPressed();
        }
        else if(currentFragment instanceof List_Lesson){
            List_Lesson list_lesson = (List_Lesson) currentFragment;
            list_lesson.onBackPressed();
        }
        else if(currentFragment instanceof HeaderProfileFragment){
            HeaderProfileFragment profile = (HeaderProfileFragment) currentFragment;
            profile.onBackPressed();
        }
        else if(currentFragment instanceof ChessManFragment){
            ChessManFragment ChessMan = (ChessManFragment) currentFragment;
            ChessMan.onBackPressed();
        }
        else if(currentFragment instanceof ContentLesson){
            ContentLesson contentLesson = (ContentLesson) currentFragment;
            contentLesson.onBackPressed();
        }
        else {
            super.onBackPressed();
        }
    }
}