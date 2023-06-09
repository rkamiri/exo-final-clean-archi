package domaine.commande;

import domaine.model.Argument;
import domaine.model.Commande;
import domaine.model.Tache;
import implementation.FileWriter;
import implementation.JsonTaskFormater;
import infrastructure.IFileWriter;
import infrastructure.ITaskFormater;

import java.time.LocalDate;
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
        Tache tache = new Tache(0, new LocalDate(), new LocalDate(), new LocalDate(), "description");
        // int identifiant, LocalDate dateCreation, LocalDate dateFin, LocalDate echeance, String description

    }

    public String getDescriptif() {
        this.arguments
    }
}
