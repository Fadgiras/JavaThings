package DesignPatterns.heritage;

public class Cercle extends Point {

    private int rayon;

    public Cercle(int x, int y, int rayon) {
        super(x, y);
        this.rayon = rayon;
    }

    public int getRayon() {
        return rayon;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nRayon : %d", getRayon());
    }

    public static void main(String[] args) {
        Cercle Cerc = new Cercle(5,6,2);
        System.out.println(Cerc);
    }
}


