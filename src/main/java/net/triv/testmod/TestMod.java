package net.triv.testmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.triv.testmod.block.ModBlocks;
import net.triv.testmod.component.ModDataComponentTypes;
import net.triv.testmod.item.ModItemGroups;
import net.triv.testmod.item.ModItems;
import net.triv.testmod.sound.ModSounds;
import net.triv.testmod.util.HammerUsageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModSounds.registerModSounds();
        ModDataComponentTypes.registerDataComponentTypes();

        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
        AttackEntityCallback.EVENT.register((player, world, hand, entity, entityHitResult) -> {
            if (entity instanceof SheepEntity sheepEntity && !world.isClient()) {
                if (player.getMainHandStack().getItem() == Items.END_ROD) {
                    player.sendMessage(Text.literal("The Player just hit a sheep with an END ROD! YOU SICK FRICK!"));
                    player.getMainHandStack().decrement(1);
                    sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 6));
                }

                return ActionResult.PASS;
            }
            return ActionResult.PASS;
        });
	}
}