package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.block.state.ComposterState
import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block.{ BlockType, StatefulBlock }

case class Composter(
  location: BlockLocation,
  state: ComposterState
) extends StatefulBlock[ComposterState] {
  override val kind = BlockType.COMPOSTER

  /* Java interop */

  override def withLocation(loc: BlockLocation): Composter = copy(location = loc)
  override def withState(state: ComposterState): Composter = copy(state = state)
}