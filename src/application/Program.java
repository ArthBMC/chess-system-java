package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);


        ChessMatch chessMatch = new ChessMatch();

            while (true) {
                try {
                    UI.printBoard(chessMatch.getPieces());
                    System.out.print("\n\nSource: ");
                    ChessPosition source = UI.readChessPosition(in);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);


                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(in);

                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                }
                catch (ChessException | InputMismatchException e){
                    System.out.println("\n" + e.getMessage());
                    System.out.println("Press 'Enter' to try again...");
                    in.nextLine();
                }
                /*catch (InputMismatchException e){
                    System.out.println(e.getMessage());
                    in.nextLine();
                }*/

            }

    }
}