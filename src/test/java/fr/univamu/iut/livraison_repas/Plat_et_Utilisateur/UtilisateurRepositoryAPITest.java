package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class UtilisateurRepositoryAPITest {

    private UtilisateurRepositoryAPI utilisateurRepository;

    @Before
    public void setCo() throws Exception {
        utilisateurRepository = new UtilisateurRepositoryAPI("jdbc:mariadb://mysql-maxime83.alwaysdata.net/maxime83_plats_et_utilisateurs_db", "maxime83_peu", "P14ts3tut111s4t3urs!");
    }

    @After
    public void endCo() throws Exception {
        utilisateurRepository.close();
    }

    @Test
    public void testCreateUtilisateur() {
        assertTrue(utilisateurRepository.createUtilisateur(1, "Utilisateur Test", "actif", "test@example.com", "motdepasse", "adresse"));
        Utilisateur utilisateur = utilisateurRepository.getUtilisateur(1);
        assertNotNull(utilisateur);
        assertEquals("Utilisateur Test", utilisateur.getName());
    }

    @Test
    public void testUpdateUtilisateurName() {
        utilisateurRepository.createUtilisateur(2, "Utilisateur à mettre à jour", "actif", "test2@example.com", "password", "adresse");
        assertTrue(utilisateurRepository.updateUtilisateurName(2, "Nouveau nom de l'utilisateur"));
        Utilisateur utilisateur = utilisateurRepository.getUtilisateur(2);
        assertNotNull(utilisateur);
        assertEquals("Nouveau nom de l'utilisateur", utilisateur.getName());
    }

    @Test
    public void testUpdateUtilisateurStatus() {
        utilisateurRepository.createUtilisateur(3, "Utilisateur avec status à mettre à jour", "actif", "test3@example.com", "password", "adresse");
        assertTrue(utilisateurRepository.updateUtilisateurStatus(3, "inactif"));
        Utilisateur utilisateur = utilisateurRepository.getUtilisateur(3);
        assertNotNull(utilisateur);
        assertEquals("inactif", utilisateur.getStatus());
    }

    @Test
    public void testUpdateUtilisateurEmail() {
        utilisateurRepository.createUtilisateur(4, "Utilisateur avec email à mettre à jour", "actif", "test4@example.com", "password", "adresse");
        assertTrue(utilisateurRepository.updateUtilisateurEmail(4, "nouveauemail@example.com"));
        Utilisateur utilisateur = utilisateurRepository.getUtilisateur(4);
        assertNotNull(utilisateur);
        assertEquals("nouveauemail@example.com", utilisateur.getEmail());
    }

    @Test
    public void testUpdateUtilisateurPassword() {
        utilisateurRepository.createUtilisateur(5, "Utilisateur avec mot de passe à mettre à jour", "actif", "test5@example.com", "password", "adresse");
        assertTrue(utilisateurRepository.updateUtilisateurPassword(5, "nouveaumotdepasse"));
        Utilisateur utilisateur = utilisateurRepository.getUtilisateur(5);
        assertNotNull(utilisateur);
        assertEquals("nouveaumotdepasse", utilisateur.getPassword());
    }

    @Test
    public void testUpdateUtilisateurAddress() {
        utilisateurRepository.createUtilisateur(6, "Utilisateur avec adresse à mettre à jour", "actif", "test6@example.com", "password", "adresse");
        assertTrue(utilisateurRepository.updateUtilisateurAddress(6, "nouvelle adresse"));
        Utilisateur utilisateur = utilisateurRepository.getUtilisateur(6);
        assertNotNull(utilisateur);
        assertEquals("nouvelle adresse", utilisateur.getAddress());
    }

    @Test
    public void testDeleteUtilisateur() {
        utilisateurRepository.createUtilisateur(7, "Utilisateur à supprimer", "actif", "test7@example.com", "password", "adresse");
        assertTrue(utilisateurRepository.deleteUtilisateur(7));
        assertNull(utilisateurRepository.getUtilisateur(7));
    }

    @Test
    public void testGetAllUtilisateurs() {
        utilisateurRepository.createUtilisateur(8, "Utilisateur 1", "actif", "test8@example.com", "password", "adresse");
        utilisateurRepository.createUtilisateur(9, "Utilisateur 2", "actif", "test9@example.com", "password", "adresse");
        utilisateurRepository.createUtilisateur(10, "Utilisateur 3", "actif", "test10@example.com", "password", "adresse");

        ArrayList<Utilisateur> allUtilisateurs = utilisateurRepository.getAllUtilisateurs();
        assertEquals(3, allUtilisateurs.size());
    }

    @Test
    public void testGetUtilisateur() {
        utilisateurRepository.createUtilisateur(11, "Utilisateur à récupérer", "actif", "test11@example.com", "password", "adresse");
        Utilisateur utilisateur = utilisateurRepository.getUtilisateur(11);
        assertNotNull(utilisateur);
        assertEquals("Utilisateur à récupérer", utilisateur.getName());
    }
}

