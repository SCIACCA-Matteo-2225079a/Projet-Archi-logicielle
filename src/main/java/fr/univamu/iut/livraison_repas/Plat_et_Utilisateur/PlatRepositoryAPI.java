package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;

public class PlatRepositoryAPI implements PlatRepositoryInterface, Closeable {

    protected Connection pEUDbCo;

    /**
     * Constructeur connexion base
     * @param pEUDbURL url base plats et utilisateurs
     * @param pEUDbUser nom utilisateur de la base
     * @param pEUDbUserPwd mot de passe utilisateur de la base
     */

    public PlatRepositoryAPI(String pEUDbURL, String pEUDbUser, String pEUDbUserPwd) throws java.sql.SQLException, java.lang.ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        pEUDbCo = DriverManager.getConnection( pEUDbURL, pEUDbUser, pEUDbUserPwd) ;
    }

    @Override
    public void close() {
        try {
            pEUDbCo.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean createPlat(int id, String name, boolean availability, String description, int price) {
        String query = "INSERT INTO Plat VALUES (id, name, availability, description, price)";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setBoolean(3, availability);
            ps.setString(4, description);
            ps.setInt(5, price);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean updatePlatName(int id, String name) {
        String query = "UPDATE Plat SET name=? WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setString(1, name);
            ps.setInt(2, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean updatePlatAvailability(int id, String availability) {
        String query = "UPDATE Plat SET availability=? WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setString(1, availability);
            ps.setInt(2, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean updatePlatDescription(int id, String description) {
        String query = "UPDATE Plat SET description=? WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setString(1, description);
            ps.setInt(2, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean updatePlatPrice(int id, int price) {
        String query = "UPDATE Plat SET price=? WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setInt(1, price);
            ps.setInt(2, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean deletePlat(int id) {
        String query = "DELETE FROM Plat WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)) {
            ps.setInt(1, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public Plat getPlat(int id) {
        Plat selectedPlat = null;
        String query = "SELECT * FROM Plat WHERE id=?";
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                String name = result.getString("name");
                String availability = result.getString("availability");
                String description = result.getString("description");
                int price = result.getInt("price");
                selectedPlat = new Plat(id, name, availability, description, price);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selectedPlat;
    }

    @Override
    public ArrayList<Plat> getAllPlats() {
        ArrayList<Plat> listPlats;
        String query = "SELECT * FROM Plat";
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)) {
            ResultSet result = ps.executeQuery();
            listPlats = new ArrayList<>();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String availability = result.getString("availability");
                String description = result.getString("description");
                int price = result.getInt("description");
                Plat currentPlat = new Plat(id, name, availability, description, price);
                listPlats.add(currentPlat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listPlats;
    }
}
