package DesignPatterns.Factory;

public class Client {
    public Client() {
    }

    public Commande createCommande(String name) {
        return new Commande(this, name);
    }
}
