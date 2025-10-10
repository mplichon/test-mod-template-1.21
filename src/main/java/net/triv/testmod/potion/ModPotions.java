package net.triv.testmod.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.triv.testmod.TestMod;
import net.triv.testmod.effect.ModEffects;

public class ModPotions {

    public static final RegistryEntry<Potion> SLIMEY_POTION = registryPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));

    private static RegistryEntry<Potion> registryPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(TestMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        TestMod.LOGGER.info("Registering Mod Potions for " + TestMod.MOD_ID);
    }
}
