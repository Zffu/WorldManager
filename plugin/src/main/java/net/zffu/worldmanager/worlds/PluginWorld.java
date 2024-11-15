package net.zffu.worldmanager.worlds;

import net.zffu.worldmanager.WorldManagerPlugin;
import net.zffu.worldmanager.api.ResettableWorld;

import java.io.File;

public class PluginWorld extends ResettableWorld {

    public final boolean resetOnLoad;
    public final boolean loadOnStart;

    public PluginWorld(File origin, String name, boolean resetOnLoad, boolean loadOnStart) {
        super(origin, name);
        this.resetOnLoad = resetOnLoad;
        this.loadOnStart = loadOnStart;
    }

    @Override
    public void load() throws Exception {
        super.load();
        WorldManagerPlugin.LOADED++;
    }

    @Override
    public void unload() throws Exception {
        super.unload();
        WorldManagerPlugin.LOADED--;
    }
}
