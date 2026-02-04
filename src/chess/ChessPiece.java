package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    protected int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    protected boolean canMoveTo(Position position) {
        if(!getBoard().positionExists(position)){
            return false;
        }
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || isThereEnemyPiece(position);
    }

    protected boolean isThereEnemyPiece (Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    public ChessPosition getChessPosition (){
        return ChessPosition.fromPosition(position);
    }

    public void increaseMoveCount(){
        moveCount ++;
    }

    public void decreaseMoveCount (){
        moveCount --;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Color getColor() {
        return color;
    }
}
