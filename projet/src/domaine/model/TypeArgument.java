package domaine.model;

public enum TypeArgument {
    DESCRIPTION("-c"), STATUT("-s"), ECHEANCE("-d");

    private String argument;

    private TypeArgument(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return this.argument;
    }
}
