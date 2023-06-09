package domaine.commande;

import domaine.model.Argument;
import domaine.model.Commande;
import domaine.model.Tache;
import domaine.model.TypeArgument;
import implementation.FileWriter;
import implementation.JsonTaskFormater;
import infrastructure.IFileWriter;
import infrastructure.ITaskFormater;

import java.time.LocalDateTime;
import java.util.List;

public class Creation extends Commande {
    private IFileWriter fileWriter;
    private ITaskFormater taskFormater;

    public Creation(List<Argument> arguments) {
        super(arguments);
        this.fileWriter = new FileWriter();
        this.taskFormater = new JsonTaskFormater();
    }

    @Override
    public void executerCommande() {
        Tache tache = new Tache(0, LocalDateTime.now().toLocalDate(), getDescriptif());
        String stringifiedTask =  taskFormater.TaskToFormaterType(tache);
        fileWriter.write("", stringifiedTask);
    }

    public String getDescriptif() {
        return super.getArgument().stream().filter(argument -> argument.getTypeArgument().equals(TypeArgument.DESCRIPTION)).findFirst().get().getValeur();
    }
}
