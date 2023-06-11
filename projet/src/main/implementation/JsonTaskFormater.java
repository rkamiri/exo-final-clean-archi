package implementation;

import infrastructure.ITaskFormater;
import domaine.model.Statut;
import domaine.model.Tache;
import org.json.JSONObject;

import java.time.LocalDate;

public class JsonTaskFormater implements ITaskFormater {
    private final static int indentation = 4;
    @Override
    public Tache formatToTask(String stringifiedTask) {
        JSONObject jsonObject = new JSONObject(stringifiedTask);
        int identifiant = jsonObject.getInt("identifiant");
        LocalDate dateCreation = LocalDate.parse(jsonObject.getString("dateCreation"));
        LocalDate dateFin = LocalDate.parse(jsonObject.getString("dateFin"));
        LocalDate echeance = LocalDate.parse(jsonObject.getString("echeance"));
        Statut statut = jsonObject.getEnum(Statut.class,"statut");
        String description = jsonObject.getString("description");
        Tache task = new Tache(identifiant, dateCreation, dateFin, echeance, statut, description);
        return task;
    }

    @Override
    public String TaskToFormaterType(Tache task) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("identifiant", task.getIdentifiant());
        jsonObject.put("dateCreation", task.getDateCreation().toString());
        jsonObject.put("dateFin", task.getDateFin().toString());
        jsonObject.put("echeance", task.getEcheance().toString());
        jsonObject.put("statut", task.getStatut());
        jsonObject.put("description", task.getDescription());

        String jsonFormatted = jsonObject.toString(indentation);
        return jsonFormatted;
    }
}