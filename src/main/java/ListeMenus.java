package src.main.java;

import java.util.List;

public class ListeMenus {
    // Stockage liste de menus
    private List<Menu> menus;

    public ListeMenus() {
    }

    // Récupération liste des menus
    public List<Menu> getMenus() {
        return menus;
    }

    // Définition liste des menus
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
