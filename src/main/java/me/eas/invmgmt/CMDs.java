package me.eas.invmgmt;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class CMDs implements CommandExecutor {

    public CMDs(Plugin plugin){
        plugin.getCommand("inv").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String cmd, @NotNull String[] args) {

        if (args[0].equalsIgnoreCase("clear")){
            String playerName;
            try{
                playerName = args[1];
            }catch (IndexOutOfBoundsException e){
                commandSender.sendMessage(ChatColor.RED + "Enter the player's name!");
                return true;
            }

            Player player = Bukkit.getPlayer(playerName);
            if (player == null){
                commandSender.sendMessage(ChatColor.RED + "No such player exists!");
            }

            InventoryManagement.clear(player);
            player.sendMessage(ChatColor.GREEN + "Inventory cleaned!");
            return true;
        }
        else if (args[0].equalsIgnoreCase("add")){
            String playerName;
            String itemName;
            int amount;
            try{
                playerName = args[1];
                itemName = args[2];
                amount = Integer.parseInt(args[3]);
            }catch (IndexOutOfBoundsException | NumberFormatException e){
                commandSender.sendMessage(ChatColor.RED + "Enter the player's name, item name and item amount!");
                return true;
            }

            Player player = Bukkit.getPlayer(playerName);
            if (player == null){
                commandSender.sendMessage(ChatColor.RED + "No such player exists!");
            }

            Material material = Material.getMaterial(itemName.toUpperCase(Locale.ROOT));
            if (material == null){
                commandSender.sendMessage(ChatColor.RED + "No such item exists!");
                return true;
            }

            ItemStack itemStack = new ItemStack(material, amount);
            InventoryManagement.addItem(player, itemStack);
            player.sendMessage(ChatColor.GREEN + "Item '" + itemName + "' added! (" + args[3] + ")");
            return true;
        }
        else if (args[0].equalsIgnoreCase("remove")){
            String playerName;
            String itemName;
            int amount;
            try{
                playerName = args[1];
                itemName = args[2];
                amount = Integer.parseInt(args[3]);
            }catch (IndexOutOfBoundsException | NumberFormatException e){
                commandSender.sendMessage(ChatColor.RED + "Enter the player's name, item name and item amount!");
                return true;
            }

            Player player = Bukkit.getPlayer(playerName);
            if (player == null){
                commandSender.sendMessage(ChatColor.RED + "No such player exists!");
            }

            Material material = Material.getMaterial(itemName.toUpperCase(Locale.ROOT));
            if (material == null){
                commandSender.sendMessage(ChatColor.RED + "No such item exists!");
                return true;
            }

            ItemStack itemStack = new ItemStack(material, amount);
            InventoryManagement.removeItem(player, itemStack);
            player.sendMessage(ChatColor.GREEN + "Item '" + itemName + "' removed! (" + args[3] + ")");
            return true;
        }

        return false;
    }
}
