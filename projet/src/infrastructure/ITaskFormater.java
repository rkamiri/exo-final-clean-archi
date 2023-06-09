package infrastructure;

import domaine.model.Tache;

public interface ITaskFormater {

    Tache formatToTask(String stringifiedTask);
    String TaskToFormaterType(Tache task);
}
