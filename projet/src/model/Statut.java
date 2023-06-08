package model;

public enum Statut {
    A_FAIRE("a faire"), EN_ATTENTE("en attente"), EN_COURS("en cours"), TERMINEE("terminée"), ANNULEE("annulée"), FERMEE("fermée");

    private String description;

    Statut(String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
