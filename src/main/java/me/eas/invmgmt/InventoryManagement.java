package me.eas.invmgmt;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryManagement {

    public static void clear(Player player){
        player.getInventory().clear();
    }

    public static void addItem(Player player, ItemStack itemStack){
        player.getInventory().addItem(itemStack);
    }

    public static void removeItem(Player player, ItemStack itemStack){
        player.getInventory().removeItem(itemStack);
    }
}
