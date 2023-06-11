package domaine.commande;

import domaine.model.Argument;
import domaine.model.Commande;
import domaine.model.Statut;
import domaine.model.Tache;
import implementation.FileReader;
import implementation.FileWriter;
import implementation.JsonTaskFormater;
import infrastructure.IFileReader;
import infrastructure.IFileWriter;
import infrastructure.ITaskFormater;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

public class Modification extends Commande {
    private IFileReader fileReader;
    private ITaskFormater taskFormater;
    private IFileWriter fileWriter;
    private int identifiantTache;
    public Modification(int identifiantTache, List<Argument> arguments) {
        super(arguments);
        this.identifiantTache = identifiantTache;
        this.fileReader = new FileReader();
        this.taskFormater = new JsonTaskFormater();
        this.fileWriter = new FileWriter();
    }

    @Override
    public void executerCommande() {
        String cheminFichier = cheminJson(identifiantTache);
        File fichier = fileReader.read(cheminFichier);
        List<String> lignesFichier;
        try {
            lignesFichier = Files.readAllLines(fichier.toPath());
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier \n Le fichier n'a pas pu être lu");
            throw new RuntimeException(e);
        }
        String contenuFichier = String.join("", lignesFichier);
        Tache tache = taskFormater.formatToTask(contenuFichier);
        Tache tacheModifiee = modificationTache(tache, super.getArgument());
        String tacheFormatee = taskFormater.TaskToFormaterType(tacheModifiee);
        try {
            fileWriter.write(cheminFichier, tacheFormatee);
        } catch (Exception e) {
            System.out.println("Erreur lors de la modification de la tache \n Le fichier n'a pas pu être modifié");
            e.printStackTrace();
        }
    }

    public String cheminJson(int identifiant) {
        return System.getProperty("user.dir")+"/projet/src/main/data/" + identifiant + ".json";
    }

    public Tache modificationTache(Tache tache, List<Argument> arguments) {
        for (Argument argument : arguments) {
            switch (argument.getTypeArgument()) {
                case DESCRIPTION:
                    tache.setDescription(argument.getValeur());
                    break;
                case ECHEANCE:
                    tache.setEcheance(LocalDate.parse(argument.getValeur()));
                    break;
                case STATUT:
                    tache.setStatut(Statut.valueOf(argument.getValeur()));
                    break;
                default:
                    break;
            }
        }
        return tache;
    }
}
