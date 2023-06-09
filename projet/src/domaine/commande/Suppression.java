package domaine.commande;

import domaine.model.Argument;
import domaine.model.Commande;

import java.util.List;

public class Suppression extends Commande {
    private int identifiantTache;
    public Suppression(int identifiantTache,List<Argument> arguments) {
        super(arguments);
        this.identifiantTache = identifiantTache;
    }

    @Override
    public void executerCommande() {

    }
}
