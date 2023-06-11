package domaine.commande;

import domaine.model.*;
import implementation.FileReader;
import implementation.FileWriter;
import implementation.JsonTaskFormater;
import infrastructure.IFileWriter;
import infrastructure.ITaskFormater;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Creation extends Commande {
    private IFileWriter fileWriter;
    private ITaskFormater taskFormater;
    private FileReader fileReader;

    public Creation(List<Argument> arguments) {
        super(arguments);
        this.fileWriter = new FileWriter();
        this.fileReader = new FileReader();
        this.taskFormater = new JsonTaskFormater();
    }

    @Override
    public void executerCommande() {
        Tache tache = creerTache();
        String stringifiedTask =  taskFormater.TaskToFormaterType(tache);
        try {
            fileWriter.write(getPath(tache.getIdentifiant()), stringifiedTask);
            // write next line in data.txt without overwriting
            fileWriter.write(getDataPath(), String.valueOf(tache.getIdentifiant()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDescriptif() {
        return super.getArgument().stream().filter(argument -> argument.getTypeArgument().equals(TypeArgument.DESCRIPTION)).findFirst().get().getValeur();
    }

    public Tache creerTache() {
        Tache tache = new Tache(getNextIdentifiant());
        for (Argument argument : this.getArgument()) {
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

    public int getNextIdentifiant() {
        File file = fileReader.read(getDataPath());
        try {
            return Integer.parseInt(Files.readString(file.toPath()))+1;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getPath(int identifiant) {
        return System.getProperty("user.dir")+"/projet/src/main/data/" + identifiant + ".json";
    }

    public String getDataPath() {
        return System.getProperty("user.dir")+"/projet/src/main/data/data.txt";
    }
}
