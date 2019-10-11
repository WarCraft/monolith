package gg.warcraft.monolith.api.world.block.`type`

import gg.warcraft.monolith.api.world.BlockLocation
import gg.warcraft.monolith.api.world.block.{ Block, BlockType }

case class Bedrock(location: BlockLocation) extends Block {

  /* Java interop */

  override val `type` = BlockType.BEDROCK

  override def withLocation(loc: BlockLocation): Bedrock = copy(location = loc)
}
