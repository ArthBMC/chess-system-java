package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //northwest
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (canMoveTo(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if(getBoard().thereIsAPiece(p)){
                break;
            }
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }

        //northeast
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (canMoveTo(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if(getBoard().thereIsAPiece(p)){
                break;
            }
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }

        //southwest
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (canMoveTo(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if(getBoard().thereIsAPiece(p)){
                break;
            }
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }

        //southeast
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (canMoveTo(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if(getBoard().thereIsAPiece(p)){
                break;
            }
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }

        return mat;
    }

    @Override
    public String toString(){
        return "B";
    }

}
