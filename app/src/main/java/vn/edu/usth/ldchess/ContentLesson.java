package vn.edu.usth.ldchess;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContentLesson#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentLesson extends Fragment {
    private int position;
    private HashMap<Integer, Object[]> lesson;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String ARG_PARAM3= "param3";
    private static final String ARG_PARAM4 = "param4";

    private static final String ARG_PARAM5= "param5";
    private static final String ARG_PARAM6= "param6";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContentLesson() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContentLesson.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentLesson newInstance(String param1, String param2) {
        ContentLesson fragment = new ContentLesson();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_content();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void list_content() {
        lesson=new HashMap<>();

        String[] title={
                "Introduce: History of Chess",
                "Lesson 1: Pawn. Promote Pawn. Capture en passant",
                "Lesson 2: Attack and Defense. Check. Check retreat. Double check.",
                "Lesson 3: Castling",
                "Lesson 4: A draw. Perpetual check",
                "Lesson 5: Draw by stalemate.",
        };
        String[] content={
                "The history of chess dates back about 1500 years ago, starting in North India and then spreading to the entire Asian continent. Chess was brought to Europe by the Arab Islamic Empire. The rules of chess changed many times until the 1880s. The first official World Chess Championship was held in 1886.",
                "Capture en passant (French: [ɑ̃ paˈsɑ̃]) is a special move in chess used to capture an opponent's pawn. It occurs when a pawn captures an opponent's pawn that has just moved two squares forward from its starting position in the first move. After executing en passant, the capturing pawn occupies the square that the captured pawn would have moved to if it had only moved one square. This rule ensures that a pawn cannot easily escape from an opponent's pawn by moving two squares immediately.\n" +
                        "\n" +
                        "\n" +
                        "The capture en passant can only occur immediately in the same move where the opposing pawn has moved two squares. It cannot be performed in subsequent moves. In notation, this move is often denoted as e.p in international notation or q.đ in Vietnamese notation.",
                "Attack and defense are two important concepts in chess. Here are some basic concepts related to check and defense:\n" +
                        "\n" +
                        "\n" +
                        "- Check: When a King is threatened by an opponent's piece, it is said to be in check. When a King is in check, the player must find a way to move the King to escape the check or block the check by placing another piece between the checking piece and the King.\n" +
                        "\n" +
                        "\n" +
                        "- Checkmate: When a King is in check and there is no legal move or blocking the check, it is checkmate. This means the player in checkmate has lost the game.\n" +
                        "\n" +
                        "\n" +
                        "- Double check: When two opponent's pieces simultaneously check the King, it is called a double check. In this case, the player must move the King to escape the check because it is not possible to block the check with another piece.\n" +
                        "\n" +
                        "\n" +
                        "These are just basic concepts related to attack and defense in chess. Chess is a complex game with many different strategies and tactics.",
                "Castling is a term in chess that refers to the move where the King is moved from its initial position to the opposite side of the opponent's pieces. When the King reaches the opposite side, the player has achieved the main goal in chess, known as castling or checkmate.\n" +
                        "\n" +
                        "\n" +
                        "For the player moving first (the white player), castling can be performed by moving the King to the opposite side without being in check and without any way for the opponent's pieces to block the check. When castling is achieved, the white player wins the game.\n" +
                        "\n" +
                        "\n" +
                        "For the player moving second (the black player), castling can be avoided by moving the King to escape the check or by blocking the check by placing another piece between the checking piece and the King.\n" +
                        "\n" +
                        "\n" +
                        "Castling is the objective of each player in chess and requires strategy, calculation, and coordination between the pieces to achieve.",
                "Draw and Stalemate are two important terms in chess. Here is an explanation of each term:\n" +
                        "\n" +
                        "\n" +
                        "Draw: A draw occurs when one of the players in chess proposes a draw or when certain specific draw conditions are met. There are several cases where the game ends without a winner or loser, and the result is recognized as a draw. Some draw conditions include:\n" +
                        "\n" +
                        "Draw by insufficient material to checkmate.\n" +
                        "\n" +
                        "Draw by mutual agreement between the players.\n" +
                        "\n" +
                        "\n" +
                        "Stalemate: Stalemate occurs when the King is not in check but has no legal moves available. In this case, the player is not defeated, and the game ends with a draw. Stalemate often happens when the King is surrounded, has no available squares to move, and is not in check.\n" +
                        "When a draw or stalemate occurs, the game ends without a winner or loser. It is part of the tactics and rules of chess, reflecting the balance and coordination between the two players.",
                "Draw by stalemate is a term in chess that refers to a situation in a game where the King is not in check but has no legal moves available for any of the pieces. In this scenario, the game ends with a draw.\n" +
                        "\n" +
                        "Stalemate typically occurs when:\n" +
                        "\n" +
                        "- The King is not in check.\n" +
                        "\n" +
                        "- There are no legal moves for any of the pieces on the board.\n" +
                        "\n" +
                        "Stalemate is an intriguing state in chess, especially when one side is in a difficult position and has no way to escape check. If players are not careful, they can end up with a draw by stalemate instead of losing the game.",
        };


        for(int i =0 ; i< title.length; i++){
            Object[] array={title[i],content[i]};
            lesson.put(i,array);
        }
    }

    public void setContentLesson(int num){
        this.position=num;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_content_lesson, container, false);

        TextView ls_title=view.findViewById(R.id.ls_title);
        TextView ls_content=view.findViewById(R.id.ls_content);

        Object[] item = lesson.get(position);
        ls_title.setText((String)item[0]);
        ls_content.setText((String)item[1]);


        return view;

    }

    public void onBackPressed() {
        List_Lesson list_lesson = new List_Lesson();
        FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main,list_lesson).commit();
    }
}