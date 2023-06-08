package model;

public enum Argument {
    DESCRIPTION("-c"), STATUT("-s"), ECHEANCE("-d");

    private String argument;

    private Argument(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return this.argument;
    }
}
