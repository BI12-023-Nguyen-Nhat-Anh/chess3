package vn.edu.usth.ldchess;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChessManFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ChessManFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

//    Create a variable to take input from the user when they choose chess
    private int position;

//    Create a hashmap to contain array of the chess
    private HashMap<Integer, Object[]> chess;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChessManFragment.
     */

    // TODO: Rename and change types and number of parameters
    public static ChessManFragment newInstance(String param1, String param2) {
        ChessManFragment fragment = new ChessManFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ChessManFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    Load the elements from the array chess into hashmap
    public void list_item(){
        chess=new HashMap<>();

        int[] list_chess_active={R.drawable.pawn, R.drawable.knight, R.drawable.king, R.drawable.queen, R.drawable.bishop, R.drawable.rock};
        int[] list_chess_unactive={R.drawable.pawn_unactive, R.drawable.knight_unactive, R.drawable.king_unactive, R.drawable.queen_unactive, R.drawable.bishop_unactive, R.drawable.rock_unactive};
        String[] title={
                "About the Pawn",
                "About the Knight",
                "About the King",
                "About the Queen",
                "About the Bishop",
                "About the Rook",
        };
        String[] list_detail={
                "A pawn, also known as a pawn, is a basic piece in the game of chess. It is represented by a small cylindrical flagstone, often symbolized by a small cone shape.\n\nInitially, the pawns are placed in the second row on each side of the board. The pawn has the ability to move forward, moving one space at a time. However, on the first move, the pawn can move two spaces instead of one.\n\nPawns have two main functions in the game of chess. First, they have the ability to attack and gain an advantage on the board. When the pawn moves forward and reaches the opponent's last row, it can be promoted to any other piece on the board, such as a queen, bishop, bishop or rook. This creates a great threat and potential power for good.\n\nSecond, pawns play an important role in building and defending defensive structures. When pawns together with other pieces form a solid defensive structure, they can protect the king and other important pieces from enemy attacks. Combination and cooperation between pawns in a phalanx can create a powerful defensive wall.\n\nHowever, being good also has its downsides. Because pawns cannot move back and only move one space at a time, they can be easily blocked and controlled by opposing pieces. This requires players to pay attention to good protection and support by moving other pieces and creating a protective network for them.",
                "The knight is a piece in the game of chess. It is performed by a horse with special mobility. The knight can move in an 'L' shape, i.e. move two spaces horizontally or vertically, then one square perpendicularly.\n\nThe knight can jump over other pieces in the process move. This allows it to overcome obstacles and attack positions that other troops cannot reach. However, the horse also has the limitation of not being able to move in a straight or diagonal line.\n\nWhat's special about the horse is its ability to attack in an 'L' shape, allowing it to create unexpected moves. easily predicted by opponents. This makes the horse an important strategic piece in attack and defense.",
                "King in chess is a king piece, one of the most important pieces in the game. The king is placed in the center square of the chess board and can move one square horizontally, vertically or diagonally.\n\nThe king's role is to protect and keep himself safe. If the king is checked by the opponent (ie attacked), the player must find a way to remove the king from the check situation or block the opponent.\n\nThe king's special rule is not to move into the positions. The square is checked or attacked by an opponent's piece. If the king is captured, that is, checkmate, the player will lose the match.",
                "The queen is the most important piece in the game of chess. It is represented by a queen with the ability to move strongly and flexibly on the chessboard. The queen can move horizontally, vertically and diagonally to all squares on the board.\n\nWith the ability to move freely in many directions, the queen becomes a very powerful piece. It can attack and checkmate from afar, and can protect and support other pieces in the match. The queen can move through multiple rows and columns, creating wide attack paths and putting strong pressure on opponents.\n\nThe queen's variety and strength make it an important target in fight. If a player loses the queen, this usually means losing an important piece and losing a large part of their strength and ability to attack.",
                "The bishop is a piece in the game of chess. It is represented by a statue shaped like a pedestrian wearing a hat. Bishops have the ability to move diagonally on the board.\n\nBishops are often considered medium-value pieces in the game. It can move an unlimited number of squares diagonally, passing over empty squares and other pieces along the way. However, the bishop cannot move in a straight line or pass through spaces blocked by other pieces.\n\nWith the ability to move diagonally, the bishop can be used to attack and defend in locations far from the center. It can pose a threat from afar and attack enemy pieces that are on distant squares. At the same time, bishops can also be used to protect the king and create a defensive arc.\n\nHowever, the limitation of bishops is that they cannot move on squares of the same color. Because the board has alternating black and white squares, each bishop can only move on one type of square. This means that the bishop is limited to moving on half of the board.",
                "The rook is an important piece in the game of chess. It is represented by a vehicle with the ability to move along horizontal and vertical lines on the chessboard.\n\nWith the ability to move far and without restrictions on the path, the vehicle can pass through empty squares. and other chess pieces in the same row or column. It can move from one end of the board to another in one go.\n\nThe rook's strength lies in its ability to attack and defend in rows and columns. The rook can pose a great threat on the board and can attack many enemy pieces at once. It can also be used to protect the king and create a strong defensive barrier.\n\nIn chess strategy, the use of the rook plays an important role. Using rooks to control rows and columns, attack opposing pieces and create strategic paths is an important element in the match."
        };
        for(int i=0;i<list_chess_active.length;i++){
            if(i-1==-1){
                Object[] array={list_chess_unactive[list_chess_unactive.length-1],list_chess_active[i],list_chess_unactive[i+1],title[i],list_detail[i]};
                chess.put(i,array);
            }
            else if(i+1==list_chess_active.length){
                Object[] array={list_chess_unactive[i-1],list_chess_active[i],list_chess_unactive[0],title[i],list_detail[i]};
                chess.put(i,array);
            }
            else{
                Object[] array={list_chess_unactive[i-1],list_chess_active[i],list_chess_unactive[i+1],title[i],list_detail[i]};
                chess.put(i,array);
            }
        }
    }

//    Take the value from the user when they choose which chess they want to see
    public void setChessPiece(int num){
        this.position=num;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Load the hashmap
        list_item();

//        Take the input to show the chess that they want to see
        final int[] current={position};
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_chess_man, container, false);

//        Take the position where text or image should be
        ImageView active_chess=view.findViewById(R.id.chess);
        ImageView previous_chess=view.findViewById(R.id.previous_chess);
        ImageView next_chess=view.findViewById(R.id.next_chess);
        TextView title_chess=view.findViewById(R.id.title);
        TextView detail_chess=view.findViewById(R.id.detail);

//        Take the array from the hashmap at position
        Object[] item=chess.get(position);
        previous_chess.setImageResource((int)item[0]);
        active_chess.setImageResource((int)item[1]);
        next_chess.setImageResource((int)item[2]);
        title_chess.setText((String)item[3]);
        detail_chess.setText((String)item[4]);

//        Change to next chess when user click
        next_chess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current[0]++;

//                If the current chess is the last chess so we will reset the position to the first chess
                if(current[0]>=item.length){
                    current[0]=0;
                }

                Object[] item=chess.get(current[0]);
                previous_chess.setImageResource((int)item[0]);
                active_chess.setImageResource((int)item[1]);
                next_chess.setImageResource((int)item[2]);
                title_chess.setText((String)item[3]);
                detail_chess.setText((String)item[4]);
            }
        });

//        Change to previous chess when user click
        previous_chess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current[0]--;

//                If current chess is the first chess so we will reset the position to the last chess
                if(current[0]<0) {
                    current[0]=item.length-1;
                }

                Object[] item = chess.get(current[0]);
                previous_chess.setImageResource((int) item[0]);
                active_chess.setImageResource((int) item[1]);
                next_chess.setImageResource((int) item[2]);
                title_chess.setText((String) item[3]);
                detail_chess.setText((String) item[4]);
            }
        });
        return view;
    }

    public void onBackPressed() {
        List_Chess list_chess = new List_Chess();
        FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main,list_chess).commit();
    }
}