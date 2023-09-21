package vn.edu.usth.ldchess;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link exploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class exploreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public exploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment exploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static exploreFragment newInstance(String param1, String param2) {
        exploreFragment fragment = new exploreFragment();
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
        View view =  inflater.inflate(R.layout.fragment_explore, container, false);
        ImageView chess_intro = view.findViewById(R.id.chess_intro);
        ImageView chess_lesson = view.findViewById(R.id.chess_lesson);

        chess_intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List_Chess list_chess=new List_Chess();
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main, list_chess, "queen")
                        .commit();
            }
        });
        chess_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Lesson_List.class));

            }
        });

        return view;
    }
}