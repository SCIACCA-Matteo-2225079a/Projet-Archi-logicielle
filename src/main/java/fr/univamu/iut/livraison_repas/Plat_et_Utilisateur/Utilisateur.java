package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

public class Utilisateur {

    /* Identifiant de l'utilisateur */
    protected int id;

    /* Nom de l'utilisateur */
    protected String name;

    /* Statut de l'utilisateur (soit normal, soit admin) */
    protected String status;

    /* Email de l'utilisateur */
    protected String email;

    /* Mot de passe de l'utilisateur */
    protected String password;

    /* Adresse de l'utilisateur */
    protected String address;

    /* Constructeur par défaut */
    public Utilisateur(){}

    /**
     * Constructeur de l'utilisateur
     * @param id identifiant de l'utilisateur
     * @param name nom de l'utilisateur
     * @param status statut de l'utilisateur
     * @param email email de l'utilisateur
     * @param password mot de passe de l'utilisateur
     * @param address adresse de l'utilisateur
     */

    public Utilisateur(int id, String name, String status, String email, String password, String address) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    /**
     *
     * @return un entier avec l'identifiant de l'utilisateur
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return une chaîne de caractères avec le nom de l'utilisateur
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return une chaîne de caractères avec le statut de l'utilisateur (normal ou admin)
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @return une chaîne de caractères avec l'email de l'utilisateur
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return une chaîne de caractères avec le mot de passe de l'utilisateur
     */
    public String getPassword() { return password; }

    /**
     *
     * @return une chaîne de caractères avec l'adresse de l'utilisateur
     */
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address + '\'' + '}';
    }

}
