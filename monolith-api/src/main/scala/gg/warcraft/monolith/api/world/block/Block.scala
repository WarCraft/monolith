package gg.warcraft.monolith.api.world.block

import gg.warcraft.monolith.api.util.JavaCaseInterop
import gg.warcraft.monolith.api.world.BlockLocation

trait Block extends JavaCaseInterop {
  val `type`: BlockType
  val solid: Boolean = true
  val liquid: Boolean = false

  val location: BlockLocation
  def withLocation(location: BlockLocation): this.type =
    copyWith("location", location)
}

trait AttachedBlock extends Block {
  val attachment: BlockAttachment
  def withAttached(attachment: BlockAttachment): this.type =
    copyWith("attachment", attachment)
}

trait BisectedBlock extends Block {
  val section: BlockBisection
  def withSection(section: BlockBisection): this.type =
    copyWith("section", section)
}

trait ColoredBlock extends Block {
  val color: BlockColor
  def withColor(color: BlockColor): this.type =
    copyWith("color", color)
}

trait ColorableBlock extends Block {
  val color: Option[BlockColor]
  def withColor(color: Option[BlockColor]): this.type =
    copyWith("color", color)
}

trait DirectedBlock extends Block {
  val direction: BlockFace
  def withDirection(direction: BlockFace): this.type =
    copyWith("direction", direction)
}

trait DirectableBlock extends Block {
  val direction: Option[BlockFace]
  def withDirection(direction: Option[BlockFace]): this.type =
    copyWith("direction", direction)
}

trait ExtendableBlock extends Block {
  val extensions: Set[BlockFace]
  def withExtensions(extensions: Set[BlockFace]): this.type =
    copyWith("extensions", extensions)
}

trait FloodableBlock extends Block {
  val flooded: Boolean
  override val liquid: Boolean = flooded
  def withFlooded(flooded: Boolean): this.type =
    copyWith("flooded", flooded)
}

trait HingedBlock extends Block {
  val hinge: BlockHinge
  def withHinge(hinge: BlockHinge): this.type =
    copyWith("hinge", hinge)
}

trait LightableBlock extends Block {
  val lit: Boolean
  def withLit(lit: Boolean): this.type =
    copyWith("lit", lit)
}

trait MaterialBlock[T <: BlockMaterial] extends Block {
  val material: T
  def withMaterial(material: T): this.type =
    copyWith("material", material)
}

trait OpenableBlock extends Block {
  val open: Boolean
  def withOpen(open: Boolean): this.type =
    copyWith("open", open)
}

trait OrientedBlock extends Block {
  val orientation: BlockOrientation
  def withOrientation(orientation: BlockOrientation): this.type =
    copyWith("orientation", orientation)
}

trait PowerableBlock extends Block {
  val powered: Boolean
  def withPowered(powered: Boolean): this.type =
    copyWith("powered", powered)
}

trait RotatableBlock extends Block {
  val rotation: Option[BlockRotation]
  def withRotation(rotation: Option[BlockRotation]): this.type =
    copyWith("rotation", rotation)
}

trait ShapedBlock[T <: BlockShape] extends Block {
  val shape: T
  def withShape(shape: T): this.type =
    copyWith("shape", shape)
}

trait SnowableBlock extends Block {
  val snowy: Boolean
  def withSnowy(snowy: Boolean): this.type =
    copyWith("snowy", snowy)
}

trait StatefulBlock[T <: BlockState] extends Block {
  val state: T
  def withState(state: T): this.type =
    copyWith("state", state)
}

trait StickyBlock extends Block {
  val sticky: Boolean
  def withSticky(sticky: Boolean): this.type =
    copyWith("sticky", sticky)
}

trait VariedBlock[T <: BlockVariant] extends Block {
  val variant: T
  def withVariant(variant: T): this.type =
    copyWith("variant", variant)
}

trait VariableBlock[T <: BlockVariant] extends Block {
  val variant: Option[T]
  def withVariant(variant: Option[T]): this.type =
    copyWith("variant", variant)
}
