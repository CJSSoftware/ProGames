package net.cjsmc.progames.minigames.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardManager {
    private final Scoreboard scoreboard;

    public ScoreboardManager() {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    }

    public void createScoreboard(Player player, Arena arena) {
        Objective objective = scoreboard.registerNewObjective("bedwars", "dummy", ChatColor.BOLD + "BedWars");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        // Display team scores
        for (Team team : arena.getTeams()) {
            Score score = objective.getScore(team.getColor() + team.getName());
            score.setScore(0); // Initial score
        }

        player.setScoreboard(scoreboard);
    }

    public void updateScore(Team team) {
        // Logic to update team score based on game events
    }
}
