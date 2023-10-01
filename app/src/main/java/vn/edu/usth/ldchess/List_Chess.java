package vn.edu.usth.ldchess;

import android.content.Intent;
import android.os.Bundle;

import androidx.customview.widget.ExploreByTouchHelper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link List_Chess#newInstance} factory method to
 * create an instance of this fragment.
 */
public class List_Chess extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public List_Chess() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment List_chess.
     */
    // TODO: Rename and change types and number of parameters
    public static List_Chess newInstance(String param1, String param2) {
        List_Chess fragment = new List_Chess();
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
        View rootview = inflater.inflate(R.layout.fragment_list_chess, container,false);
        ImageView pawn=rootview.findViewById(R.id.pawnbutton);
        ImageView knight=rootview.findViewById(R.id.knightbutton);
        ImageView bishop=rootview.findViewById(R.id.bishopbutton);
        ImageView king=rootview.findViewById(R.id.kingbutton);
        ImageView queen=rootview.findViewById(R.id.queenbutton);
        ImageView rock=rootview.findViewById(R.id.rookbutton);


        pawn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(0);
            }
        });

        knight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(1);
            }
        });

        king.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(2);
            }
        });

        queen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(3);
            }
        });

        bishop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(4);
            }
        });

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(5);
            }
        });
        return rootview;
    }
    public void changeFragment(Integer num){
        ChessManFragment chess_man=new ChessManFragment();
        chess_man.setChessPiece(num);
        FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main, chess_man, "Chess main")
                .commit();
        chess_click();
    }
    public void chess_click(){
        View rootView = getActivity().getWindow().getDecorView().findViewById(android.R.id.content);
        ScrollView list_chess = rootView.findViewById(R.id.list_chess);
        list_chess.setVisibility(View.INVISIBLE);
    }
    public void onBackPressed() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}