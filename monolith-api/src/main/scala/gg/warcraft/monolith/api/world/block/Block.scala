package gg.warcraft.monolith.api.world.block

import gg.warcraft.monolith.api.world.BlockLocation

trait Block {
  val location: BlockLocation
  val liquid: Boolean = false
  val solid: Boolean = true
  def withLocation(loc: BlockLocation): Block
}

trait AttachableBlock extends Block {
  val attached: Option[BlockAttachment]
  def withAttached(attached: Option[BlockAttachment]): AttachableBlock
}

trait AttachedBlock extends Block {
  val attached: BlockAttachment
  def withAttached(attached: BlockAttachment): AttachedBlock
}

trait BisectedBlock extends Block {
  val section: BlockBisection
  def withSection(section: BlockBisection): BisectedBlock
}

trait ColorableBlock extends Block {
  val color: Option[BlockColor]
  def withColor(color: Option[BlockColor]): ColorableBlock
}

trait ColoredBlock extends Block {
  val color: BlockColor
  def withColor(color: BlockColor): ColoredBlock
}

trait DirectableBlock extends Block {
  val facing: Option[BlockFace]
  def withFacing(facing: Option[BlockFace]): DirectableBlock
}

trait DirectionalBlock extends Block {
  val facing: BlockFace
  def withFacing(facing: BlockFace): DirectionalBlock
}

trait ExtendableBlock extends Block {
  val extensions: Set[BlockFace]
  def withExtensions(extensions: Set[BlockFace]): ExtendableBlock
}

trait FloodableBlock extends Block {
  val flooded: Boolean
  def withFlooded(flooded: Boolean): FloodableBlock
}

trait HingedBlock extends Block {
  val hinge: BlockHinge
  def withHinge(hinge: BlockHinge): HingedBlock
}

trait LightableBlock extends Block {
  val lit: Boolean
  def withLit(lit: Boolean): LightableBlock
}

trait MaterialBlock[T] extends Block {
  val material: T
  def withMaterial(material: T): MaterialBlock[T]
}

trait OpenableBlock extends Block {
  val open: Boolean
  def withOpen(open: Boolean): OpenableBlock
}

trait OrientableBlock extends Block {
  val orientation: BlockOrientation
  def withOrientation(orientation: BlockOrientation): OrientableBlock
}

trait PowerableBlock extends Block {
  val powered: Boolean
  def withPowered(powered: Boolean): PowerableBlock
}

trait RotatableBlock extends Block {
  val rotation: Option[BlockRotation]
  def withRotation(rotation: Option[BlockRotation]): RotatableBlock
}

trait SnowableBlock extends Block {
  val snowy: Boolean
  def withSnowy(snowy: Boolean): SnowableBlock
}

trait StatefulBlock[T] extends Block {
  val state: T
  def withState(state: T): StatefulBlock[T]
}

trait StickyBlock extends Block {
  val sticky: Boolean
  def withSticky(sticky: Boolean): StickyBlock
}