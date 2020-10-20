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

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < M; i++) {
            String ROW = in.nextLine();
        }

        System.out.println(numberOfPaths(M, N));

    }
}