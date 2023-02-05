package df.Jersey.server;

/*
    PROGRAMME pour le PROJET d'ASI
    COTE SERVEUR
    DUCHANOIS Benjamin
    JORGE William
    Master 1 Informatique

    Pour accèder à la base de données, penser à changer le chemin du fichier
    Database.java -> path
 */

import df.Jersey.element.Database;
import df.Jersey.element.RendezVous;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rdv")
public class Calendrier {

    //Retourne le nombre de Rendez-vous enregistrés
    @GET
    @Path("/getNbRdv")
    @Produces ( MediaType.APPLICATION_JSON )
    public int getNbRdv() {
        //Synchronise la Database avec la sauvegarde
        Database.loadFromFile();
        return Database.taille;
    }

    //Retourne les informations du "idRdv"ème RendezVous
    @GET
    @Path("/get/{idRdv}")
    @Produces ( MediaType.APPLICATION_JSON )
    public RendezVous getRdv(@PathParam("idRdv") int idRdv) {
        return Database.liste.get(idRdv);
    }

    //Met à jour le rendez vous reçu avec ses nouvelles valeurs
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

    //Ajoute le rendez vous reçu
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

    //Supprime le rdv reçu
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
