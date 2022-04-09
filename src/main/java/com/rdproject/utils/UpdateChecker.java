package com.rdproject.utils;

import org.bukkit.plugin.*;
import java.io.*;
import java.net.*;

public class UpdateChecker {
    private int project = 0;

    private URL checkURL;

    private String newVersion = "";

    private Plugin plugin;

    public UpdateChecker(Plugin plugin, int projectID) {
        this.plugin = plugin;
        this.newVersion = plugin.getDescription().getVersion();
        this.project = projectID;
        try {
            this.checkURL = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + projectID);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    public int getProjectID() {
        return this.project;
    }

    public Plugin getPlugin() {
        return this.plugin;
    }

    public String getLatestVersion() {
        return this.newVersion;
    }

    public String getResourceURL() {
        return "https://www.spigotmc.org/resources/" + this.project;
    }

    public boolean checkForUpdates() throws Exception {
        URLConnection con = this.checkURL.openConnection();
        this.newVersion = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
        return !this.plugin.getDescription().getVersion().equals(this.newVersion);
    }
}

