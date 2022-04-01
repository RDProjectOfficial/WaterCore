package com.rdproject.watercore.utils;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.*;

import me.clip.placeholderapi.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

import java.io.*;
import java.util.*;
import java.util.logging.Level;

public class SoftUtil {

    public static void LoggerLevel(JavaPlugin plugin, Level l, String s) {
        String msg = translate("&8[&c" + plugin.getName() + "&8]&r ");
        Bukkit.getLogger().log(l, msg + s);
    }

    public static void log(JavaPlugin plugin, String msg) {
        msg = translate("&8[&c" + plugin.getName() + "&8]&r " + msg);
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public static void debug(JavaPlugin plugin, String msg) {
        log(plugin, "&8[&1DEBUG&8]&r" + msg);
    }

    public static void CMDManager(JavaPlugin plugin, String command, CommandExecutor ex) {
        Objects.requireNonNull(plugin.getCommand(command)).setExecutor(ex);
    }

    public static void ListenerManager(JavaPlugin plugin, Listener l) {
        Bukkit.getPluginManager().registerEvents(l, plugin);
    }

    public static void startup(JavaPlugin plugin, String msg, String version) {
        String main = ChatColor.translateAlternateColorCodes('&', "&8[&c" + plugin.getName() + "&8]&r " + "\n" + msg + " Version " + version);
        Bukkit.getConsoleSender().sendMessage(main);
    }

        public static void PAPIDepend(JavaPlugin plugin) {
            final String ENABLED_PLACEHOLDERAPI = "§fHooked into §cPlaceholderAPI!";
            final String NO_PLACEHOLDERAPI = "§fNot Found §cPlaceholderAPI!";
            if (plugin.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
                log(plugin, ENABLED_PLACEHOLDERAPI);
            } else {
                log(plugin, NO_PLACEHOLDERAPI);
            }
        }

        public static void ProtocolLibDepend(JavaPlugin plugin) {
            final String ENABLED_PROTOCOLLIB = "§fHooked into §cProtocolLib!";
            final String NO_PROTOCOLLIB = "§fNot Found §cProtocolLib!";
            if (plugin.getServer().getPluginManager().getPlugin("ProtocolLib") != null) {
                log(plugin, ENABLED_PROTOCOLLIB);
            } else {
                log(plugin, NO_PROTOCOLLIB);
            }
        }

        public static void LuckPermsDepend(JavaPlugin plugin) {
            final String ENABLED_LUCKPERMS = "§fHooked into §cLuckPerms!";
            final String NO_LUCKPERMS = "§fNot Found §cLuckPerms!";
            if (plugin.getServer().getPluginManager().getPlugin("LuckPerms") != null) {
                log(plugin, ENABLED_LUCKPERMS);
            } else {
                log(plugin, NO_LUCKPERMS);
            }
        }

    public static void WaterCoreDepend(JavaPlugin plugin) {
        final String ENABLED_WATERCORE = "§fHooked into §cWaterCore!";
        final String NO_WATERCORE = "§fNot Found §cWaterCore!";
        if (plugin.getServer().getPluginManager().getPlugin("LuckPerms") != null) {
            log(plugin, ENABLED_WATERCORE);
        } else {
            log(plugin, NO_WATERCORE);
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        }
    }

    public static void Save(JavaPlugin plugin, File cgf, FileConfiguration cg) {
        try {
            cg.save(cgf);
        } catch (IOException e) {
            LoggerLevel(plugin, Level.SEVERE, "Error with Saving Configuration, Check Log!");
            e.printStackTrace();
        }
    }

    public static void Load(JavaPlugin plugin, File cgf, FileConfiguration cg) {
        try {
            cg.load(cgf);
        } catch (IOException | InvalidConfigurationException e) {
            LoggerLevel(plugin, Level.SEVERE, "Error with Loading Configuration, Check Log!");
            e.printStackTrace();
        }
    }

    //PAPI
    public static void PAPI(Player p, String s) {
        PlaceholderAPI.setPlaceholders(p, s);
    }

    //Translate
    public static String translate(String message) {
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
    }

    //Version
    public static String GetVersion(JavaPlugin plugin) {
        return plugin.getDescription().getVersion();
    }

    //Author
    public static List<String> GetAuthor(JavaPlugin plugin) {
        return plugin.getDescription().getAuthors();
    }

    //Author
    public static String GetMain(JavaPlugin plugin) {
        return plugin.getDescription().getMain();
    }

    //Updater
    public static void LoadUpdater(JavaPlugin plugin, int metrics, int projectid, String prefix, String LIST) {
        new Metrics(plugin, metrics);
        UpdateChecker updateChecker = new UpdateChecker(plugin, projectid);
        ConsoleCommandSender cs = Bukkit.getConsoleSender();
        try {
            if (updateChecker.checkForUpdates()) {
                cs.sendMessage(LIST);
                cs.sendMessage(    prefix);
                cs.sendMessage("");
                cs.sendMessage("§8× §7Update Available!");
                cs.sendMessage("§8× §7Download it from Spigot!");
                cs.sendMessage("");
                cs.sendMessage(LIST);
            } else {
                cs.sendMessage(LIST);
                cs.sendMessage(    prefix);
                cs.sendMessage("");
                cs.sendMessage("§8× §7You are using the Latest Version!");
                cs.sendMessage("");
                cs.sendMessage(LIST);
            }
        } catch (Exception e) {
            LoggerLevel(plugin, Level.SEVERE, "Error with Update Checker, Check Log!");
            e.printStackTrace();
        }
    }

    //Vengine Licence
    //https://github.com/zSkillCode/Log4ShellFix/blob/master/src/main/java/com/skillcode/log4shellfix/Log4ShellFix.java
    public static void Log4ShellFix() {
        final Logger logger = (Logger) LogManager.getRootLogger();
        logger.addFilter(new Filter() {
            @Override
            public Result getOnMismatch() {
                return Result.NEUTRAL;
            }

            @Override
            public Result getOnMatch() {
                return Result.NEUTRAL;
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object... objects) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1, final Object o2) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1, final Object o2, final Object o3) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1, final Object o2, final Object o3, final Object o4) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1, final Object o2, final Object o3, final Object o4, final Object o5) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final String s, final Object o, final Object o1, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9) {
                return check(s);
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final Object o, final Throwable throwable) {
                return check(o.toString());
            }

            @Override
            public Result filter(final Logger logger, final org.apache.logging.log4j.Level level, final Marker marker, final Message message, final Throwable throwable) {
                return check(message.getFormattedMessage());
            }

            @Override
            public Result filter(final LogEvent logEvent) {
                return check(logEvent.getMessage().getFormattedMessage());
            }

            @Override
            public State getState() {
                return State.STARTED;
            }

            @Override
            public void initialize() {
                //empty
            }

            @Override
            public void start() {
                //empty
            }

            @Override
            public void stop() {
                //empty
            }

            @Override
            public boolean isStarted() {
                return true;
            }

            @Override
            public boolean isStopped() {
                return false;
            }
        });
    }

    private static Filter.Result check(final String message) {
        return message.toLowerCase(Locale.ROOT).contains("${") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

}
