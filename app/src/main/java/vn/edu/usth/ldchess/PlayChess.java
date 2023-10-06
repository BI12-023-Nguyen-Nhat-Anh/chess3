package vn.edu.usth.ldchess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

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
        // Load chess piece images
        Bitmap all = BitmapFactory.decodeResource(getResources(), R.drawable.chess);;
        int ind = 0;
        for (int y = 0; y < 400; y += 200) {
            for (int x = 0; x < 1200; x += 200) {
                imgs[ind] = Bitmap.createScaledBitmap(
                        Bitmap.createBitmap(all, x, y, 500, 500), 100, 100, true);
                ind++;
            }
        }
        // Create chess pieces
        Piece brook = new Piece(0, -100, false, "rook", ps);
        Piece bkinght = new Piece(1, 0, false, "knight", ps);
        Piece bbishop = new Piece(2, 0, false, "bishop", ps);
        Piece bqueen = new Piece(3, 0, false, "queen", ps);
        Piece bking = new Piece(4, 0, false, "king", ps);
        Piece bbishop2 = new Piece(5, 0, false, "bishop", ps);
        Piece bkight2 = new Piece(6, 0, false, "knight", ps);
        Piece brook2 = new Piece(7, 0, false, "rook", ps);
        Piece bpawn1 = new Piece(1, 1, false, "pawn", ps);
        Piece bpawn2 = new Piece(2, 1, false, "pawn", ps);
        Piece bpawn3 = new Piece(3, 1, false, "pawn", ps);
        Piece bpawn4 = new Piece(4, 1, false, "pawn", ps);
        Piece bpawn5 = new Piece(5, 1, false, "pawn", ps);
        Piece bpawn6 = new Piece(6, 1, false, "pawn", ps);
        Piece bpawn7 = new Piece(7, 1, false, "pawn", ps);
        Piece bpawn8 = new Piece(0, 1, false, "pawn", ps);

        Piece wrook = new Piece(0, 7, true, "rook", ps);
        Piece wkinght = new Piece(1, 7, true, "knight", ps);
        Piece wbishop = new Piece(2, 7, true, "bishop", ps);
        Piece wqueen = new Piece(3, 7, true, "queen", ps);
        Piece wking = new Piece(4, 7, true, "king", ps);
        Piece wbishop2 = new Piece(5, 7, true, "bishop", ps);
        Piece wkight2 = new Piece(6, 7, true, "knight", ps);
        Piece wrook2 = new Piece(7, 7, true, "rook", ps);
        Piece wpawn1 = new Piece(1, 6, true, "pawn", ps);
        Piece wpawn2 = new Piece(2, 6, true, "pawn", ps);
        Piece wpawn3 = new Piece(3, 6, true, "pawn", ps);
        Piece wpawn4 = new Piece(4, 6, true, "pawn", ps);
        Piece wpawn5 = new Piece(5, 6, true, "pawn", ps);
        Piece wpawn6 = new Piece(6, 6, true, "pawn", ps);
        Piece wpawn7 = new Piece(7, 6, true, "pawn", ps);
        Piece wpawn8 = new Piece(0, 6, true, "pawn", ps);
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
        paint.setColor(Color.WHITE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(Color.BLACK);
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
        public boolean isWhite;
        private String type;
        private int imgi;
        private LinkedList<Piece> ps;

        public boolean isWhite(){
            return isWhite;
        }

        public Piece(int x, int y, boolean isWhite, String type, LinkedList<Piece> ps) {
            this.x = x;
            this.y = y;
            this.isWhite = isWhite;
            this.type = type;
            this.ps = ps;
            this.imgi = getImageIndex();
            ps.add(this);
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