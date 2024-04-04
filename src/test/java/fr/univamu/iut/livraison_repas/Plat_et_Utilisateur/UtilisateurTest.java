package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilisateurTest {

    private Utilisateur utilisateur;

    @Before
    public void createUtilisateur() throws Exception {
        utilisateur = new Utilisateur(1, "Test Utilisateur", "normal", "test@example.com", "password123", "123 Rue de l'Utilisateur");
    }

    @Test
    public void testGetId() {
        assertEquals(1, utilisateur.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Utilisateur", utilisateur.getName());
    }

    @Test
    public void testGetStatus() {
        assertEquals("normal", utilisateur.getStatus());
    }

    @Test
    public void testGetEmail() {
        assertEquals("test@example.com", utilisateur.getEmail());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", utilisateur.getPassword());
    }

    @Test
    public void testGetAddress() {
        assertEquals("123 Rue de l'Utilisateur", utilisateur.getAddress());
    }

    @Test
    public void testToString() {
        String expectedString = "Utilisateur{id='1', name='Test Utilisateur', status='normal', email='test@example.com', password='password123', address=123 Rue de l'Utilisateur'}";
        assertEquals(expectedString, utilisateur.toString());
    }
}
