package vn.edu.usth.ldchess;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.util.LinkedList;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class PlayChess {
    private Bitmap black_Rook;
    private static Context context;
    public static LinkedList<Piece> ps=new LinkedList<>();
    public static Piece selectedPiece=null;
    public PlayChess(Context context) {
        this.context = context;
    }
    public static void main(String[] args) throws IOException {




        Bitmap black_Pawn = BitmapFactory.decodeResource(context.getResources(), R.drawable.black_pawn);
        Bitmap black_Rook = BitmapFactory.decodeResource(context.getResources(), R.drawable.black_rook);
        Bitmap black_Knight = BitmapFactory.decodeResource(context.getResources(), R.drawable.black_knight);
        Bitmap black_Bishop = BitmapFactory.decodeResource(context.getResources(), R.drawable.black_bishop);
        Bitmap black_King = BitmapFactory.decodeResource(context.getResources(), R.drawable.black_king);
        Bitmap black_Queen = BitmapFactory.decodeResource(context.getResources(), R.drawable.black_queen);



        Piece black_Rook=new Piece(0, 0, false, "rook", ps);
        Piece black_Knight=new Piece(1, 0, false, "knight", ps);
        Piece black_Bishop=new Piece(2, 0, false, "bishop", ps);
        Piece black_Queen=new Piece(3, 0, false, "queen", ps);
        Piece black_King=new Piece(4, 0, false, "king", ps);
        Piece black_Bishop2=new Piece(5, 0, false, "bishop", ps);
        Piece black_Knight2=new Piece(6, 0, false, "knight", ps);
        Piece black_Rook2=new Piece(7, 0, false, "rook", ps);
        Piece black_Pawn1=new Piece(1, 1, false, "pawn", ps);
        Piece black_Pawn2=new Piece(2, 1, false, "pawn", ps);
        Piece black_Pawn3=new Piece(3, 1, false, "pawn", ps);
        Piece black_Pawn4=new Piece(4, 1, false, "pawn", ps);
        Piece black_Pawn5=new Piece(5, 1, false, "pawn", ps);
        Piece black_Pawn6=new Piece(6, 1, false, "pawn", ps);
        Piece black_Pawn7=new Piece(7, 1, false, "pawn", ps);
        Piece black_Pawn8=new Piece(0, 1, false, "pawn", ps);



        Bitmap white_Pawn = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_pawn);
        Bitmap white_Rook = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_rook);
        Bitmap white_Knight = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_knight);
        Bitmap white_Bishop = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_bishop);
        Bitmap white_King = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_king);
        Bitmap white_Queen = BitmapFactory.decodeResource(context.getResources(), R.drawable.white_queen);

        Piece white_Rook=new Piece(0, 7, true, "rook", ps);
        Piece white_Knight=new Piece(1, 7, true, "knight", ps);
        Piece white_Bishop=new Piece(2, 7, true, "bishop", ps);
        Piece white_Queen=new Piece(3, 7, true, "queen", ps);
        Piece white_King=new Piece(4, 7, true, "king", ps);
        Piece white_Bishop2=new Piece(5, 7, true, "bishop", ps);
        Piece white_Knight2=new Piece(6, 7, true, "knight", ps);
        Piece white_Rook2=new Piece(7, 7, true, "rook", ps);
        Piece white_Pawn1=new Piece(1, 6, true, "pawn", ps);
        Piece white_Pawn2=new Piece(2, 6, true, "pawn", ps);
        Piece white_Pawn3=new Piece(3, 6, true, "pawn", ps);
        Piece white_Pawn4=new Piece(4, 6, true, "pawn", ps);
        Piece white_Pawn5=new Piece(5, 6, true, "pawn", ps);
        Piece white_Pawn6=new Piece(6, 6, true, "pawn", ps);
        Piece white_Pawn7=new Piece(7, 6, true, "pawn", ps);
        Piece white_Pawn8=new Piece(0, 6, true, "pawn", ps);



        public class ChessboardView extends View {
            private boolean white;
            private Paint whiteSquarePaint;
            private Paint blackSquarePaint;
            private Piece[] pieces;

            public ChessboardView(Context context) {
                super(context);
                white = true;
                whiteSquarePaint = new Paint();
                whiteSquarePaint.setColor(Color.rgb(235, 235, 208));
                blackSquarePaint = new Paint();
                blackSquarePaint.setColor(Color.rgb(119, 148, 85));
            }

            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);

                int size = getWidth() / 8; // Kích thước của từng ô

                for (int y = 0; y < 8; y++) {
                    for (int x = 0; x < 8; x++) {
                        if (white) {
                            canvas.drawRect(x * size, y * size, (x + 1) * size, (y + 1) * size, whiteSquarePaint);
                        } else {
                            canvas.drawRect(x * size, y * size, (x + 1) * size, (y + 1) * size, blackSquarePaint);
                        }
                        white = !white;
                    }
                    white = !white;
                }

                for (Piece p : pieces) {
                    int ind=0;
                    if(p.name.equalsIgnoreCase("king")){
                        ind=0;
                    }
                    if(p.name.equalsIgnoreCase("queen")){
                        ind=1;
                    }
                    if(p.name.equalsIgnoreCase("bishop")){
                        ind=2;
                    }
                    if(p.name.equalsIgnoreCase("knight")){
                        ind=3;
                    }
                    if(p.name.equalsIgnoreCase("rook")){
                        ind=4;
                    }
                    if(p.name.equalsIgnoreCase("pawn")){
                        ind=5;
                    }
                    if(!p.isWhite){
                        ind+=6;
                    }
                    g.drawImage(imgs[ind], p.x, p.y, this);
                }
            }
        }

        // Tạo một lớp lắng nghe sự kiện chạm riêng
        class MyTouchListener implements View.OnTouchListener {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if(selectedPiece!=null){
                        selectedPiece.x=e.getX()-32;
                        selectedPiece.y=e.getY()-32;
                        frame.repaint();
                    }
                }
                return true;
            }
        }

        frame.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(selectedPiece!=null){
                    selectedPiece.x=e.getX()-32;
                    selectedPiece.y=e.getY()-32;
                    frame.repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e){

            }

        });
        frame.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked (MouseEvent e){

            }


            @Override
            public void mousePressed (MouseEvent e){
                // System.out.println((getPiece(e.getX(), e.getY()).isWhite?"white ":"black ")+e.getX(), e.getY()).name);
                selectedPiece=getPiece(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased (MouseEvent e){
                selectedPiece.move(e.getX()/64,e.getY()/64);
                frame.repaint();
            }


            @Override
            public void mouseEntered (MouseEvent e){

            }


            @Override
            public void mouseExited (MouseEvent e){

            }

        });



    }
    public static Piece getPiece(int x, int y){
        int xp = x/64;
        int yp = y/64;
        for(Piece p: ps){
            if(p.xp==xp && p.yp==yp){
                return p;
            }
        }
        return null;
    }

}
