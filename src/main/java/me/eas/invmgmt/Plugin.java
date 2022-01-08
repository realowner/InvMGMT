package me.eas.invmgmt;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable(){
        System.out.println("[InvMGMT] Plugin connected.");

        new  CMDs(this);
    }

    @Override
    public void onDisable(){

    }
}
