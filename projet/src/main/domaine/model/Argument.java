package domaine.model;

public class Argument {
    private TypeArgument argument;
    private String valeur;

    public Argument(TypeArgument argument, String valeur) {
        this.argument = argument;
        this.valeur = valeur;
    }

    public TypeArgument getTypeArgument() {
        return this.argument;
    }

    public String getValeur() {
        return this.valeur;
    }
}
