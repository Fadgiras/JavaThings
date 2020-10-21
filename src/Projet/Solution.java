package Projet;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int numberOfPaths(int m, int n)
    {
        if (m == 1 || n == 1)
            return 1;
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
    }

    static String wallKey(int x, int y){
        return x + "," + y;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        HashMap Walls = new HashMap<>();
        for (int y = 0; y < M; y++) {
            String ROW = in.nextLine();
            for (int x = 0; x < N; x++) {
                Walls.put(wallKey(x, y), ROW.charAt(x) == '1');
            }
        }

        System.out.println(numberOfPaths(M, N));

    }
}