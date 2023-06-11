# Console task manager

## Technologies requises 
Pour pouvoir lancer l'application, il est nécessaire d'avoir une version de Java supérieure ou égale à Java 18.  
L'écriture et la lecture des fichiers se faisant à l'aide de la classe JSONObject, il faut également importer le jar au préalable. 

## Fonctionnement de l'application 
Il faut se positionner à la racine du projet où se trouvent les fichiers run.sh et run2.sh.  

Pour lancer l'application il faut lancer le script run.sh.  
Pour lancer les tests, il faut lancer le script run2.sh.

### Le type de commandes à executer 
"add" : créer une tâche  
"list" : lister les tâches créées  
"update" : modifier une tâche en précisant son identifiant  
"remove" : supprimer une tâche en précisant son identifiant 


### Les arguments à utiliser dans la commande sont : 
-c : pour la description d'une tâche  
-d : pour la date d'échéance d'une tâche  
-s : pour le statut d'une tâche  

### Exemple 
./run.sh list  
./run.sh add -c:"my new task"  
./run.sh update 1 -s:"terminée"  
./run.sh update 1 -d:"2023-7-30"  
./run.sh remove 1
