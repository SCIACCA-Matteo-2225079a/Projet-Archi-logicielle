package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlatEtUtilisateurConnection {
    private static final String pEUDbURL = "jdbc:mariadb://mysql-maxime83.alwaysdata.net/maxime83_plats_et_utilisateurs_db";
    private static final String pEUDbUser = "maxime83_peu";
    private static final String pEUDbUserPwd = "P14ts3tut111s4t3urs!";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(pEUDbURL, pEUDbUser, pEUDbUserPwd);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

