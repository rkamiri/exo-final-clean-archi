package domaine.commande;

import domaine.model.Argument;
import domaine.model.Commande;
import domaine.model.Tache;
import domaine.model.TypeArgument;
import implementation.FileReader;
import implementation.FileWriter;
import implementation.JsonTaskFormater;
import infrastructure.IFileWriter;
import infrastructure.ITaskFormater;

import java.io.File;
import java.nio.file.Files;
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
        Tache tache = new Tache(getNextIdentifiant(), LocalDateTime.now().toLocalDate(), getDescriptif());
        String stringifiedTask =  taskFormater.TaskToFormaterType(tache);
        try {
            fileWriter.write(getPath(tache.getIdentifiant()), stringifiedTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDescriptif() {
        return super.getArgument().stream().filter(argument -> argument.getTypeArgument().equals(TypeArgument.DESCRIPTION)).findFirst().get().getValeur();
    }

    public int getNextIdentifiant() {
        File file = fileReader.read("/data");
        try {
            return Files.readAllLines(file.toPath()).size() + 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getPath(int identifiant) {
        return "/data/" + identifiant + ".json";
    }
}
