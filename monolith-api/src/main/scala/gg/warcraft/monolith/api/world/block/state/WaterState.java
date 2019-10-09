package gg.warcraft.monolith.api.world.block.state;

import gg.warcraft.monolith.api.world.block.BlockState;

public enum WaterState implements BlockState {
    LEVEL_1,
    LEVEL_2,
    LEVEL_3,
    LEVEL_4,
    LEVEL_5,
    LEVEL_6,
    LEVEL_7,
    LEVEL_8;

    private static final WaterState[] finalValues = values();

    public static WaterState valueOf(int data) {
        return finalValues[data - 1];
    }

    @Override
    public int toInt() {
        return ordinal() + 1;
    }
}
