package Projet;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int X0, Y0, X1, Y1, Xmax=30, Ymax=20;

        char[][] gameGrid = new char[Xmax][Ymax];
        for (int y = 0; y < Ymax; y++) {
            for (int x = 0; x < Xmax; x++) {
                gameGrid[x][y] = '_'; //8 : empty case
            }
        }

        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            for (int i = 0; i < N; i++) {
                X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                Position.markPos(i, X1, Y1, gameGrid);
                System.err.println((P==0)?(X0+" "+Y0+" "+ X1+" "+ Y1):("/"));
                //debug

                for(int i2 = 0; i2<20; i2++){
                    for(int j = 0; j<30; j++){
                        System.err.print(gameGrid[j][i2]);
                    }
                    System.err.println();
                }

            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.out.println("LEFT"/*direction()*/); // A single line with UP, DOWN, LEFT or RIGHT
        }
    }
}

class Position{
    static void markPos(int player, int X, int Y, char[][] grid){
        grid[X][Y] = Character.forDigit(player,10);
    }

    //TODO
    //direction()
}
