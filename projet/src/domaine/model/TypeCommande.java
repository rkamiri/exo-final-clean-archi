package domaine.model;

public enum TypeCommande {
    CREATION("add"), MODIFICATION("update"), SUPPRESSION("remove"), Liste("list");

    private String commande;

    private TypeCommande(String commande) {
        this.commande = commande;
    }

    public String getCommande() {
        return this.commande;
    }
}
