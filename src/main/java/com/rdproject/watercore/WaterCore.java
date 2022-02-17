package com.rdproject.watercore;

import com.rdproject.watercore.commands.*;
import com.rdproject.watercore.listeners.*;
import com.rdproject.watercore.utils.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.*;

public final class WaterCore extends JavaPlugin {

    public static final String DEV = "ArtemYTO";
    public static final String VERSION = "1.0";
    public static final String LIST = "§8§l----------------------------";
    public static final String STARTUP_MESSAGE = "\n" + " \\ \\        /       |                 ___|                   \n" +
            "  \\ \\  \\   /  _` |  __|   _ \\   __|  |       _ \\    __|  _ \\ \n" +
            "   \\ \\  \\ /  (   |  |     __/  |     |      (   |  |     __/ \n" +
            "    \\_/\\_/  \\__,_| \\__| \\___| _|    \\____| \\___/  _|   \\___|" + "Version " + VERSION;

    @Override
    public void onEnable() {
        LoadCommands();
        LoadListeners();
        LoadPlugin();
        LoadUtils();
    }

    public void LoadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new WaterListener(), this);
    }

    public void LoadCommands() {
        this.getCommand("watercore").setExecutor(new WaterCoreCommand());
    }

    public void LoadPlugin() {
        getLogger().info(STARTUP_MESSAGE);
    }

    public void LoadUtils() {
        new Metrics(this, 14353);
        UpdateChecker updateChecker = new UpdateChecker(this, 100097);
        try {
            if (updateChecker.checkForUpdates()) {
                getLogger().info(LIST);
                getLogger().info("    §8• §bWaterCore §8•");
                getLogger().info("");
                getLogger().info("§8× §7Update Available!");
                getLogger().info("§8× §7Download it from Spigot!");
                getLogger().info("");
                getLogger().info(LIST);
            } else {
                getLogger().info(LIST);
                getLogger().info("    §8• §bWaterCore §8•");
                getLogger().info("");
                getLogger().info("§8× §7You are using the Latest Version!");
                getLogger().info("");
                getLogger().info(LIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
