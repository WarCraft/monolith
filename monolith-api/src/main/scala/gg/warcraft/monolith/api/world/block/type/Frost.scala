package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block.{ BlockType, StatefulBlock }
import gg.warcraft.monolith.api.world.block.state.FrostState

case class Frost(
  location: BlockLocation,
  state: FrostState
) extends StatefulBlock[FrostState] {
  override val kind = BlockType.FROST

  /* Java interop */

  override def withLocation(loc: BlockLocation): Frost = copy(location = loc)
  override def withState(state: FrostState): Frost = copy(state = state)
}
