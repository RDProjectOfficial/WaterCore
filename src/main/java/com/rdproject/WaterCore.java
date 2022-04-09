package com.rdproject;

import org.bukkit.plugin.java.*;

import static com.rdproject.utils.SoftUtil.*;

public final class WaterCore extends JavaPlugin {
    @Override
    public void onEnable() {
        startup(this, " \\ \\        /       |                 ___|                   \n" +
                "  \\ \\  \\   /  _` |  __|   _ \\   __|  |       _ \\    __|  _ \\ \n" +
                "   \\ \\  \\ /  (   |  |     __/  |     |      (   |  |     __/ \n" +
                "    \\_/\\_/  \\__,_| \\__| \\___| _|    \\____| \\___/  _|   \\___|", "1.4");
        updater(this, 14353, 100097, "§8• §bWaterCore §8•", "§8§l----------------------------");
    }

}