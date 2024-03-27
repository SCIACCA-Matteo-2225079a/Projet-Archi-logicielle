package fr.univamu.iut.livraison_repas.Plats_et_Utilisateurs;

import java.util.ArrayList;

public class Utilisateur {

    /* Nom de l'utilisateur */
    protected String username;

    /* Statut de l'utilisateur (soit normal, soit admin) */
    protected String userStatus;

    /* Mot de passe de l'utilisateur */
    protected String password;

    /* Adresse de l'utilisateur */
    protected String adress;

    /* Liste des menus de l'utilisateur */
    protected ArrayList<Integer> menus;

    /* Liste des commandes de l'utilisateur */
    protected ArrayList<Integer> commandes;

    /* Dépense totale en euros de l'utilisateur */
    protected int totalExpense;

    /* Constructeur par défaut */
    public Utilisateur(){}

    /**
     * Constructeur de l'utilisateur
     * @param username nom de l'utilisateur
     * @param userStatus statut de l'utilisateur
     * @param password mot de passe de l'utilisateur
     * @param adress adresse de l'utilisateur
     * @param menus liste des menus de l'utilisateur
     * @param commandes liste des commandes de l'utilisateur
     * @param totalExpense dépense totale en euros de l'utilisateur
     */

    public Utilisateur(String username, String userStatus, String password, String adress,
                       ArrayList<Integer> menus, ArrayList<Integer> commandes, int totalExpense) {
        this.username = username;
        this.userStatus = userStatus;
        this.password = password;
        this.adress = adress;
        this.menus = menus;
        this.commandes = commandes;
        this.totalExpense = totalExpense;
    }

    /**
     *
     * @return une chaîne de caractères avec le nom de l'utilisateur
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return une chaîne de caractères avec le statut de l'utilisateur (normal ou admin)
     */
    public String userStatus() {
        return userStatus;
    }

    /**
     *
     * @return une chaîne de caractères avec le mot de passe de l'utilisateur
     */
    public String password() {
        return password;
    }

    /**
     *
     * @return une chaîne de caractètes avec l'adresse de l'utilisateur
     */
    public String adress() {
        return adress;
    }

    /**
     *
     * @return une liste d'entiers avec les ids des menus de l'utilisateur
     */
    public ArrayList<Integer> menus() {
        return menus;
    }

    /**
     *
     * @return une liste d'entiers avec les ids des commandes de l'utilisateur
     */
    public ArrayList<Integer> commandes() {
        return commandes;
    }

    /**
     *
     * @return un entier avec la dépense totale de l'utilisateur
     */
    public int totalExpense() {
        return totalExpense;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "username='" + username + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", password='" + password + '\'' +
                ", adress='" + adress + '\'' +
                ", menus='" + menus + '\'' +
                ", commandes='" + commandes + '\'' +
                ", totalExpense=" + totalExpense + '}';
    }

}
