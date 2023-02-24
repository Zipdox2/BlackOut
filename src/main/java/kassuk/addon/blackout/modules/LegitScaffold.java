package kassuk.addon.blackout.modules;

import kassuk.addon.blackout.BlackOut;
import kassuk.addon.blackout.BlackOutModule;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Blocks;

public class LegitScaffold extends BlackOutModule {
    public LegitScaffold() {super(BlackOut.BLACKOUT, "LegitScaffold", "It do be kinda speed bridging doe");}

    @Override
    public void onDeactivate() {
        mc.options.sneakKey.setPressed(false);
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player != null && mc.world != null && mc.player.isOnGround()){
            mc.options.sneakKey.setPressed(mc.world.getBlockState(mc.player.getBlockPos().down()).getBlock().equals(Blocks.AIR));
        }
    }
}
