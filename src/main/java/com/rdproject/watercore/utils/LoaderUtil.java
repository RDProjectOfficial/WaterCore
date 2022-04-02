package com.rdproject.watercore.utils;

import com.rdproject.watercore.*;
import com.rdproject.watercore.commands.*;

import static com.rdproject.watercore.utils.SoftUtil.*;

public class LoaderUtil {

    public static WaterCore plugin;

    public static void LoadFeatures() {
        CMDManager(plugin, "watercore", new CoreCMD());
        startup(plugin, " \\ \\        /       |                 ___|                   \n" +
                "  \\ \\  \\   /  _` |  __|   _ \\   __|  |       _ \\    __|  _ \\ \n" +
                "   \\ \\  \\ /  (   |  |     __/  |     |      (   |  |     __/ \n" +
                "    \\_/\\_/  \\__,_| \\__| \\___| _|    \\____| \\___/  _|   \\___|", "1.3");
        LoadUpdater(plugin, 14353, 100097, "§8• §bWaterCore §8•", "§8§l----------------------------");
    }

}

