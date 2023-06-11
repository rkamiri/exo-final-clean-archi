import domaine.commande.Creation;
import domaine.commande.Modification;
import domaine.model.Argument;
import domaine.model.Statut;
import domaine.model.Tache;
import domaine.model.TypeArgument;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class TacheTest {
    @Test
    public void test_creation() {
        Creation creation = new Creation(List.of(new Argument(TypeArgument.DESCRIPTION, "This is a new task"), new Argument(TypeArgument.ECHEANCE, LocalDate.of(2023, 7, 3).toString())));
        String descriptif = creation.getDescriptif();

        Assert.assertEquals("This is a new task", descriptif);
    }
    @Test
    public void test_update_task() {
        Tache tache = new Tache(1, LocalDate.now(), "hello world");
        Modification modification = new Modification(tache.getIdentifiant(), List.of(new Argument(TypeArgument.STATUT, Statut.ANNULEE.toString())));
        Tache tacheModifiee = modification.modificationTache(tache, modification.getArgument());

        Assert.assertEquals(new Tache(1, LocalDate.now(),null, null, Statut.ANNULEE, "hello world"), tacheModifiee);
    }

}
