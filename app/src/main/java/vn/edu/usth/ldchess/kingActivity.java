package vn.edu.usth.ldchess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class kingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_king);

        RelativeLayout next=findViewById(R.id.next);
        RelativeLayout back=findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                QueenFragment queen=new QueenFragment();
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.main, queen, "queen")
//                        .addToBackStack(null).commit();
                Intent intent = new Intent(kingActivity.this, queenActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                KnightFragment knight=new KnightFragment();
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                fragmentManager.popBackStackImmediate();
//                fragmentManager.beginTransaction().replace(R.id.main, knight, "knight")
//                        .addToBackStack(null).commit();
                Intent intent = new Intent(kingActivity.this, knightActivity.class);
                startActivity(intent);

            }
        });
    }
}