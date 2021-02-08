package com.company;

import java.util.Scanner;

public class TicTacToeRunner {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char p = 'X';
        TicTacToeClass ttt = new TicTacToeClass();
        int r, c;

        while (!(ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull())) {
            ttt.displayBoard();
            System.out.print("'" + p + "', choose your target (row, column): ");
            r = keyboard.nextInt();
            c = keyboard.nextInt();

            while (ttt.isValid(r,c) == false || ttt.playerAt(r,c) != ' ') {
                if (ttt.isValid(r,c) == false)
                    System.out.println("That is not a valid target. Try again.");
                else if (ttt.playerAt(r,c) != ' ')
                    System.out.println("That target location is already taken. Try again.");

                System.out.print("Choose your target (row, column): ");
                r = keyboard.nextInt();
                c = keyboard.nextInt();
            }

            ttt.playMove( p, r, c );

            if (p == 'X')
                p = 'O';
            else
                p = 'X';

        }

        ttt.displayBoard();

        if (ttt.isWinner('X'))
            System.out.println("X WINS!");
        if (ttt.isWinner('O'))
            System.out.println("O WINS!");
        if (ttt.isCat())
            System.out.println("Tie!");
    }
}