package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block.{ BlockFace, BlockType, DirectedBlock, StickyBlock }

final case class Piston(
  location: BlockLocation,
  direction: BlockFace,
  sticky: Boolean,
  extended: Boolean
) extends DirectedBlock with StickyBlock {

  /* Java interop */

  override val `type` = BlockType.PISTON

  def withExtended(extended: Boolean): Piston = copy(extended = extended)

  override def withLocation(loc: BlockLocation): Piston = copy(location = loc)
  override def withDirection(dir: BlockFace): Piston = copy(direction = dir)
  override def withSticky(sticky: Boolean): Piston = copy(sticky = sticky)
}
