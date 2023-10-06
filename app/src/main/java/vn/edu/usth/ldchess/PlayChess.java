package vn.edu.usth.ldchess;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class PlayChess extends SurfaceView implements SurfaceHolder.Callback {
    public boolean isWhiteTurn;
    private int cellSize=160;
    private LinkedList<Piece> ps;
    private Piece selectedPiece;
    private Bitmap[] imgs;

    public PlayChess(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        isWhiteTurn = true;
        ps = new LinkedList<>();
        imgs = new Bitmap[12];
//        // Load chess piece images

//        Bitmap all = BitmapFactory.decodeResource(getResources(), R.drawable.chess);
        Bitmap rook = BitmapFactory.decodeResource(getResources(),R.drawable.black_rook);
        Piece brook = new Piece(0, 0, false, "rook",ps,rook);


        Bitmap knight = BitmapFactory.decodeResource(getResources(),R.drawable.black_knight);
        Piece bknight = new Piece(0, 0, false, "rook",ps,knight);

        Bitmap bishop = BitmapFactory.decodeResource(getResources(),R.drawable.black_bishop);
        Piece bbishop = new Piece(0, 0, false, "rook",ps,bishop);

        Bitmap king = BitmapFactory.decodeResource(getResources(),R.drawable.black_king);
        Piece bking = new Piece(0, 0, false, "rook",ps,king);

        Bitmap queen = BitmapFactory.decodeResource(getResources(),R.drawable.black_queen);
        Piece bqueen = new Piece(0, 0, false, "rook",ps,queen);

        Bitmap bishop2 = BitmapFactory.decodeResource(getResources(),R.drawable.black_bishop);
        Piece bbishop2 = new Piece(0, 0, false, "rook",ps,bishop2);

        Bitmap knight2 = BitmapFactory.decodeResource(getResources(),R.drawable.black_knight);
        Piece bknight2 = new Piece(0, 0, false, "rook",ps,knight2);

        Bitmap rook2 = BitmapFactory.decodeResource(getResources(),R.drawable.black_rook);
        Piece brook2 = new Piece(0, 0, false, "rook",ps,rook2);

        Bitmap[] bitmap_array;
        bitmap_array = new Bitmap[]{rook, knight, bishop, king, queen, bishop2, knight2, rook2};

//        ind = bitmap_array[0];
//        for (int i = 0; i < bitmap_array.length; i++) {
//            ind = bitmap_array[i];
//        }
        int ind = 0;
        for (int y = 0; y < 7; y ++) {
            for (int x = 0; x < 7; x ++) {
                for (int i = 0; i < bitmap_array.length; i++) {
                    imgs[i] = bitmap_array[i];
                }
            }
        }


        // Create chess pieces
//




//        Piece brook = new Piece(1, 0, false, "knight",ps,bknight_img);
//        Piece bknight = new Piece(1, 0, false, "knight",ps,bknight_img);
//        Piece bbishop = new Piece(2, 0, false, "bishop",ps,bbishop_img);
//        Piece bqueen = new Piece(3, 0, false, "queen",ps,bqueen_img);
//        Piece bking = new Piece(4, 0, false, "king",ps,bking_img);
//        Piece bbishop2 = new Piece(5, 0, false, "bishop",ps,bbishop_img);
//        Piece bkight2 = new Piece(6, 0, false, "knight",ps,bknight_img);
//        Piece brook2 = new Piece(7, 0, false, "rook",ps,brook_img);
//
//
//        Piece bpawn1 = new Piece(1, 1, false, "pawn",ps,bpawn_img);
//        Piece bpawn2 = new Piece(2, 1, false, "pawn",ps,bpawn_img);
//        Piece bpawn3 = new Piece(3, 1, false, "pawn",ps,bpawn_img);
//        Piece bpawn4 = new Piece(4, 1, false, "pawn",ps,bpawn_img);
//        Piece bpawn5 = new Piece(5, 1, false, "pawn",ps,bpawn_img);
//        Piece bpawn6 = new Piece(6, 1, false, "pawn",ps,bpawn_img);
//        Piece bpawn7 = new Piece(7, 1, false, "pawn",ps,bpawn_img);
//        Piece bpawn8 = new Piece(0, 1, false, "pawn",ps,bpawn_img);
//
//
//
//        int wrook_img = R.drawable.white_rook;
//        int wknight_img = R.drawable.white_knight;
//        int wbishop_img = R.drawable.white_bishop;
//        int wqueen_img = R.drawable.white_queen;
//        int wking_img = R.drawable.white_king;
//        int wpawn_img = R.drawable.white_pawn;
//
//
//        Piece wrook = new Piece(0, 7, true, "rook", ps,wrook_img);
//        Piece wkinght = new Piece(1, 7, true, "knight", ps,wknight_img);
//        Piece wbishop = new Piece(2, 7, true, "bishop", ps,wbishop_img);
//        Piece wqueen = new Piece(3, 7, true, "queen", ps,wqueen_img);
//        Piece wking = new Piece(4, 7, true, "king", ps, wking_img);
//        Piece wbishop2 = new Piece(5, 7, true, "bishop", ps,wbishop_img);
//        Piece wkight2 = new Piece(6, 7, true, "knight", ps,wknight_img);
//        Piece wrook2 = new Piece(7, 7, true, "rook", ps,wrook_img);
//
//        Piece wpawn1 = new Piece(1, 6, true, "pawn", ps,wpawn_img);
//        Piece wpawn2 = new Piece(2, 6, true, "pawn", ps,wpawn_img);
//        Piece wpawn3 = new Piece(3, 6, true, "pawn", ps,wpawn_img);
//        Piece wpawn4 = new Piece(4, 6, true, "pawn", ps,wpawn_img);
//        Piece wpawn5 = new Piece(5, 6, true, "pawn", ps,wpawn_img);
//        Piece wpawn6 = new Piece(6, 6, true, "pawn", ps,wpawn_img);
//        Piece wpawn7 = new Piece(7, 6, true, "pawn", ps,wpawn_img);
//        Piece wpawn8 = new Piece(0, 6, true, "pawn", ps,wpawn_img);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setWillNotDraw(false);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Handle surfacecác sự kiện
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // Cleanup
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Handle touch events
        return true;
    }



    @Override
    protected void onDraw(Canvas canvas) {
        // Draw the chess board and pieces
        Paint paint = new Paint();
        paint.setColor(WHITE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(BLACK);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    canvas.drawRect(i * cellSize, j * cellSize, (i + 1) * cellSize, (j + 1) * cellSize, paint);
                }
            }
        }
        for (Piece p : ps) {

            canvas.drawBitmap(imgs[p.imgi], p.x * cellSize, p.y * cellSize, null);
        }
    }

    private class Piece {
        private int x;
        private int y;
        private Bitmap z;
        public boolean isWhite;
        private String type;
        private int imgi;
        private LinkedList<Piece> ps;



        public boolean isWhite(){
            return isWhite;
        }

        public Piece(int x, int y, boolean isWhite, String type, LinkedList<Piece> ps, Bitmap z) {
            this.x = x;
            this.y = y;
            this.isWhite = isWhite;
            this.type = type;
            this.ps = ps;
            this.imgi = getImageIndex();
            ps.add(this);
            this.z = z;

        }

        private int getImageIndex() {
            int index = 0;
            if (!isWhite) {
                index += 6;
            }
            switch (type) {
                case "rook":
                    index += 0;
                    break;
                case "knight":
                    index += 1;
                    break;
                case "bishop":
                    index += 2;
                    break;
                case "queen":
                    index += 3;
                    break;
                case "king":
                    index += 4;
                    break;
                case "pawn":
                    index += 5;
                    break;
            }
            return index;
        }


    }
}