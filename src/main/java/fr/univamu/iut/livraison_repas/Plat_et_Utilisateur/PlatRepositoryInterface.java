package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import java.util.ArrayList;

public interface PlatRepositoryInterface {

    public void close();

    public boolean createPlat(int id, String name, boolean availability, String description, int price);

    public boolean updatePlatName(int id, String name);

    public boolean updatePlatAvailability(int id, String availability);

    public boolean updatePlatDescription(int id, String description);

    public boolean updatePlatPrice(int id, int price);

    public boolean deletePlat(int id);

    public Plat getPlat(int id);

    public ArrayList<Plat> getAllPlats();

}