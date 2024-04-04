package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

public class Plat {

    /* Identifiant du plat */
    protected int id;

    /* Nom du plat */
    protected String name;

    /* Disponibilité du plat */
    protected String availability;

    /* Description du plat */
    protected String description;

    /* Prix du plat en euros */
    protected int price;

    /* Constructeur par défaut */
    public Plat(){}

    /**
     * Constructeur du plat
     * @param id identifiant du plat
     * @param name nom du plat
     * @param availability disponibilité du plat
     * @param description description du plat
     * @param price prix du plat en euros
     */
    public Plat(int id, String name, String availability, String description, int price) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.description = description;
        this.price = price;
    }

    /**
     *
     * @return une entier avec l'identifiant du plat
     */
    public int getId() { return id; }

    /**
     *
     * @return une chaîne de caractères avec le nom du plat
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return un bouléen avec la disponibilité du plat
     */
    public String getAvailability() {
        return availability;
    }

    /**
     *
     * @return une chaîne de caractères avec la description du plat
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return un entier avec le prix du plat
     */
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Plat{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", availability='" + availability + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price + '}';
    }
}
