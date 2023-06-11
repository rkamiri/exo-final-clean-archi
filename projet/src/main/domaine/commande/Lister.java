package domaine.commande;

import domaine.model.Argument;
import domaine.model.Commande;
import domaine.model.Tache;
import implementation.FileReader;
import implementation.JsonTaskFormater;
import infrastructure.IFileReader;
import infrastructure.ITaskFormater;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Lister extends Commande {
    private IFileReader fileReader;
    private ITaskFormater taskFormater;
    public Lister(List<Argument> arguments) {
        super(arguments);
        this.fileReader = new FileReader();
        this.taskFormater = new JsonTaskFormater();
    }

    @Override
    public void executerCommande() {
       File directory = this.fileReader.read(this.getDirectoryPath());
        File[] files = directory.listFiles();
        List<Tache> taches = Arrays.stream(files).map(file -> {
            List<String> fileLines = null;
            try {
                fileLines = Files.readAllLines(file.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String fileContent = String.join("", fileLines);
            return this.taskFormater.formatToTask(fileContent);
        }).toList();
        for (Tache tache : taches) {
             System.out.println(tache);
        }
    }

    public String getDirectoryPath() {
        return System.getProperty("user.dir")+"/projet/src/main/data/";
    }
}
