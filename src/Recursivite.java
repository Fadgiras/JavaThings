public class Recursivite {
    public static void compteARebour(int n){
        if (n>=0){
            System.out.println(n);
            compteARebour(n-1);
        }
    }

    public static int serieArithmétique(int n){
        if (n==0)
            return 0;
        return serieArithmétique(n-1) + n;
    }

    public static int serieArithmétiqueTerm(int n, int acc){
        if (n==0)
            return acc;
        return serieArithmétiqueTerm(n-1, acc+n);
    }

    public static int factorielle(int n){
        if (n==0)
            return 1;
        return factorielle(n-1) * n;

    }

    public static int puissance( int b, int n){
        if (n==0)
            return 1;
        if (n%2==0)
            return puissance(b*b, n/2);
        return puissance(b, n-1) * b;
    }

    public static void main(String[] args){

        System.out.println(puissance(5,20));
    }
}
