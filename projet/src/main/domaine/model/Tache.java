package domaine.model;

import java.time.LocalDate;

public class Tache {
    private int identifiant;
    private LocalDate dateCreation;
    private LocalDate dateFin;
    private LocalDate echeance;
    private Statut statut;
    private String description;

    public Tache(int identifiant, LocalDate dateCreation, String description) {
        this.identifiant = identifiant;
        this.dateCreation = dateCreation;
        this.statut = Statut.A_FAIRE;
        this.description = description;
    }

    public Tache(int identifiant, LocalDate dateCreation, LocalDate dateFin, LocalDate echeance, String description) {
        this.identifiant = identifiant;
        this.dateCreation = dateCreation;
        this.dateFin = dateFin;
        this.echeance = echeance;
        this.statut = Statut.A_FAIRE;
        this.description = description;
    }

    public Tache(int identifiant, LocalDate dateCreation, LocalDate dateFin, LocalDate echeance, Statut statut, String description) {
        this.identifiant = identifiant;
        this.dateCreation = dateCreation;
        this.dateFin = dateFin;
        this.echeance = echeance;
        this.statut = statut;
        this.description = description;
    }

    public Tache(int nouvelIdentifiant) {
        this.identifiant = nouvelIdentifiant;
        this.dateCreation = LocalDate.now();
        this.statut = Statut.A_FAIRE;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDate getEcheance() {
        return echeance;
    }

    public void setEcheance(LocalDate echeance) {
        this.echeance = echeance;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean dateSimilaires(Tache autreTache) {
        if(this.dateFin == null && this.echeance == null) return autreTache.dateFin == null && autreTache.echeance == null;
        return this.dateFin.isEqual(autreTache.dateFin) && this.echeance.isEqual(autreTache.echeance);
    }
    @Override
    public boolean equals(Object autreTache) {
        System.out.println(this);
        System.out.println(autreTache);
        if (this == autreTache) return true;
        if (autreTache == null || getClass() != autreTache.getClass()) return false;
        return this.identifiant == ((Tache) autreTache).getIdentifiant() && this.dateCreation.isEqual(((Tache) autreTache).getDateCreation()) && this.dateSimilaires((Tache) autreTache) && this.statut.equals(((Tache) autreTache).getStatut()) && this.description.equals(((Tache) autreTache).getDescription());
    }

    @Override
    public String toString() {
        return "Tache{" +
                "identifiant=" + identifiant +
                ", dateCreation=" + dateCreation +
                ", dateFin=" + dateFin +
                ", echeance=" + echeance +
                ", statut=" + statut +
                ", description='" + description + '\'' +
                '}';
    }
}
