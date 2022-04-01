package com.rdproject.watercore;

import org.bukkit.plugin.java.*;

import static com.rdproject.watercore.utils.LoaderUtil.*;

public final class WaterCore extends JavaPlugin {

    @Override
    public void onEnable() {
        plugin = this;
        LoadFeatures();
    }

}