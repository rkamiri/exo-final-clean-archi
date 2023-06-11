package domaine.model;

public enum Statut {
    A_FAIRE("a faire"), EN_ATTENTE("en attente"), EN_COURS("en cours"), TERMINEE("terminée"), ANNULEE("annulée"), FERMEE("fermée");

    private String description;

    Statut(String description) {
        this.description = description;
    }

    public static Statut statutValide(String valeur) {
        for (Statut statut : Statut.values()) {
            if (statut.getDescription().equals(valeur)) {
                return statut;
            }
        }
        return null;
    }

    public String getDescription(){
        return this.description;
    }
}
