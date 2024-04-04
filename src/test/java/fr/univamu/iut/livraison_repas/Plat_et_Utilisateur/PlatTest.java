package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlatTest {

    @Test
    public void testPlat() {
        Plat plat = new Plat(0, "Tourte", "oui", "Description d'une tourte.", 10);
        assertEquals(0, plat.getId());
        assertEquals("Tourte", plat.getName());
        assertEquals("oui", plat.getAvailability());
        assertEquals("Description d'une tourte.", plat.getDescription());
        assertEquals(10, plat.getPrice());
    }

    @Test
    public void testPlatToString() {
        Plat plat = new Plat(0, "Tourte", "disponible", "Description d'une tourte.", 10);
        String expectedString = "Plat{id='0', name='Tourte', availability='oui', description='Description d'une tourte', price=10}";
        assertEquals(expectedString, plat.toString());
    }
}
