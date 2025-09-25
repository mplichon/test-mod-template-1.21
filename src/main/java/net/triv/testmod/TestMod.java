package net.triv.testmod;

import net.fabricmc.api.ModInitializer;

import net.triv.testmod.block.ModBlocks;
import net.triv.testmod.item.ModItemGroups;
import net.triv.testmod.item.ModItems;
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
	}
}