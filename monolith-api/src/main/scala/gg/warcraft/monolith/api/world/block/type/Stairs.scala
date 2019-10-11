package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block._
import gg.warcraft.monolith.api.world.block.shape.StairsShape

final case class Stairs(
    location: BlockLocation,
    material: StairsMaterial,
    variant: Option[StairsVariant],
    shape: StairsShape,
    direction: BlockFace,
    section: BlockBisection,
    flooded: Boolean
) extends MaterialBlock[StairsMaterial]
    with VariableBlock[StairsVariant]
    with ShapedBlock[StairsShape]
    with DirectedBlock
    with BisectedBlock
    with FloodableBlock {

  /* Java interop */

  override val `type` = BlockType.STAIRS

  override def withLocation(loc: BlockLocation): Stairs = copy(location = loc)
  override def withMaterial(mat: StairsMaterial): Stairs = copy(material = mat)
  override def withVariant(variant: Option[StairsVariant]): Stairs = copy(variant = variant)
  override def withShape(shape: StairsShape): Stairs = copy(shape = shape)
  override def withDirection(dir: BlockFace): Stairs = copy(direction = dir)
  override def withSection(half: BlockBisection): Stairs = copy(section = half)
  override def withFlooded(flooded: Boolean): Stairs = copy(flooded = flooded)
}
