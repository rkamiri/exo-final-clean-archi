package infrastructure;

import model.Tache;

public interface ITaskFormater {

    Tache formatToTask(String stringifiedTask);
    String TaskToFormaterType(Tache task);
}
