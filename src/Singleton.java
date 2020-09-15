public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public static Singleton getInstance2(){
        //Mettre le return en 1er
        return (instance == null) ? (instance = new Singleton()) : instance;
    }
 }

