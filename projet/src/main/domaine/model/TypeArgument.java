package domaine.model;

public enum TypeArgument {
    DESCRIPTION("-c"), STATUT("-s"), ECHEANCE("-d");

    private String argument;

    private TypeArgument(String argument) {
        this.argument = argument;
    }

    public static TypeArgument argumentValide(String argumentDatum) {
        for (TypeArgument argument : TypeArgument.values()) {
            if (argument.getArgument().equals(argumentDatum)) {
                return argument;
            }
        }
        return null;
    }

    public String getArgument() {
        return this.argument;
    }
}
