package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block.{ Block, BlockType }

final case class SeaLantern(location: BlockLocation) extends Block {

  /* Java interop */

  override val `type` = BlockType.SEA_LANTERN

  override def withLocation(loc: BlockLocation): SeaLantern = copy(location = loc)
}
