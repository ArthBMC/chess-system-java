package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner in =  new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

            while (!chessMatch.getCheckMate()) {
                try {
                    UI.clearScreen();
                    UI.printMatch(chessMatch, captured);
                    System.out.print("\n\nSource: ");
                    ChessPosition source = UI.readChessPosition(in);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);


                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(in);

                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                    if (capturedPiece != null) {
                        captured.add(capturedPiece);
                    }

                    if (chessMatch.getPromoted() != null) {
                        System.out.print("Enter piece for promotion (B/N/R/Q): ");
                        String type = in.nextLine();
                        chessMatch.replacePromotedPiece(type);
                    }

                }
                catch (ChessException | InputMismatchException e){
                    System.out.println("\n" + e.getMessage());
                    System.out.println("Press 'Enter' to try again...");
                    in.nextLine();
                }

            }
            UI.clearScreen();
            UI.printMatch(chessMatch, captured);

    }
}