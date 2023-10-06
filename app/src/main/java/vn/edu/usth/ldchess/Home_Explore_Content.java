package vn.edu.usth.ldchess;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_Explore_Content#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Explore_Content extends Fragment {

    HashMap<Integer, Integer> home_pic=new HashMap<>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home_Explore_Content() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Explore_Content.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Explore_Content newInstance(String param1, String param2) {
        Home_Explore_Content fragment = new Home_Explore_Content();
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
        View view=inflater.inflate(R.layout.fragment_home__explore__content, container, false);

        LinearLayout intro=view.findViewById(R.id.intro);
        LinearLayout lesson1=view.findViewById(R.id.lesson1);
        LinearLayout lesson2=view.findViewById(R.id.lesson2);
        LinearLayout lesson3=view.findViewById(R.id.lesson3);
        LinearLayout lesson4=view.findViewById(R.id.lesson4);
        LinearLayout lesson5=view.findViewById(R.id.lesson5);
        RelativeLayout button=view.findViewById(R.id.btn);

        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(0);
            }
        });

        lesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(1);
            }
        });

        lesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(2);
            }
        });

        lesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(3);
            }
        });

        lesson4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(4);
            }
        });

        lesson5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(5);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup();
            }
        });

        return view;
    }

    public void changeFragment(int num){
        ContentLesson lesson=new ContentLesson();
        lesson.setContentLesson(num);
        FragmentManager fragmentManager= requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main, lesson).addToBackStack(null).commit();
        hide_fragment();
    }

    public void hide_fragment(){
        View rootView = getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
        ScrollView list_chess = rootView.findViewById(R.id.home);
        list_chess.setVisibility(View.INVISIBLE);
    }

    public void onBackPressed() {
        getActivity().finishAffinity();
    }

    public void popup(){
        Dialog popup=new Dialog(requireContext());
        popup.setContentView(R.layout.popup);

        Window window=popup.getWindow();
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);

        popup.show();

        Button button=popup.findViewById(R.id.close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closePopup(popup);
            }
        });
    }

    public void closePopup(Dialog popup){
        popup.dismiss();
    }
}