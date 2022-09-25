package com.simondmc.borderhoarder.game;

import com.simondmc.borderhoarder.BorderHoarder;
import com.simondmc.borderhoarder.world.BorderExpander;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GainItem {

    private static final List<Material> collectedItems = new ArrayList<>();

    public static void gainItem(Material itemType) {
        if (itemType == null) return;
        if (itemType.equals(Material.AIR)) return;
        if (!collectedItems.contains(itemType)) {
            // add to list of collected items
            collectedItems.add(itemType);
            // announce to players
            for (Player p : BorderHoarder.plugin.getServer().getOnlinePlayers()) {
                p.sendMessage("§aYou gained a " + ItemDictionary.getDict().get(itemType.toString().toLowerCase()) + "!");
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            }
            // expand border
            BorderExpander.expandBorder();
        }
    }
}
