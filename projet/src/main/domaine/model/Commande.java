package domaine.model;

import java.io.IOException;
import java.util.List;


public abstract class Commande {
    List<Argument> arguments;

    public Commande(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public abstract void executerCommande() throws IOException;

    public List<Argument> getArgument() {
        return this.arguments;
    }
}
