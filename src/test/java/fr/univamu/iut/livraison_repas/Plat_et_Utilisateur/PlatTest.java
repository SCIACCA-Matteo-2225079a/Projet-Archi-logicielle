package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlatTest {

    private Plat plat;

    @Before
    public void createPlat() throws Exception {
        plat = new Plat(1, "Test Plat", "disponible", "Description du plat", 10);
    }

    @Test
    public void testGetId() {
        assertEquals(1, plat.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Plat", plat.getName());
    }

    @Test
    public void testGetAvailability() {
        assertEquals("disponible", plat.getAvailability());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Description du plat", plat.getDescription());
    }

    @Test
    public void testGetPrice() {
        assertEquals(10, plat.getPrice());
    }

    @Test
    public void testToString() {
        String expectedString = "Plat{id='1', name='Test Plat', availability='disponible', description='Description du plat', price=10}";
        assertEquals(expectedString, plat.toString());
    }
}
