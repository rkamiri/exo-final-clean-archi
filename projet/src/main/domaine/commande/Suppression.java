package domaine.commande;

import domaine.model.Argument;
import domaine.model.Commande;
import implementation.FileReader;
import infrastructure.IFileReader;

import java.io.File;
import java.util.List;

public class Suppression extends Commande {
    private IFileReader fileReader;
    private int identifiantTache;
    public Suppression(int identifiantTache,List<Argument> arguments) {
        super(arguments);
        this.identifiantTache = identifiantTache;
        this.fileReader = new FileReader();
    }

    @Override
    public void executerCommande() {
        String chemin = cheminJson(identifiantTache);
        File file = fileReader.read(chemin);
        file.delete();
    }

    public String cheminJson(int identifiant) {
        return System.getProperty("user.dir")+"/projet/src/main/data/" + identifiant + ".json";
    }
}
