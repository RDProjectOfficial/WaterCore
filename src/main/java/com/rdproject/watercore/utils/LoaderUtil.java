package com.rdproject.watercore.utils;

import com.rdproject.watercore.*;
import com.rdproject.watercore.commands.*;
import lombok.*;
import lombok.extern.java.*;

@Log
public class LoaderUtil {

    public static @Getter WaterCore plugin;
    public static final String VERSION = "1.1";
    public static final String LIST = "§8§l----------------------------";
    public static final String STARTUP_MESSAGE = "\n" + " \\ \\        /       |                 ___|                   \n" +
            "  \\ \\  \\   /  _` |  __|   _ \\   __|  |       _ \\    __|  _ \\ \n" +
            "   \\ \\  \\ /  (   |  |     __/  |     |      (   |  |     __/ \n" +
            "    \\_/\\_/  \\__,_| \\__| \\___| _|    \\____| \\___/  _|   \\___|" + "Version " + VERSION;

    public static void LoadCommands() {
        plugin.getCommand("watercore").setExecutor(new WaterCoreCommand());
    }

    public static void LoadPlugin() {
        log.info(STARTUP_MESSAGE);
    }

    public static void LoadUtils() {
        new Metrics(plugin, 14353);
        UpdateChecker updateChecker = new UpdateChecker(plugin, 100097);
        try {
            if (updateChecker.checkForUpdates()) {
                log.info(LIST);
                log.info("    §8• §bWaterCore §8•");
                log.info("");
                log.info("§8× §7Update Available!");
                log.info("§8× §7Download it from Spigot!");
                log.info("");
                log.info(LIST);
            } else {
                log.info(LIST);
                log.info("    §8• §bWaterCore §8•");
                log.info("");
                log.info("§8× §7You are using the Latest Version!");
                log.info("");
                log.info(LIST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void LoadFeatures() {
        LoadCommands();
        LoadPlugin();
        LoadUtils();
    }

}

