package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.util.ArrayList;


/**
 * Classe utilisée pour récupérer les informations nécessaires à la ressource
 * (permet de dissocier ressource et mode d'éccès aux données)
 */
public class PlatEtUtilisateurService {

    /**
     * Objet permettant d'accéder au dépôt où sont stockées les informations sur les livres
     */
    protected PlatRepositoryInterface platRepo;
    protected UtilisateurRepositoryInterface utilisateurRepo;

    /**
     * Constructeur permettant d'injecter l'accès aux données
     * @param platRepo objet implémentant l'interface d'accès aux données
     * @param utilisateurRepo objet implémentant l'interface d'accès aux données
     */
    public PlatEtUtilisateurService(PlatRepositoryInterface platRepo, UtilisateurRepositoryInterface utilisateurRepo) {
        this.platRepo = platRepo;
        this.utilisateurRepo = utilisateurRepo;
    }

    /**
     * Méthode retournant les informations sur les plats au format JSON
     * @return une chaîne de caractère contenant les informations au format JSON
     */
    public String getAllPlatsJSON(){

        ArrayList<Plat> allPlats = platRepo.getAllPlats();

        // création du json et conversion de la liste de plats
        String result = null;
        try( Jsonb jsonb = JsonbBuilder.create()){
            result = jsonb.toJson(allPlats);
        }
        catch (Exception e){
            System.err.println( e.getMessage() );
        }

        return result;
    }

    /**
     * Méthode retournant au format JSON les informations sur un plat recherché
     * @param id l'identifiant du plat recherché
     * @return une chaîne de caractère contenant les informations au format JSON
     */
    public String getPlatJSON(int id){
        String result = null;
        Plat myPlat = platRepo.getPlat(id);

        // si le plat a été trouvé
        if(myPlat != null) {

            // création du json et conversion du livre
            try (Jsonb jsonb = JsonbBuilder.create()) {
                result = jsonb.toJson(myPlat);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

    /**
     * Méthode retournant les informations sur les utilisateurs au format JSON
     * @return une chaîne de caractère contenant les informations au format JSON
     */
    public String getAllUtilisateursJSON(){

        ArrayList<Utilisateur> allUtilisateurs = utilisateurRepo.getAllUtilisateurs();

        // création du json et conversion de la liste d'utilisateurs
        String result = null;
        try( Jsonb jsonb = JsonbBuilder.create()){
            result = jsonb.toJson(allUtilisateurs);
        }
        catch (Exception e){
            System.err.println( e.getMessage() );
        }

        return result;
    }

    /**
     * Méthode retournant au format JSON les informations sur un utilisateur recherché
     * @param id l'identifiant de l'utilisateur recherché
     * @return une chaîne de caractère contenant les informations au format JSON
     */
    public String getUtilisateurJSON(int id){
        String result = null;
        Utilisateur myUtilisateur = utilisateurRepo.getUtilisateur(id);

        // si l'utilisateur a été trouvé
        if(myUtilisateur != null) {

            // création du json et conversion de l'utilisateur
            try (Jsonb jsonb = JsonbBuilder.create()) {
                result = jsonb.toJson(myUtilisateur);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return result;
    }

}

