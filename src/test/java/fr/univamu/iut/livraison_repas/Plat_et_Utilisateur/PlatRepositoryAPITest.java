package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class PlatRepositoryAPITest {

    private PlatRepositoryAPI platRepository;

    @Before
    public void setCo() throws Exception {
        platRepository = new PlatRepositoryAPI("jdbc:mariadb://mysql-maxime83.alwaysdata.net/maxime83_plats_et_utilisateurs_db", "maxime83_peu", "P14ts3tut111s4t3urs!");
    }

    @After
    public void endCo() throws Exception {
        platRepository.close();
    }

    @Test
    public void testCreatePlat() {
        assertTrue(platRepository.createPlat(1, "Plat Test", true, "Description du plat", 10));
        Plat plat = platRepository.getPlat(1);
        assertNotNull(plat);
        assertEquals("Plat Test", plat.getName());
    }

    @Test
    public void testUpdatePlatName() {
        platRepository.createPlat(2, "Plat à mettre à jour", true, "Description du plat", 20);
        assertTrue(platRepository.updatePlatName(2, "Nouveau nom du plat"));
        Plat plat = platRepository.getPlat(2);
        assertNotNull(plat);
        assertEquals("Nouveau nom du plat", plat.getName());
    }

    @Test
    public void testUpdatePlatAvailability() {
        platRepository.createPlat(3, "Plat avec disponibilité à mettre à jour", true, "Description du plat", 30);
        assertTrue(platRepository.updatePlatAvailability(3, "false"));
        Plat plat = platRepository.getPlat(3);
        assertNotNull(plat);
        assertEquals("false", plat.getAvailability());
    }

    @Test
    public void testUpdatePlatDescription() {
        platRepository.createPlat(4, "Plat avec description à mettre à jour", true, "Description initiale", 40);
        assertTrue(platRepository.updatePlatDescription(4, "Nouvelle description du plat"));
        Plat plat = platRepository.getPlat(4);
        assertNotNull(plat);
        assertEquals("Nouvelle description du plat", plat.getDescription());
    }

    @Test
    public void testUpdatePlatPrice() {
        platRepository.createPlat(5, "Plat avec prix à mettre à jour", true, "Description du plat", 50);
        assertTrue(platRepository.updatePlatPrice(5, 55));
        Plat plat = platRepository.getPlat(5);
        assertNotNull(plat);
        assertEquals(55, plat.getPrice());
    }

    @Test
    public void testDeletePlat() {
        platRepository.createPlat(6, "Plat à supprimer", true, "Description du plat", 60);
        assertTrue(platRepository.deletePlat(6));
        assertNull(platRepository.getPlat(6));
    }

    @Test
    public void testGetPlat() {
        platRepository.createPlat(7, "Plat à récupérer", true, "Description du plat", 70);
        Plat plat = platRepository.getPlat(7);
        assertNotNull(plat);
        assertEquals("Plat à récupérer", plat.getName());
    }

    @Test
    public void testGetAllPlats() {
        platRepository.createPlat(8, "Plat 1", true, "Description du plat", 80);
        platRepository.createPlat(9, "Plat 2", true, "Description du plat", 90);
        platRepository.createPlat(10, "Plat 3", true, "Description du plat", 100);

        ArrayList<Plat> allPlats = platRepository.getAllPlats();
        assertEquals(3, allPlats.size());
    }
}

