package DesignPatterns.Exception;

public class ProgDynamique {
    static long factorielle(int n){
        if(n==1){
            return 1;
        }
        return n*factorielle(n-1);
    }
    static long fiboProgDyn(int n, long[] cache){
        if(cache[n] != -1) {
            cache[n] = n;
        } if (n < 2){
            cache[n] = n;
            return n;
        }
        cache[n] = fiboProgDyn(n - 1, cache) + fiboProgDyn(n - 2, cache);
        return cache[n];
    }

    static long fiboProgDyn(int n){
        long [] cache = new long[n + 1];
        for(int i = 0; i <= n; i++)
            cache[i] = -1;
        return fiboProgDyn(n, cache);
    }
/*
    static long combinaisons(int p, int n){
        if (cache[p][n] == -1)
            if (p ==0 || p == n)
                cache[p][n] = 1;
            else if (p<0 || n<0)
                return 0;
            else return combinaisons(p - 1, n - 1) + combinaisons(p, n - 1);
    }

    static long combinaisons(int p, int n){
        long[][] cache = new long[p + 1]
    }

    static void trianglePascal(int nbLignes){
        for (int n = 0; n <= nbLignes; n++){
            for (int p = 0; p<=n; p++)
                System.out.print("n = "+n+":\t"+combinaisons(p,n));
            System.out.println();
        }
    }
*/
    public static void main(String[] args) {
        for(int i=0; i<10; i++)
            System.out.println(fiboProgDyn(i));
        int nb = 5;
        System.out.println("Factorielle de "+ nb+" = " + factorielle(nb));
    }

}
