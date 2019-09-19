package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block._
import gg.warcraft.monolith.api.world.block.state.StairsState

case class Stairs(
  location: BlockLocation,
  material: StairsMaterial,
  state: StairsState,
  facing: BlockFace,
  section: BlockBisection,
  flooded: Boolean
) extends MaterialBlock[StairsMaterial] with StatefulBlock[StairsState]
  with DirectionalBlock with BisectedBlock with FloodableBlock {
  override val kind = BlockType.STAIRS

  /* Java interop */

  override def withLocation(loc: BlockLocation): Stairs = copy(location = loc)
  override def withMaterial(mat: StairsMaterial): Stairs = copy(material = mat)
  override def withState(state: StairsState): Stairs = copy(state = state)
  override def withFacing(facing: BlockFace): Stairs = copy(facing = facing)
  override def withSection(section: BlockBisection): Stairs = copy(section = section)
  override def withFlooded(flooded: Boolean): Stairs = copy(flooded = flooded)
}