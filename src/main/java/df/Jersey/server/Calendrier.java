package df.Jersey.server;

import df.Jersey.element.Database;
import df.Jersey.element.RendezVous;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Array;
import java.util.Arrays;

@Path("/rdv")
public class Calendrier {

    @GET
    @Path("/getNbRdv")
    @Produces ( MediaType.APPLICATION_JSON )
    public int getNbRdv() {
        return Database.taille;
    }

    @GET
    @Path("/get/{idRdv}")
    @Produces ( MediaType.APPLICATION_JSON )
    public RendezVous getRdv(@PathParam("idRdv") int idRdv) {
        return Database.liste[idRdv];
    }

    @GET
    @Path("/getall")
    @Produces ( MediaType.APPLICATION_JSON )
    public String getListeRdv() {
        return Database.liste.toString();
    }

    @PUT
    @Path("/update")
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces ( MediaType.TEXT_PLAIN )
    public boolean updateRdv(RendezVous rdv) {
        System.out.println( "Receive update for " + rdv);
        Database.liste[rdv.getIdRdv()] = rdv;
        return true;
    }

    @PUT
    @Path("/add")
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces ( MediaType.TEXT_PLAIN )
    public boolean addRdv(RendezVous rdv) {
        System.out.println( "Receive new rdv :" + rdv);
        rdv.setIdRdv(Database.taille);
        Database.taille++;
        Database.liste = Arrays.copyOf(Database.liste, Database.taille);
        Database.liste[Database.taille-1] = rdv;
        return true;
    }

}
