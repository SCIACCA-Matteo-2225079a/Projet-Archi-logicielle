package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("/api")
@ApplicationScoped
public class PlatEtUtilisateurComponent extends Application {

    @Produces
    public PlatRepositoryInterface openDbConnectionForPlat(){
        PlatRepositoryAPI db = null;
        try{
            db = new PlatRepositoryAPI("jdbc:mariadb://mysql-maxime83.alwaysdata.net/maxime83_plats_et_utilisateurs_db", "maxime83_peu", "P14ts3tut111s4t3urs!");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return db;
    }

    @Produces
    public UtilisateurRepositoryInterface openDbConnectionForUtilisateur(){
        UtilisateurRepositoryAPI db = null;
        try{
            db = new UtilisateurRepositoryAPI("jdbc:mariadb://mysql-maxime83.alwaysdata.net/maxime83_plats_et_utilisateurs_db", "maxime83_peu", "P14ts3tut111s4t3urs!");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return db;
    }

    public void closeDbConnectionForPlat(@Disposes PlatRepositoryInterface platRepo) {
        platRepo.close();
    }

    public void closeDbConnectionForUtilisateur(@Disposes UtilisateurRepositoryInterface utilisateurRepo) {
        utilisateurRepo.close();
    }

}
