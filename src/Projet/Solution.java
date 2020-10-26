package Projet;

import java.util.*;
import java.io.*;
import java.math.*;

class Solution{

    static String wallKey(final int x, final int y){
        return x + "," + y;
    }

    static Boolean isThereWall(final int x, final String Row){
        return Row.charAt(x) == '1';
    }

    static Boolean isWall(final int x, final int y, final HashMap<String, Boolean> map){
        return map.get(wallKey(x, y));
    }

    public static void main(final String args[]) {
        final Scanner in = new Scanner(System.in);
        final int M = in.nextInt();
        final int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        //Filling the map
        final HashMap Walls = new HashMap<String, Boolean>();
        for (int y = 0; y < M; y++) {
            final String ROW = in.nextLine();
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
        in.close();
        pathFinder toPF = new pathFinder(M, N, Walls);
        System.out.println(toPF.numberOfPaths(M, N, Walls));
    }
}

//to avoid the "Static error"
class pathFinder{

    private final HashMap<String, Boolean> map;
    private final int m, n;
    public pathFinder(final int m, final int n, final HashMap<String, Boolean> map) {
        this.map = map;
        this.m = m;
        this.n = m;
    }
    public int numberOfPaths(final int m, final int n, final HashMap<String, Boolean> map)
    {
        final int x = 0;
        final int y = 0;
        //If start or end is wall then 0 paths
        if(Solution.isWall(0, 0, map) || Solution.isWall(m-1, n-1, map))
            return 0;
        //If map explored stop
        if(Solution.wallKey(x,y)==Solution.wallKey(m, n))
            return 0;
        //if current cell is wall one path minus
        if(Solution.isWall(x, y, map))
            return 0;
        // base algorithm
        if (m == 1 || n == 1)
            return 1;
        //return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
        return numberOfPaths(x + 1, y, map) + numberOfPaths(x, y + 1, map);
    }
}