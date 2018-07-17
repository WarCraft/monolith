package gg.warcraft.monolith.api.menu.service;

import gg.warcraft.monolith.api.menu.Menu;

import java.util.UUID;

public interface MenuServerAdapter {

    void showMenu(Menu menu, UUID viewerId);

    void closeMenu(UUID viewerId);
}
