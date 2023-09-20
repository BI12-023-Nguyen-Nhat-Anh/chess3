package vn.edu.usth.ldchess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class castleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castle);

        RelativeLayout next=findViewById(R.id.next);
        RelativeLayout back=findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
//                PawnFragment pawn=new PawnFragment();
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.main, pawn, "Pawn")
//                        .addToBackStack(null).commit();
                Intent intent = new Intent(castleActivity.this, pawnActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
//                BishopFragment bishop=new BishopFragment();
//                FragmentManager fragmentManager= getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.main, bishop, "Bishop")
//                        .addToBackStack(null).commit();
                Intent intent = new Intent(castleActivity.this, bishopActivity.class);
                startActivity(intent);
            }
        });
    }
}