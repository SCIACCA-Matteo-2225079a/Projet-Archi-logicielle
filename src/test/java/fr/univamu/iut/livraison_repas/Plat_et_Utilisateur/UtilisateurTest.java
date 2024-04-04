package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilisateurTest {

    @Test
    public void testPlat() {
        Utilisateur utilisateur = new Utilisateur(0, "MartinDupont", "normal",
                "martin.dupont@example.com", "M4rt1nDup0nt!", "1 rue Sans Nom, 00000 Une Ville");
        assertEquals(0, utilisateur.getId());
        assertEquals("MartinDupont", utilisateur.getName());
        assertEquals("normal", utilisateur.getStatus());
        assertEquals("martin.dupont@example.com", utilisateur.getEmail());
        assertEquals("M4rt1nDup0nt!", utilisateur.getPassword());
        assertEquals("1 rue Sans Nom, 00000 Une Ville", utilisateur.getAddress());
    }

    @Test
    public void testPlatToString() {
        Utilisateur utilisateur = new Utilisateur(0, "MartinDupont", "normal",
                "martin.dupont@example.com", "M4rt1nDup0nt!", "1 rue Sans Nom, 00000 Une Ville");
        String expectedString = "Utilisateur{id='0', name='MartinDupont', status='normal', email='martin.dupont@example.com', " +
                "password='M4rt1nDup0nt!', address='1 rue Sans Nom, 00000 Une Ville'}";
        assertEquals(expectedString, utilisateur.toString());
    }
}
