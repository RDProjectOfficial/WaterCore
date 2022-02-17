package com.rdproject.watercore.commands;

import net.md_5.bungee.api.chat.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class WaterCoreCommand implements CommandExecutor {

    @SuppressWarnings("ALL")
    @Override
    public boolean onCommand(final CommandSender cs, final Command command, final String s, final String[] strings) {

        TextComponent system = new TextComponent("");
        system.setText("§8• §bWSystem §8× §7This server using §bWaterCore §8× §bRDProject!");
        system.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/RDProjectOfficial"));
        system.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        if (!(cs instanceof Player)) return true;

        ((Player) cs).spigot().sendMessage(system);
        return false;
        //Help Command + Returner //
    }
}
