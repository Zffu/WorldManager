package net.zffu.worldmanager.api;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * <p>A world that can be reset.</p>
 * @since 1.0.0
 */
public class ResettableWorld implements IResettableWorld<World> {

    private final String worldName;
    private final Path sourceWorld;
    private final Path activeWorld;

    private World world;

    public ResettableWorld(File originalWorld, String tempWorldName) {
        this.worldName = tempWorldName;

        this.sourceWorld = originalWorld.toPath();
        this.activeWorld = new File(tempWorldName).toPath();
    }

    @Override
    public void load() throws Exception {
        this.createTemp();

        this.world = Bukkit.createWorld(new WorldCreator(this.worldName));

        if(this.world == null) throw new IllegalStateException("World loading failed!");
        this.world.setAutoSave(false);
    }

    @Override
    public void createTemp() throws IOException {
        if(this.world != null) return;

        Files.copy(this.sourceWorld, this.activeWorld);
    }

    @Override
    public void unload() throws Exception {
        if(this.world == null) throw new IllegalStateException("Tried to unload world even tho the world is currently unloaded!");

        Files.walk(this.activeWorld).map(Path::toFile).forEach(File::delete);
    }

    @Override
    public World getWorld() {
        return this.world;
    }
}
