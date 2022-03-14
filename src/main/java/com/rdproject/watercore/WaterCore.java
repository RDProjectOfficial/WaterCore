package com.rdproject.watercore;

import com.rdproject.watercore.utils.*;
import org.bukkit.plugin.java.*;

import static com.rdproject.watercore.utils.LoaderUtil.*;

public final class WaterCore extends JavaPlugin {

    @Override
    public void onEnable() {
        LoaderUtil.plugin = this;
        LoadFeatures();
    }

}