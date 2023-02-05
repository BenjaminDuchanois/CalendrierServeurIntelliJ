package df.Jersey.element;

/*
    PROGRAMME pour le PROJET d'ASI
    COTE SERVEUR
    DUCHANOIS Benjamin
    JORGE William
    Master 1 Informatique

    Pour accèder à la base de données, penser à changer le chemin du fichier
    Database.java -> path
 */

import java.io.*;
import java.util.ArrayList;

public class Database {
    //Lien vers lequel est stocké la Database
    public static String path = "C:\\Users\\pc\\IdeaProjects\\CalendrierServeur\\src\\main\\resources\\database.ser";
    public static int taille = 0;
    //Liste des rendez vous
    public static ArrayList<RendezVous> liste = new ArrayList<>();

    //Sauvegarde de la liste des rdv dans le fichier
    public static void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream(Database.path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(liste);
            System.out.println("Rendez-vous enregistré sur la base");
        } catch (IOException e) {
            System.out.println("Rendez-vous non synchronisé");
            e.printStackTrace();
        }
    }

    //Lecture du fichier de base de données
    public static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Database.path))) {
            Database.liste = (ArrayList<RendezVous>) ois.readObject();
            Database.taille = Database.liste.size();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
