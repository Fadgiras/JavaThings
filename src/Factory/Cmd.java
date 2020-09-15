package Factory;
//Cli depend de Cmd
public class Cmd {
    private final Cli cl;
    private final String name;

    public String getName() {
        return name;
    }

    private Cmd(Cli cl, String name) {
        this.cl = cl;
        this.name = name;
    }

    static class Cli {
        public Cmd createCommande(String name) {
            return new Cmd(this, name);
        }
    }
}

/**
 //Cmd depend de Cli
 public class Cli2 {
    class Cmd2 {
        private final Cli2 cl;
        private final String name;

        public String getName() {
            return name;
        }

        private Cmd2(Cli2 cl, String name) {
            this.cl = cl;
            this.name = name;
        }
    }

    public Cmd2 createCommande(String name) {
        return new Cmd2(this, name);
    }
}
*/