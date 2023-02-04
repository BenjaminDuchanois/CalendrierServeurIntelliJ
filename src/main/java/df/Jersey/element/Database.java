package df.Jersey.element;

import java.util.ArrayList;

public class Database {

    public static ArrayList<RendezVous> liste = new ArrayList<>();

    static {
        liste.add(new RendezVous(0, "CM ASI", "CM de 2h avec decouverte de matière", 0, 8, 30));
        liste.add(new RendezVous(1, "Entretien CGI", "Entretien avec la CGI au siège principal", 1, 10, 30));
        liste.add(new RendezVous(2, "Dejeuner", "Pause dejeuner", 3, 12, 0));
    }

    public static int taille = liste.size();
}
