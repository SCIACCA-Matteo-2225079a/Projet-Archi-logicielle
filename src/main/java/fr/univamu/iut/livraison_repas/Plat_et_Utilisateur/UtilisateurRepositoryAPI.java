package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import java.io.Closeable;
import java.sql.*;
import java.util.ArrayList;

public class UtilisateurRepositoryAPI implements UtilisateurRepositoryInterface, Closeable {

    protected Connection pEUDbCo;

    /**
     * Constructeur connexion base
     * @param pEUDbURL url base plats et utilisateurs
     * @param pEUDbUser nom utilisateur de la base
     * @param pEUDbUserPwd mot de passe utilisateur de la base
     */

    public UtilisateurRepositoryAPI(String pEUDbURL, String pEUDbUser, String pEUDbUserPwd) throws java.sql.SQLException, java.lang.ClassNotFoundException {
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
    public boolean createUtilisateur(int id, String name, String status, String email, String password, String address) {
        String query = "INSERT INTO Utilisateur VALUES (id, name, status, email, password, address)";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, status);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.setString(6, address);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean updateUtilisateurName(int id, String name) {
        String query = "UPDATE Utilisateur SET name=? WHERE id=?";
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
    public boolean updateUtilisateurStatus(int id, String status) {
        String query = "UPDATE Utilisateur SET status=? WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setString(1, status);
            ps.setInt(2, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean updateUtilisateurEmail(int id, String email) {
        String query = "UPDATE Utilisateur SET email=? WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setString(1, email);
            ps.setInt(2, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean updateUtilisateurPassword(int id, String password) {
        String query = "UPDATE Utilisateur SET password=? WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setString(1, password);
            ps.setInt(2, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean updateUtilisateurAddress(int id, String address) {
        String query = "UPDATE Utilisateur SET address=? WHERE id=?";
        int nbRowModified = 0;
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setString(1, address);
            ps.setInt(2, id);
            nbRowModified = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (nbRowModified != 0);
    }

    @Override
    public boolean deleteUtilisateur(int id) {
        String query = "DELETE FROM Utilisateur WHERE id=?";
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
    public Utilisateur getUtilisateur(int id) {
        Utilisateur selectedUtilisateur = null;
        String query = "SELECT * FROM Utilisateur WHERE id=?";
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if(result.next())
            {
                String name = result.getString("name");
                String status = result.getString("status");
                String email = result.getString("email");
                String password = result.getString("password");
                String address = result.getString("address");
                selectedUtilisateur = new Utilisateur(id, name, status, email, password, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return selectedUtilisateur;
    }

    @Override
    public ArrayList<Utilisateur> getAllUtilisateurs() {
        ArrayList<Utilisateur> listUtilisateurs;
        String query = "SELECT * FROM Utilisateur";
        try (PreparedStatement ps = pEUDbCo.prepareStatement(query)){
            ResultSet result = ps.executeQuery();
            listUtilisateurs = new ArrayList<>();
            while (result.next())
            {
                int id = result.getInt("id");
                String name = result.getString("name");
                String status = result.getString("status");
                String email = result.getString("email");
                String password = result.getString("password");
                String address = result.getString("address");
                Utilisateur currentUtilisateur = new Utilisateur(id, name, status, email, password, address);
                listUtilisateurs.add(currentUtilisateur);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUtilisateurs;
    }
}
