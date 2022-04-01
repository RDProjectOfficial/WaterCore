package com.rdproject.watercore.commands;

import net.md_5.bungee.api.chat.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.jetbrains.annotations.*;

public class CoreCMD implements CommandExecutor {

    @Override
    public boolean onCommand(final @NotNull CommandSender cs, final @NotNull Command command, final @NotNull String s, final String[] strings) {
        if (cs == null) return true;
        Player p = (Player) cs;
        TextComponent system = new TextComponent("§8• §bWSystem §8× §7This server using §bWaterCore §8× §bRDProject!");system.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/RDProjectOfficial"));system.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§8• §bClick to Open URL!").create()));

        p.spigot().sendMessage(system);
        return false;
    }
    
}