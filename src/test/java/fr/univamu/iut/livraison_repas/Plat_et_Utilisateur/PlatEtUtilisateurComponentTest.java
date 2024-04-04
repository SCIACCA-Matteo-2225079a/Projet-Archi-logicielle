package fr.univamu.iut.livraison_repas.Plat_et_Utilisateur;

import static org.junit.Assert.*;
import org.junit.*;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.ws.rs.ApplicationPath;

public class PlatEtUtilisateurComponentTest {

    private PlatEtUtilisateurComponent component;

    @Before
    public void setComponent() throws Exception {
        component = new PlatEtUtilisateurComponent();
    }

    @Test
    public void testApplicationPath() {
        ApplicationPath applicationPathAnnotation = PlatEtUtilisateurComponent.class.getAnnotation(ApplicationPath.class);
        assertNotNull(applicationPathAnnotation);
        assertEquals("/api", applicationPathAnnotation.value());
    }

    @Test
    public void testOpenDbConnectionForPlat() {
        PlatRepositoryInterface platRepository = component.openDbConnectionForPlat();
        assertNotNull(platRepository);
    }

    @Test
    public void testOpenDbConnectionForUtilisateur() {
        UtilisateurRepositoryInterface utilisateurRepository = component.openDbConnectionForUtilisateur();
        assertNotNull(utilisateurRepository);
    }

    @Test
    public void testCloseDbConnectionForPlat() {
        PlatRepositoryInterface platRepository = CDI.current().select(PlatRepositoryInterface.class).get();
        assertNotNull(platRepository);
        component.closeDbConnectionForPlat(platRepository);
    }

    @Test
    public void testCloseDbConnectionForUtilisateur() {
        UtilisateurRepositoryInterface utilisateurRepository = CDI.current().select(UtilisateurRepositoryInterface.class).get();
        assertNotNull(utilisateurRepository);
        component.closeDbConnectionForUtilisateur(utilisateurRepository);
    }

}

