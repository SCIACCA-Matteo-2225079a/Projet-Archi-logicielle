package fr.univamu.iut.livraison_repas.Plats_et_Utilisateurs;

public class Plat {
    /* Nom du plat */
    protected String name;

    /* Disponibilité du plat */
    protected boolean availability;

    /* Description du plat */
    protected String description;

    /* Prix du plat en euros */
    protected int price;

    /* Constructeur par défaut */
    public Plat(){}

    /**
     * Constructeur du plat
     * @param name nom du plat
     * @param availability disponibilité du plat
     * @param description description du plat
     * @param price prix du plat en euros
     */
    public Plat(String name, boolean availability, String description, int price) {
        this.name = name;
        this.availability = availability;
        this.description = description;
        this.price = price;
    }

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
    public boolean getAvailability() {
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

    public String toString() {
        return "Plat{" +
                "name='" + name + '\'' +
                "availability='" + availability + '\'' +
                "description='" + description + '\'' +
                "price='" + price + '}';
    }
}
