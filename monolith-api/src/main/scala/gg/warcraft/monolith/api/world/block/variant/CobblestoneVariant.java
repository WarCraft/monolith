package gg.warcraft.monolith.api.world.block.variant;

import gg.warcraft.monolith.api.world.block.InfestedVariant;
import gg.warcraft.monolith.api.world.block.SlabVariant;
import gg.warcraft.monolith.api.world.block.StairsVariant;
import gg.warcraft.monolith.api.world.block.WallVariant;

public enum CobblestoneVariant implements InfestedVariant, SlabVariant,
        StairsVariant, WallVariant {
    NORMAL,
    MOSSY,
}
