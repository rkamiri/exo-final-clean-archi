package implementation;

import domaine.commande.Lister;
import domaine.commande.Modification;
import domaine.commande.Suppression;
import domaine.model.Argument;
import domaine.model.Commande;
import domaine.model.TypeArgument;
import domaine.model.TypeCommande;
import domaine.commande.Creation;
import infrastructure.ICommandeHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandeHandler implements ICommandeHandler {

    public void handle(Query query){
        List<String> commandeData = Arrays.stream(query.getQuery()).toList();
        TypeCommande typeCommande = this.FindCommandType(commandeData.get(0));
        List<Argument> arguments = new ArrayList<>();
        int taskId = -1; // -1 is the default value for taskId
        if (typeCommande == TypeCommande.CREATION){
            arguments = this.getArgumentList(commandeData.subList(1, commandeData.size()));
        } else if (typeCommande != TypeCommande.Liste) {
            taskId = this.FindTaskId(commandeData.get(1));
            arguments = this.getArgumentList(commandeData.subList(2, commandeData.size()));
        }
        createCommande(typeCommande, taskId, arguments).executerCommande();
    }

    public TypeCommande FindCommandType(String commandeType){
        switch(commandeType){
            case "add":
                return TypeCommande.CREATION;
            case "delete":
                return TypeCommande.SUPPRESSION;
            case "update":
                return TypeCommande.MODIFICATION;
            default:
                return null;
        }
    }

    public int FindTaskId(String taskId){
        int taskIdInt = 0;
        try {
            taskIdInt = Integer.parseInt(taskId);
        } catch (NumberFormatException e) {
            System.out.println("TaskId is not a number");
            taskIdInt = -1;
        }
        return taskIdInt;
    }

    public List<Argument> getArgumentList(List<String> arguments){
        return arguments.stream().map(argument -> {
            String[] argumentData = argument.split(":");
            return new Argument(TypeArgument.valueOf(argumentData[0]), argumentData[1]);
        }).toList();
    }

    private Commande createCommande(TypeCommande typeCommande,int taskId, List<Argument> arguments){
        Commande commande = null;
        switch (typeCommande) {
            case CREATION:
                commande = new Creation(arguments);
                break;
            case MODIFICATION:
                commande = new Modification(taskId, arguments);
                break;
            case SUPPRESSION:
                commande = new Suppression(taskId, arguments);
                break;
            case Liste:
                commande = new Lister(arguments);
                break;
            default:
                break;
        }
        return commande;
    }
}
