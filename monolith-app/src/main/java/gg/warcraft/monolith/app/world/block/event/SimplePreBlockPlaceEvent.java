package gg.warcraft.monolith.app.world.block.event;

import gg.warcraft.monolith.api.world.block.Block;
import gg.warcraft.monolith.api.world.block.BlockType;
import gg.warcraft.monolith.api.world.block.event.PreBlockPlaceEvent;

public class SimplePreBlockPlaceEvent extends SimplePreBlockEvent implements PreBlockPlaceEvent {
    private BlockType newType;

    public SimplePreBlockPlaceEvent(Block block, BlockType newType) {
        super(block);
        this.newType = newType;
    }

    @Override
    public BlockType getNewType() {
        return newType;
    }

    @Override
    public void setNewType(BlockType type) {
        this.newType = type;
    }
}