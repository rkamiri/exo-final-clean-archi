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
    public void executerCommande() throws IOException {
        String path = getPath(identifiantTache);
        File file = fileReader.read(path);
        List<String> fileLines = Files.readAllLines(file.toPath());
        String fileContent = String.join("", fileLines);
        Tache tache = taskFormater.formatToTask(fileContent);
        Tache tacheUpdated = updateTask(tache, super.getArgument());
        String stringifiedTask =  taskFormater.TaskToFormaterType(tacheUpdated);
        fileWriter.write(path, stringifiedTask);
    }

    public String getPath(int identifiant) {
        return "/data/" + identifiant + ".json";
    }

    public Tache updateTask(Tache tache, List<Argument> arguments) {
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
