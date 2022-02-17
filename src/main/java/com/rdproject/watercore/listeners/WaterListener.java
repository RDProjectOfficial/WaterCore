package com.rdproject.watercore.listeners;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

import static com.rdproject.watercore.WaterCore.*;

@SuppressWarnings("ALL")
public class WaterListener implements Listener {
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.getName().equals(DEV) || p.isOp()) {
            p.sendMessage("§8• §bWSystem §8× §7Thanks for using §bOur Systems!");
        }
    }
}
