package vn.edu.usth.ldchess;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PawnFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PawnFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PawnFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PawnFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PawnFragment newInstance(String param1, String param2) {
        PawnFragment fragment = new PawnFragment();
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
        View rootview=inflater.inflate(R.layout.fragment_pawn, container, false);
        RelativeLayout next=rootview.findViewById(R.id.next);
        RelativeLayout back=rootview.findViewById(R.id.previous);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KnightFragment knight=new KnightFragment();
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main, knight, "knight")
                        .commit();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CastleFragment rock=new CastleFragment();
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main, rock, "Rock")
                        .commit();
            }
        });
        return rootview;
    }

    public void onBackPressed() {
        List_Chess list_chess = new List_Chess();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main, list_chess, "List Chess").commit();
    }
}