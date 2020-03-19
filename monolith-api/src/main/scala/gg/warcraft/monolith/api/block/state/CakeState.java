package gg.warcraft.monolith.api.block.state;

import gg.warcraft.monolith.api.block.BlockState;

public enum CakeState implements BlockState {
    EATEN_0,
    EATEN_1,
    EATEN_2,
    EATEN_3,
    EATEN_4,
    EATEN_5,
    EATEN_6;

    private static final CakeState[] finalValues = values();

    public static CakeState valueOf(int data) {
        return finalValues[data];
    }

    @Override
    public int toInt() {
        return ordinal();
    }
}