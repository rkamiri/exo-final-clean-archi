package domaine.commande;

import domaine.model.Argument;
import domaine.model.Commande;
import domaine.model.Requete;

import java.util.List;

public class Lister extends Commande {
    public Lister(List<Argument> arguments) {
        super(arguments);
    }

    @Override
    public void executerCommande() {

    }
}
