package vn.edu.usth.ldchess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationBarView;

import vn.edu.usth.ldchess.Adapter.AdapterView;

public class Homepage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        String[] name = {"cautraicuong","Nanhmuaxuan","Cl0wnLord","StupidDdog","tibeo07"};
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        MaterialButton btn = findViewById(R.id.btn);
        TextView forgot = findViewById(R.id.forgot_password);

        String ExitString = "";
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userinput = username.getText().toString();
                String result = ExitString+userinput;
                ShareData shareData = ShareData.getInstance();
                shareData.setSharedString(result);
                for(int i = 0; i< name.length; i++){
                    if(username.getText().toString().equals(name[i]) &&  password.getText().toString().equals("admin") ){

                        Intent intent = new Intent(Homepage.this, MainActivity.class);
                        startActivity(intent);
                    }


                }

            }
        });

    }


}