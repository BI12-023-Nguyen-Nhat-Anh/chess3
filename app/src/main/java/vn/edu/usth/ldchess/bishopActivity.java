package vn.edu.usth.ldchess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class bishopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bishop);

        RelativeLayout next=findViewById(R.id.next);
        RelativeLayout back=findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                CastleFragment rock=new CastleFragment();
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.main, rock, "Rock")
//                        .addToBackStack(null).commit();
                Intent intent = new Intent(bishopActivity.this, castleActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                QueenFragment queen = new QueenFragment();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.main, queen, "Queen")
//                        .addToBackStack(null).commit();
                Intent intent = new Intent(bishopActivity.this, queenActivity.class);
                startActivity(intent);
            }
        });
    }
}