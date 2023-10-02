package vn.edu.usth.ldchess;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link List_Lesson#newInstance} factory method to
 * create an instance of this fragment.
 */
public class List_Lesson extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public List_Lesson() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment List_Lesson.
     */
    // TODO: Rename and change types and number of parameters
    public static List_Lesson newInstance(String param1, String param2) {
        List_Lesson fragment = new List_Lesson();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list__lesson, container, false);
        ImageView history = view.findViewById(R.id.history);
        ImageView lesson_one = view.findViewById(R.id.lesson_one);
        ImageView lesson_two = view.findViewById(R.id.lesson_two);
        ImageView lesson_three = view.findViewById(R.id.lesson_three);
        ImageView lesson_four = view.findViewById(R.id.lesson_four);
        ImageView lesson_five = view.findViewById(R.id.lesson_five);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(0);
            }
        });

        lesson_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(1);
            }
        });

        lesson_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(2);
            }
        });

        lesson_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(3);
            }
        });

        lesson_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(4);
            }
        });

        lesson_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeFragment(5);
            }
        });



        return  view;
    }

    public void ChangeFragment(int num){
        ContentLesson contentLesson=new ContentLesson();
        contentLesson.setContentLesson(num);
        FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main, contentLesson, "Content Lesson")
                .commit();
        lesson_click();
    }
    public void lesson_click(){
        View rootView = getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
        ScrollView list_chess = rootView.findViewById(R.id.list_lesson);
        list_chess.setVisibility(View.INVISIBLE);
    }

    public void onBackPressed() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}