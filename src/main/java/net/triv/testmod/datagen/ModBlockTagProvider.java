package net.triv.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.triv.testmod.block.ModBlocks;
import net.triv.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.PINK_GARNET_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.PINK_GARNET_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.PINK_GARNET_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL)
                .add(ModBlocks.MAGIC_BLOCK)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
