package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block._

case class Campfire(
  location: BlockLocation,
  facing: BlockFace,
  flooded: Boolean,
  lit: Boolean,
  signal: Boolean
) extends DirectionalBlock with FloodableBlock with LightableBlock {
  override val kind = BlockType.CAMPFIRE

  /* Java interop */

  def withSignal(signal: Boolean): Campfire = copy(signal = signal)

  override def withLocation(loc: BlockLocation): Campfire = copy(location = loc)
  override def withFacing(facing: BlockFace): Campfire = copy(facing = facing)
  override def withFlooded(flooded: Boolean): Campfire = copy(flooded = flooded)
  override def withLit(lit: Boolean): Campfire = copy(lit = lit)
}