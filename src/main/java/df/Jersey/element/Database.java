package df.Jersey.element;

import java.util.Date;

public class Database {

    public static RendezVous [] liste = {
            new RendezVous(0, "CM ASI", "CM de 2h avec decouverte de matière", 0, 8, 30),
            new RendezVous(1, "Entretien CGI", "Entretien avec la CGI au siège principal", 1, 10, 30),
            new RendezVous(2, "Dejeuner", "Pause dejeuner", 3, 12, 0)
    };

    public static int taille = 3;
}
