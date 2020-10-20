package DesignPatterns.Factory;

public class Commande {
    private final Client cl;
    private final String name;

    public String getName() {
        return name;
    }

    Commande(Client cl, String name) {
        this.cl = cl;
        this.name = name;
    }
}
