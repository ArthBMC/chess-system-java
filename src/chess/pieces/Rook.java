package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //above
        p.setValues(position.getRow() - 1, position.getColumn());
        while (canMoveTo(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p)){
                break;
            }
            p.setRow(p.getRow() - 1);
        }

        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        while (canMoveTo(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p)){
                break;
            }
            p.setRow(p.getRow() + 1);
        }

        //left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (canMoveTo(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p)){
                break;
            }
            p.setColumn(p.getColumn() - 1);
        }

        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (canMoveTo(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (getBoard().thereIsAPiece(p)){
                break;
            }
            p.setColumn(p.getColumn() + 1);
        }

        return mat;
    }

    @Override
    public String toString(){
        return "R";
    }

}
