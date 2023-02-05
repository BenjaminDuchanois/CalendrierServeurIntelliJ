package df.Jersey.element;

import java.io.*;
import java.util.ArrayList;

public class Database {
    public static int taille = 0;
    public static ArrayList<RendezVous> liste = new ArrayList<>();

    public static void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\pc\\IdeaProjects\\CalendrierServeur\\src\\main\\resources\\database.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(liste);
            System.out.println("Message enregistré");
        } catch (IOException e) {
            System.out.println("Pas enregistré");
            e.printStackTrace();
        }
    }

    public static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\pc\\IdeaProjects\\CalendrierServeur\\src\\main\\resources\\database.ser"))) {
            Database.liste = (ArrayList<RendezVous>) ois.readObject();
            Database.taille = Database.liste.size();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
