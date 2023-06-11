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
        String path = getPath(identifiantTache);
        File file = fileReader.read(path);
        file.delete();
    }

    public String getPath(int identifiant) {
        return System.getProperty("user.dir")+"/projet/src/data/" + identifiant + ".json";
    }
}
