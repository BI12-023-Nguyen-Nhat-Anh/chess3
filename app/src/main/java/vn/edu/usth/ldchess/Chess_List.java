package vn.edu.usth.ldchess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Chess_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chess_list);
        ImageView pawnbtn = findViewById(R.id.pawnbutton);
        ImageView knightbtn = findViewById(R.id.knightbutton);
        ImageView bishopbtn = findViewById(R.id.bishopbutton);
        ImageView rookbtn = findViewById(R.id.rookbutton);
        ImageView queenbtn = findViewById(R.id.queenbutton);
        ImageView kingbtn = findViewById(R.id.kingbutton);
        pawnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chess_List.this, pawnActivity.class);
                startActivity(intent);

            }
        });
        knightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chess_List.this, knightActivity.class);
                startActivity(intent);

            }
        });
        bishopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chess_List.this, bishopActivity.class);
                startActivity(intent);

            }
        });
        rookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chess_List.this, castleActivity.class);
                startActivity(intent);

            }
        });
        queenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chess_List.this, queenActivity.class);
                startActivity(intent);

            }
        });
        kingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chess_List.this, kingActivity.class);
                startActivity(intent);

            }
        });

    }
}