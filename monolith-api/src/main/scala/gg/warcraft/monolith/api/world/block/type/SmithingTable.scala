package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block.{ Block, BlockType }

case class SmithingTable(location: BlockLocation) extends Block {
  override val kind = BlockType.SMITHING_TABLE

  /* Java interop */

  override def withLocation(loc: BlockLocation): SmithingTable = copy(location = loc)
}