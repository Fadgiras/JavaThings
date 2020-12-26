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
        int X0, Y0, X1, Y1, XP=-1, YP=-1, Xmax=30, Ymax=20;

        char[][] gameGrid = new char[Xmax][Ymax];
        for (int y = 0; y < Ymax; y++) {
            for (int x = 0; x < Xmax; x++) {
                gameGrid[x][y] = '_'; //_ : empty case
            }
        }

        // game loop
        Position Track = new Position();
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            for (int i = 0; i < N; i++) {
                X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)

                Track.markPos(i, X0, Y0, gameGrid);
                Track.markPos(i, X1, Y1, gameGrid);
                if(i==P){
                    XP=X1;
                    YP=Y1;
                }

                System.err.println((i==0)?("Coords player\n"+ X1+" "+ Y1):("Coords ennem\n"+ X1+" "+ Y1));

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
            System.out.println(Track.direction(gameGrid, XP, YP)); // A single line with UP, DOWN, LEFT or RIGHT
        }
    }
}

class Position{
    String Pos;
    String Dir;

    public Position(){
    }

    void markPos(int player, int X, int Y, char[][] grid){
        grid[X][Y] = Character.forDigit(player,10);
    }

    //TODO
    String direction(char[][] Grid, int X, int Y){
        boolean running=true;
        if(X!=0){
            if(Grid[X-1][Y]=='_'){
                //running=false;
                Dir="LEFT";
                return "LEFT";
            }
        }
        if(Y !=0){
            if(Grid[X][Y-1]=='_'){
                //running=false;
                Dir="UP";
                return "UP";
            }
        }
        if(Y!=19){
            if(Grid[X][Y+1]=='_'){
                //running=false;
                Dir="DOWN";
                return "DOWN";
            }
        }
        //System.err.println(X+":"+Y);
        if(X!=29){
            //System.err.println("1");
            if(Grid[X+1][Y]=='_'){
                //running=false;
                //System.err.println("2");
                Dir="RIGHT";
                return "RIGHT";
            }
        }

        //default
        System.err.println("Dir");
        return Dir;
    }


}
