package com.rdproject.watercore;

import org.bukkit.plugin.java.*;

import static com.rdproject.watercore.utils.SoftUtil.*;

public final class WaterCore extends JavaPlugin {
    @Override
    public void onEnable() {
        startup(this, " \\ \\        /       |                 ___|                   \n" +
                "  \\ \\  \\   /  _` |  __|   _ \\   __|  |       _ \\    __|  _ \\ \n" +
                "   \\ \\  \\ /  (   |  |     __/  |     |      (   |  |     __/ \n" +
                "    \\_/\\_/  \\__,_| \\__| \\___| _|    \\____| \\___/  _|   \\___|", "1.6");
        updater(this, 100097, "§8• §bWaterCore §8•", "§8§l----------------------------");
    }

}