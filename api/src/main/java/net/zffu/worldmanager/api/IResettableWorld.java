package net.zffu.worldmanager.api;

/**
 * <p>A world that can be reset.</p>
 * @since 1.0.0
 * @param <K> the world datatype.
 * @see {@link ResettableWorld}
 */
public interface IResettableWorld<K> {

    /**
     * <p>Creates a temporary version of the world and load it into the server.</p>
     * @throws Exception if the loading process fails.
     */
    void load() throws Exception;

    /**
     * <p>Creates a temporary version of the world.</p>
     */
    void createTemp();

    /**
     * <p>Unloads the world from the server.</p>
     * @throws Exception if the world is already unloaded.
     */
    void unload() throws Exception;

    /**
     * <p>Gets the world instance.</p>
     * @return the world instance.
     */
    K getWorld();

}
