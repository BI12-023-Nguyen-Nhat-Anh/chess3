//package vn.edu.usth.ldchess;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager2.widget.ViewPager2;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.util.Log;
//
//public class Logo_theme extends AppCompatActivity {
//    ViewPager2 viewpager ;
//    private static final String TAG="Theme Activity";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_logo_theme);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(Logo_theme.this, MainActivity.class));
//                finish();
//            }
//        }, 3000);
//    }
//}