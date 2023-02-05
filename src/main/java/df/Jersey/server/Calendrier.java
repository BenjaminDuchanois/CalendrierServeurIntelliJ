package df.Jersey.server;

import df.Jersey.element.Database;
import df.Jersey.element.RendezVous;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rdv")
public class Calendrier {

    @GET
    @Path("/getNbRdv")
    @Produces ( MediaType.APPLICATION_JSON )
    public int getNbRdv() {
        //Synchronise la Database avec la sauvegarde
        Database.loadFromFile();
        return Database.taille;
    }

    @GET
    @Path("/get/{idRdv}")
    @Produces ( MediaType.APPLICATION_JSON )
    public RendezVous getRdv(@PathParam("idRdv") int idRdv) {
        return Database.liste.get(idRdv);
    }

    @PUT
    @Path("/update")
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces ( MediaType.TEXT_PLAIN )
    public boolean updateRdv(RendezVous rdv) {
        System.out.println( "Reçu : Modification de rdv :" + rdv);
        Database.liste.set(rdv.getIdRdv(), rdv);
        Database.saveToFile();
        return true;
    }

    @PUT
    @Path("/add")
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces ( MediaType.TEXT_PLAIN )
    public boolean addRdv(RendezVous rdv) {
        System.out.println( "Reçu : Ajout de rdv :" + rdv);
        int newId = Database.taille;
        rdv.setIdRdv(newId);
        Database.liste.add(rdv);
        Database.taille = Database.liste.size();
        Database.saveToFile();
        return true;
    }

    @PUT
    @Path("/del")
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces ( MediaType.TEXT_PLAIN )
    public boolean delRdv(RendezVous rdv) {
        System.out.println("Reçu suppression pour :" + rdv);
        Database.liste.remove(rdv.getIdRdv());
        Database.taille--;
        Database.saveToFile();
        return true;
    }

}
