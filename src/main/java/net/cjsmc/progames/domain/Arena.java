package net.cjsmc.progames.domain;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Arena {

    private final UUID id;
    private final String name;
    private final ArrayList<Player> players;

    protected Arena(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<>();
    }
}
