package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.block.material.CoralMaterial
import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block._

case class CoralFan(
  location: BlockLocation,
  material: CoralMaterial,
  direction: Option[BlockFace],
  flooded: Boolean
) extends MaterialBlock[CoralMaterial] with DirectableBlock with FloodableBlock {
  override val kind = BlockType.CORAL_FAN
  override val solid: Boolean = false

  /* Java interop */

  override def withLocation(loc: BlockLocation): CoralFan = copy(location = loc)
  override def withMaterial(mat: CoralMaterial): CoralFan = copy(material = mat)
  override def withDirection(dir: Option[BlockFace]): CoralFan = copy(direction = dir)
  override def withFlooded(flooded: Boolean): CoralFan = copy(flooded = flooded)
}
