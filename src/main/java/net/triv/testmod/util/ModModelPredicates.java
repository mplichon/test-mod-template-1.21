package net.triv.testmod.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.triv.testmod.TestMod;
import net.triv.testmod.component.ModDataComponentTypes;
import net.triv.testmod.item.ModItems;

public class ModModelPredicates {

    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(TestMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f:0f);
    }
}
