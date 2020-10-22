package Projet;

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    static int numberOfPaths(int m, int n, HashMap<String, Boolean> map)
    {
        int x = 0;
        int y = 0;
        //If start or end is wall then 0 paths
        if(isWall(0, 0, map) || isWall(m-1, n-1, map))
            return 0;
        //If map explored stop
        if(wallKey(x,y)==wallKey(m, n))
            return 0;
        //if current cell is wall one path minus
        if(isWall(x, y, map))
            return 0;
        // base algorithm
        if (m == 1 || n == 1)
            return 1;
        //return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
        return numberOfPaths(x + 1, y, map) + numberOfPaths(x, y + 1, map);
    }

    static String wallKey(int x, int y){
        return x + "," + y;
    }

    static Boolean isThereWall(int x, String Row){
        return Row.charAt(x) == '1';
    }

    static Boolean isWall(int x, int y, HashMap<String, Boolean> map){
        return map.get(wallKey(x, y));
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        //Filling the map
        HashMap Walls = new HashMap<String, Boolean>();
        for (int y = 0; y < M; y++) {
            String ROW = in.nextLine();
            for (int x = 0; x < N; x++) {
                Walls.put(wallKey(x, y), isThereWall(x, ROW));
            }
        }
        /*
        //TODO : Eliminating paths
        for (int y = 0; y < M; y++) {
            String ROW = in.nextLine();
            for (int x = 0; x < N; x++) {
                if(isWall(x, y, Walls)){

                }
            }
        }
        */
        System.out.println(numberOfPaths(M, N, Walls));
    }
}