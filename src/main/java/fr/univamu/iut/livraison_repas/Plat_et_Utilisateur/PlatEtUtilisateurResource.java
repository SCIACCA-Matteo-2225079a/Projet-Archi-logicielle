package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

/**
 * Ressource associée aux livres
 * (point d'accès de l'API REST)
 */
@Path("/books")
@ApplicationScoped
public class PlatEtUtilisateurResource {

    /**
     * Service utilisé pour accéder aux données des livres et récupérer/modifier leurs informations
     */
    private PlatEtUtilisateurService service;

    /**
     * Constructeur par défaut
     */
    public PlatEtUtilisateurResource(){}

    /**
     * Constructeur permettant d'initialiser le service avec une interface d'accès aux données
     * @param platRepo objet implémentant l'interface d'accès aux données
     * @param utilisateurRepo objet implémentant l'interface d'accès aux données
     */
    public @Inject PlatEtUtilisateurResource(PlatRepositoryInterface platRepo, UtilisateurRepositoryInterface utilisateurRepo){
        this.service = new PlatEtUtilisateurService(platRepo, utilisateurRepo) ;
    }

    /**
     * Constructeur permettant d'initialiser le service d'accès aux plats et utilisateurs
     */
    public PlatEtUtilisateurResource(PlatEtUtilisateurService service){
        this.service = service;
    }

    /**
     * Enpoint permettant de publier de tous les plats enregistrés
     * @return la liste des plats (avec leurs informations) au format JSON
     */
    @GET
    @Produces("application/json")
    public String getAllPlats() {

        return service.getAllPlatsJSON();
    }

    /**
     * Endpoint permettant de publier les informations d'un plat dont la référence est passée paramètre dans le chemin
     * @param id identifiant du plat recherché
     * @return les informations du plat recherché au format JSON
     */
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getPlat( @PathParam("id") int id){

        String result = service.getPlatJSON(id);

        // si le plat n'a pas été trouvé
        if( result == null )
            throw new NotFoundException();

        return result;
    }

    /**
     * Enpoint permettant de publier de tous les utilisateurs enregistrés
     * @return la liste des utilisateurs (avec leurs informations) au format JSON
     */
    @GET
    @Produces("application/json")
    public String getAllUtilisateurs() {

        return service.getAllUtilisateursJSON();
    }

    /**
     * Endpoint permettant de publier les informations d'un utilisateur dont la référence est passée paramètre dans le chemin
     * @param id identifiant de l'utilisateur recherché
     * @return les informations du plat recherché au format JSON
     */
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getUtilisateur( @PathParam("id") int id){

        String result = service.getUtilisateurJSON(id);

        // si l'utilisateur n'a pas été trouvé
        if( result == null )
            throw new NotFoundException();

        return result;
    }
}

