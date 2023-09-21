package vn.edu.usth.ldchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);

        ImageView history = findViewById(R.id.history);
        ImageView lesson_one = findViewById(R.id.lesson_one);
        ImageView lesson_two = findViewById(R.id.lesson_two);
        ImageView lesson_three = findViewById(R.id.lesson_three);
        ImageView lesson_four = findViewById(R.id.lesson_four);
        ImageView lesson_five = findViewById(R.id.lesson_five);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson_List.this, Header_Navbar_Lesson1_Activity.class);
                startActivity(intent);
            }
        });
        lesson_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson_List.this, Header_Navbar_Lesson2_Activity.class);
                startActivity(intent);
            }
        });
        lesson_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson_List.this, Header_Navbar_Lesson3_Activity.class);
                startActivity(intent);
            }
        });
        lesson_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson_List.this, Header_Navbar_Lesson4_Activity.class);
                startActivity(intent);
            }
        });
        lesson_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson_List.this, Header_Navbar_Lesson5_Activity.class);
                startActivity(intent);
            }
        });
        lesson_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson_List.this, Header_Navbar_Lesson6_Activity.class);
                startActivity(intent);
            }
        });
    }
}