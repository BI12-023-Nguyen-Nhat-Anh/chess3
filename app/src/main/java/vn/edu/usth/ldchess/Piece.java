import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.LinkedList;

public class Piece {
    private int x;
    private int y;
    private boolean isWhite;
    private String type;
    private LinkedList<Piece> pieces;

    public Piece(int x, int y, boolean isWhite, String type, LinkedList<Piece> pieces) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
        this.type = type;
        this.pieces = pieces;
        pieces.add(this);
    }

    public void draw(Canvas canvas, Bitmap[][] imgs, int cellSize) {
        int colorIndex = isWhite ? 1 : 0;
        int pieceIndex = -1;
        switch (type) {
            case "rook":
                pieceIndex = 0;
                break;
            case "knight":
                pieceIndex = 1;
                break;
            case "bishop":
                pieceIndex = 2;
                break;
            case "queen":
                pieceIndex = 3;
                break;
            case "king":
                pieceIndex = 4;
                break;
            case "pawn":
                pieceIndex = 5;
                break;
        }
        if (pieceIndex != -1) {
            int left = x * cellSize;
            int top = y * cellSize;
            canvas.drawBitmap(imgs[colorIndex][pieceIndex], left, top, null);
        }
    }
}