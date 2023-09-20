package vn.edu.usth.ldchess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class queenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queen);

        RelativeLayout next=findViewById(R.id.next);
        RelativeLayout back=findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                BishopFragment bishop=new BishopFragment();
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.main, bishop, "bishop")
//                        .addToBackStack(null).commit();
                Intent intent = new Intent(queenActivity.this, bishopActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                KingFragment king=new KingFragment();
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.main, king, "king")
//                        .addToBackStack(null).commit();
                Intent intent = new Intent(queenActivity.this, kingActivity.class);
                startActivity(intent);
            }
        });
    }
}