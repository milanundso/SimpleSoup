package ltc.milan.simplesoup;

import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class SoupListener implements Listener {
    @EventHandler
    public void onSoup(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (e.getItem() != null &&
                e.getItem().getType() == Material.MUSHROOM_SOUP &&
                (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            e.setCancelled(true);

            if (p.getHealth() < p.getMaxHealth()) {
                double healAmount = Math.min(7.0, p.getMaxHealth() - p.getHealth());
                double newHealth = Math.min(p.getMaxHealth(), p.getHealth() + healAmount);
                p.setHealth(newHealth);

                ItemStack item = e.getItem();
                item.setType(Material.BOWL);
                p.setItemInHand(item);
            }
        }
    }
}
