package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block.{ BlockType, StatefulBlock }
import gg.warcraft.monolith.api.world.block.state.RedstoneWireState

// TODO add NESW connections
final case class RedstoneWire(
  location: BlockLocation,
  state: RedstoneWireState
) extends StatefulBlock[RedstoneWireState] {

  /* Java interop */

  override val `type` = BlockType.REDSTONE_WIRE

  override def withLocation(loc: BlockLocation): RedstoneWire = copy(location = loc)
  override def withState(state: RedstoneWireState): RedstoneWire = copy(state = state)
}
