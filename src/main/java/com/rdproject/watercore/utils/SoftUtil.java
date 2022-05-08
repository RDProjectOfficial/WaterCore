package com.rdproject.watercore.utils;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.*;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.plugin.java.*;

import java.util.*;
import java.util.logging.Level;

public class SoftUtil {
    public static void log(final JavaPlugin plugin, final String msg) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&c" + plugin.getName() + "&8]&r " + msg));
    }
    public static void debug(final String msg) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&1DEBUG&8]&r" + msg));
    }
    public static void startup(final JavaPlugin plugin, final String msg, final String version) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&b" + plugin.getName() + "&8]&b " + "\n" + msg + " Version: " + version));
    }
    public static String translate(final String message) {
        return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', message);
    }
    public static void updater(final JavaPlugin plugin, final int metrics, final int projectid, final String prefix, final String list) {
        new Metrics(plugin, metrics);
        UpdateChecker updateChecker = new UpdateChecker(plugin, projectid);
        ConsoleCommandSender cs = Bukkit.getConsoleSender();
        try {
            if (updateChecker.checkForUpdates()) {
                cs.sendMessage(list);
                cs.sendMessage(    prefix);
                cs.sendMessage("");
                cs.sendMessage("§8× §7Update Available!");
                cs.sendMessage("§8× §7Download it from Spigot!");
                cs.sendMessage("");
                cs.sendMessage(list);
            } else {
                cs.sendMessage(list);
                cs.sendMessage(    prefix);
                cs.sendMessage("");
                cs.sendMessage("§8× §7You are using the Latest Version!");
                cs.sendMessage("");
                cs.sendMessage(list);
            }
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.SEVERE, "Error with Update Checker, Check Log!");
            e.printStackTrace();
        }
    }
    public static void log4shell() {
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
