package domaine.model;

public enum TypeRequete {
    Liste("list");

    private String requete;

    private TypeRequete(String requete) {
        this.requete = requete;
    }

    public String getRequete() {
        return this.requete;
    }
}
