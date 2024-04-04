package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import java.util.ArrayList;

public interface UtilisateurRepositoryInterface {

    public void close();

    public boolean createUtilisateur(int id, String name, String status, String email, String password, String adress);

    public boolean updateUtilisateurName(int id, String name);

    public boolean updateUtilisateurStatus(int id, String status);

    public boolean updateUtilisateurEmail(int id, String email);

    public boolean updateUtilisateurPassword(int id, String password);

    public boolean updateUtilisateurAddress(int id, String adress);

    public boolean deleteUtilisateur(int id);

    public Utilisateur getUtilisateur(int id);

    public ArrayList<Utilisateur> getAllUtilisateurs();

}
