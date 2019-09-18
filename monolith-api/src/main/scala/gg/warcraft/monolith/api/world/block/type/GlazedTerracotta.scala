package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block.{ BlockColor, BlockType, ColoredBlock }

case class GlazedTerracotta(
  location: BlockLocation,
  color: BlockColor
) extends ColoredBlock {
  override val kind = BlockType.GLAZED_TERRACOTTA

  /* Java interop */

  override def withLocation(loc: BlockLocation): GlazedTerracotta = copy(location = loc)
  override def withColor(color: BlockColor): GlazedTerracotta = copy(color = color)
}