package me.tntdelay;

import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TNTDelay extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("TNTDelay enabled: adding 10 fuse ticks to primed TNT.");
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (!(event.getEntity() instanceof TNTPrimed tnt)) {
            return;
        }

        // Defer until after the entity has been initialized by the server.
        getServer().getScheduler().runTask(this, () -> {
            if (tnt.isValid() && !tnt.isDead()) {
                tnt.setFuseTicks(tnt.getFuseTicks() + 10);
            }
        });
    }
}
