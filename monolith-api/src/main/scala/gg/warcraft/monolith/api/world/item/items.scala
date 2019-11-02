package gg.warcraft.monolith.api.world.item

import gg.warcraft.monolith.api.world.block._
import gg.warcraft.monolith.api.world.block.variant._
import gg.warcraft.monolith.api.world.item
import gg.warcraft.monolith.api.world.item.variant.{StructureBlockVariant, _}

final case class Andesite(
    variant: StoniteVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[StoniteVariant]
    with StackableItem {
  val `type` = ItemType.ANDESITE
}

final case class Anvil(
    variant: AnvilVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[AnvilVariant]
    with StackableItem {
  val `type` = ItemType.ANVIL
}

final case class Apple(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.APPLE
  override val edible = true
}

final case class ArmorStand(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.ARMOR_STAND
  override def maxCount = 16
}

final case class Arrow(
    variant: ArrowVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.ARROW
}

final case class Axe(
    variant: AxeVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[AxeVariant]
    with StackableItem {
  val `type` = ItemType.AXE
}

final case class Bamboo(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BAMBOO
}

final case class Banner(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.BANNER
  override def maxCount = 16
}

final case class BannerPattern(
    variant: BannerPatternVariant,
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item {
  val `type` = ItemType.BANNER_PATTERN
}

final case class Barrel(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BARREL
}

final case class Barrier(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BARRIER
}

final case class Beacon(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BEACON
}

final case class Bed(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.BED
}

final case class Bedrock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BEDROCK
}

final case class Beef(
    variant: BeefVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[BeefVariant]
    with StackableItem {
  val `type` = ItemType.BEEF
  override val edible = true
}

final case class Beetroot(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BEETROOT
  override val edible = true
}

final case class Bell(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BELL
}

final case class BlastFurnace(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BLAST_FURNACE
}

final case class BlazePowder(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BLAZE_POWDER
}

final case class BlazeRod(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BLAZE_ROD
}

final case class Boat(
    variant: BoatVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[BoatVariant]
    with StackableItem {
  val `type` = ItemType.BOAT
}

final case class Bone(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BONE
}

final case class BoneBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BONE_BLOCK
}

final case class BoneMeal(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BONE_MEAL
}

final case class BottleOfEnchanting(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BOTTLE_OF_ENCHANTING
}

final case class Book(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BOOK
}

final case class BookAndQuill(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item {
  val `type` = ItemType.BOOK_AND_QUILL
}

final case class Bookshelf(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BOOKSHELF
}

final case class Boots(
    variant: BootsVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[BootsVariant]
    with StackableItem {
  val `type` = ItemType.BOOTS
}

final case class Bow(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.BOW
  override def maxDurability = 384
}

final case class Bowl(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BOWL
}

final case class Bread(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BREAD
  override val edible = true
}

final case class BrewingStand(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.BREWING_STAND
}

final case class Brick(
    variant: BrickVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[BrickVariant]
    with StackableItem {
  val `type` = ItemType.BRICK
}

final case class BrickBlock(
    variant: BrickBlockVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[BrickBlockVariant]
    with StackableItem {
  val `type` = ItemType.BRICK_BLOCK
}

final case class Bucket(
    variant: BucketVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[BucketVariant]
    with StackableItem {
  val `type` = ItemType.BUCKET
  override def maxCount = 16
}

final case class Button(
    variant: ButtonVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[ButtonVariant]
    with StackableItem {
  val `type` = ItemType.BUTTON
}

final case class Cactus(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CACTUS
}

final case class Cake(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item {
  val `type` = ItemType.CAKE
}

final case class Campfire(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CAMPFIRE
}

final case class Carpet(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.CARPET
}

final case class Carrot(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CARROT
  override val edible = true
}

final case class CarrotOnAStick(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.CARROT_ON_A_STICK
  override def maxDurability = 25
}

final case class CartographyTable(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CARTOGRAPHY_TABLE
}

final case class Charcoal(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CHARCOAL
}

final case class Cauldron(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CAULDRON
}

final case class Chest(
    variant: ChestVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CHEST
}

final case class Chestplate(
    variant: ChestplateVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[ChestplateVariant]
    with StackableItem {
  val `type` = ItemType.CHESTPLATE
}

final case class Chicken(
    variant: ChickenVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[ChickenVariant]
    with StackableItem {
  val `type` = ItemType.CHICKEN
  override val edible = true
}

final case class ChorusFlower(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CHORUS_FLOWER
}

final case class ChorusFruit(
    variant: ChorusFruitVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[ChorusFruitVariant]
    with StackableItem {
  val `type` = ItemType.CHORUS_FRUIT
  override val edible: Boolean =
    variant == ChorusFruitVariant.NORMAL
}

final case class ChorusPlant(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CHORUS_PLANT
}

final case class Clay(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CLAY
}

final case class ClayBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CLAY_BLOCK
}

final case class Clock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CLOCK
}

final case class Coal(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COAL
}

final case class CoalBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COAL_BLOCK
}

final case class CoalOre(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COAL_ORE
}

final case class Cobblestone(
    variant: CobblestoneVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[CobblestoneVariant]
    with StackableItem {
  val `type` = ItemType.COBBLESTONE
}

final case class Cobweb(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COBWEB
}

final case class CocoaBeans(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COCOA_BEANS
}

final case class Cod(
    variant: CodVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[CodVariant]
    with StackableItem {
  val `type` = ItemType.CHICKEN
  override val edible = true
}

final case class CommandBlock(
    variant: CommandBlockVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[CommandBlockVariant]
    with StackableItem {
  val `type` = ItemType.COMMAND_BLOCK
}

final case class Comparator(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COMPARATOR
}

final case class Compass(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COMPASS
}

final case class Composter(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COMPOSTER
}

final case class Concrete(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.CONCRETE
}

final case class ConcretePowder(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.CONCRETE_POWDER
}

final case class Conduit(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CONDUIT
}

final case class Cookie(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.COOKIE
  override val edible = true
}

final case class Coral(
    variant: CoralVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[CoralVariant]
    with StackableItem {
  val `type` = ItemType.CORAL
}

final case class CoralBlock(
    variant: CoralBlockVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[CoralBlockVariant]
    with StackableItem {
  val `type` = ItemType.CORAL_BLOCK
}

final case class CoralFan(
    variant: CoralFanVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[CoralFanVariant]
    with StackableItem {
  val `type` = ItemType.CORAL_FAN
}

final case class CraftingTable(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.CRAFTING_TABLE
}

final case class Crossbow(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.CROSSBOW
  override def maxDurability = 326
}

final case class DaylightDetector(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DAYLIGHT_DETECTOR
}

final case class DeadBush(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DEAD_BUSH
}

final case class DebugStick(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item {
  val `type` = ItemType.DEBUG_STICK
}

final case class Diamond(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DIAMOND
}

final case class DiamondBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DIAMOND_BLOCK
}

final case class DiamondOre(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DIAMOND_ORE
}

final case class Diorite(
    variant: StoniteVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[StoniteVariant]
    with StackableItem {
  val `type` = ItemType.DIORITE
}

final case class Dirt(
    coarse: Boolean,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DIRT
  def withCoarse(coarse: Boolean): Dirt =
    copyWith("coarse", coarse)
}

final case class Dispenser(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DISPENSER
}

final case class Door(
    variant: DoorVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[DoorVariant]
    with StackableItem {
  val `type` = ItemType.DOOR
}

final case class DragonBreath(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DRAGON_BREATH
}

final case class DragonEgg(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DRAGON_EGG
}

final case class DriedKelp(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DRIED_KELP
  override val edible = true
}

final case class DriedKelpBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DRIED_KELP_BLOCK
}

final case class Dropper(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.DROPPER
}

final case class Dye(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.DYE
}

final case class Egg(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.EGG
}

final case class Elytra(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.ELYTRA
  override def maxDurability = 432
}

final case class Emerald(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.EMERALD
}

final case class EmeraldBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.EMERALD_BLOCK
}

final case class EmeraldOre(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.EMERALD_ORE
}

final case class EnchantedBook(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item {
  val `type` = ItemType.ENCHANTED_BOOK
}

final case class EnchantingTable(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.ENCHANTING_TABLE
}

final case class EndCrystal(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.END_CRYSTAL
}

final case class EndPortalFrame(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.END_PORTAL_FRAME
}

final case class EndRod(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.END_ROD
}

final case class EndStone(
    variant: EndStoneVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[EndStoneVariant]
    with StackableItem {
  val `type` = ItemType.END_STONE
}

final case class EnderEye(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.ENDER_EYE
}

final case class EnderPearl(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.ENDER_PEARL
  override def maxCount = 16
}

final case class Farmland(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FARMLAND
}

final case class Feather(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FEATHER
}

final case class Fence(
    variant: FenceVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[FenceVariant]
    with StackableItem {
  val `type` = ItemType.FENCE
}

final case class Fern(
    tall: Boolean,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FERN
  def withTall(tall: Boolean): Fern =
    copyWith("tall", tall)
}

final case class FireCharge(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FIRE_CHARGE
}

final case class FireworkRocket(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FIREWORK_ROCKET
}

final case class FireworkStar(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.FIREWORK_STAR
}

final case class FishingRod(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.FISHING_ROD
  override def maxDurability = 64
}

final case class FletchingTable(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FLETCHING_TABLE
}

final case class Flint(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FLINT
}

final case class FlintAndSteel(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.FLINT_AND_STEEL
  override def maxDurability = 64
}

final case class Flower(
    variant: FlowerVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[FlowerVariant]
    with StackableItem {
  val `type` = ItemType.FLOWER
}

final case class FlowerPot(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FLOWER_POT
}

final case class Furnace(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.FURNACE
}

final case class FenceGate(
    variant: FenceGateVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[FenceGateVariant]
    with StackableItem {
  val `type` = ItemType.FENCE_GATE
}

final case class GhastTear(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GHAST_TEAR
}

final case class Glass(
    color: Option[BlockColor],
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColorableItem
    with StackableItem {
  val `type` = ItemType.GLASS
}

final case class GlassBottle(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GLASS_BOTTLE
}

final case class GlassPane(
    color: Option[BlockColor],
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColorableItem
    with StackableItem {
  val `type` = ItemType.GLASS_PANE
}

final case class GlazedTerracotta(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.GLAZED_TERRACOTTA
}

final case class Glowstone(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GLOWSTONE
}

final case class GlowstoneDust(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GLOWSTONE_DUST
}

final case class GoldBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GOLD_BLOCK
}

final case class GoldIngot(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GOLD_INGOT
}

final case class GoldNugget(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GOLD_NUGGET
}

final case class GoldOre(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GOLD_ORE
}

final case class GoldenApple(
    enchanted: Boolean,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item
    with StackableItem {
  val `type` = ItemType.GOLDEN_APPLE
  override val edible = true
  def withEnchanted(enchanted: Boolean): GoldenApple =
    copyWith("enchanted", enchanted)
}

final case class GoldenCarrot(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GOLDEN_CARROT
  override val edible = true
}

final case class GoldenMelonSlice(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GOLDEN_MELON_SLICE
}

final case class Granite(
    variant: StoniteVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[StoniteVariant]
    with StackableItem {
  val `type` = ItemType.GRANITE
}

final case class Grass(
    tall: Boolean,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GRASS
  def withTall(tall: Boolean): Grass =
    copyWith("tall", tall)
}

final case class GrassBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GRASS_BLOCK
}

final case class GrassPath(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GRASS_PATH
}

final case class Gravel(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GRAVEL
}

final case class Grindstone(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GRINDSTONE
}

final case class Gunpowder(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.GUNPOWDER
}

final case class HayBale(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.HAY_BALE
}

final case class HeartOfTheSea(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.HEART_OF_THE_SEA
}

final case class Helmet(
    variant: HelmetVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[HelmetVariant]
    with StackableItem {
  val `type` = ItemType.HELMET
}

final case class Hoe(
    variant: HoeVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[HoeVariant]
    with StackableItem {
  val `type` = ItemType.HOE
}

final case class Hopper(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.HOPPER
}

final case class HorseArmor(
    variant: HorseArmorVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.HORSE_ARMOR
}

final case class Ice(
    variant: IceVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[IceVariant]
    with StackableItem {
  val `type` = ItemType.ICE
}

final case class InfestedBlock(
    variant: InfestedBlockVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[InfestedBlockVariant]
    with StackableItem {
  val `type` = ItemType.INFESTED_BLOCK
}

final case class InkSac(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.INK_SAC
}

final case class IronBars(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.IRON_BARS
}

final case class IronBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.IRON_BLOCK
}

final case class IronIngot(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.IRON_INGOT
}

final case class IronNugget(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.IRON_NUGGET
}

final case class IronOre(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.IRON_ORE
}

final case class ItemFrame(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.ITEM_FRAME
}

final case class JackOfTheLantern(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.JACK_OF_THE_LANTERN
}

final case class JigsawBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.JIGSAW_BLOCK
}

final case class Jukebox(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.JUKEBOX
}

final case class Kelp(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.KELP
}

final case class KnowledgeBook(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item {
  val `type` = ItemType.KNOWLEDGE_BOOK
}

final case class Ladder(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LADDER
}

final case class Lantern(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LANTERN
}

final case class Lapis(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LAPIS
}

final case class LapisBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LAPIS_BLOCK
}

final case class LapisOre(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LAPIS_ORE
}

final case class Lead(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LEAD
}

final case class Leather(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LEATHER
}

final case class Leaves(
    variant: LeavesVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[LeavesVariant]
    with StackableItem {
  val `type` = ItemType.LEAVES
}

final case class Lectern(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LECTERN
}

final case class Leggings(
    variant: LeggingsVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[LeggingsVariant]
    with StackableItem {
  val `type` = ItemType.LEGGINGS
}

final case class Lever(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LEVER
}

final case class LilyPad(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LILY_PAD
}

final case class Log(
    variant: LogVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[LogVariant]
    with StackableItem {
  val `type` = ItemType.LOG
}

final case class Loom(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.LOOM
}

final case class MagmaBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.MAGMA_BLOCK
}

final case class MagmaCream(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.MAGMA_CREAM
}

final case class Map(
    filled: Boolean,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.MAP
  def withFilled(filled: Boolean): Map =
    copyWith("filled", filled)
}

final case class Melon(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.MELON
}

final case class MelonSlice(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.MELON_SLICE
  override val edible = true
}

final case class Minecart(
    variant: MinecartVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[MinecartVariant]
    with StackableItem {
  val `type` = ItemType.MINECART
}

// TODO add separate playerSkull item with name String
final case class MobHead(
    variant: MobHeadVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.MOB_HEAD
}

final case class Mushroom(
    variant: MushroomVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[MushroomVariant]
    with StackableItem {
  val `type` = ItemType.MUSHROOM
}

final case class MushroomBlock(
    variant: MushroomBlockVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[MushroomBlockVariant]
    with StackableItem {
  val `type` = ItemType.MUSHROOM_BLOCK
}

final case class MusicDisc(
    variant: MusicDiscVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[MusicDiscVariant]
    with StackableItem {
  val `type` = ItemType.MUSIC_DISC
}

final case class Mutton(
    variant: MuttonVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[MuttonVariant]
    with StackableItem {
  val `type` = ItemType.MUTTON
  override val edible = true
}

final case class Mycelium(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.MYCELIUM
}

final case class NameTag(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.NAME_TAG
}

final case class NautilusShell(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.NAUTILUS_SHELL
}

final case class Netherrack(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.NETHERRACK
}

final case class NetherStar(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.NETHER_STAR
}

final case class NetherWart(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.NETHER_WART
}

final case class NetherWartBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.NETHER_WART_BLOCK
}

final case class NoteBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.NOTE_BLOCK
}

final case class Observer(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.OBSERVER
}

final case class Obsidian(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.OBSIDIAN
}

final case class Painting(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PAINTING
}

final case class Paper(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PAPER
}

final case class PhantomMembrane(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PHANTOM_MEMBRANE
}

final case class Plant(
    variant: PlantVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PlantVariant]
    with StackableItem {
  val `type` = ItemType.PLANT
}

final case class Pickaxe(
    variant: PickaxeVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PickaxeVariant]
    with StackableItem {
  val `type` = ItemType.PICKAXE
}

final case class Pillar(
    variant: PillarVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PillarVariant]
    with StackableItem {
  val `type` = ItemType.PILLAR
}

final case class Piston(
    sticky: Boolean,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PISTON
  def withSticky(sticky: Boolean): Piston =
    copyWith("sticky", sticky)
}

final case class Planks(
    variant: PlanksVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PlanksVariant]
    with StackableItem {
  val `type` = ItemType.PLANKS
}

final case class Podzol(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PODZOL
}

final case class Porkchop(
    variant: PorkchopVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PorkchopVariant]
    with StackableItem {
  val `type` = ItemType.PORKCHOP
  override val edible = true
}

final case class Potato(
    variant: PotatoVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PotatoVariant]
    with StackableItem {
  val `type` = ItemType.POTATO
  override val edible = true
}

final case class Potion(
    variant: PotionVariant,
    hideEffects: Boolean,
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PotionVariant] {
  val `type` = ItemType.POTION
  def withHideEffects(hideEffects: Boolean): this.type =
    copyWith("hideEffects", hideEffects)
}

final case class PressurePlate(
    variant: PressurePlateVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PressurePlateVariant]
    with StackableItem {
  val `type` = ItemType.PRESSURE_PLATE
}

final case class Prismarine(
    variant: PrismarineVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[PrismarineVariant]
    with StackableItem {
  val `type` = ItemType.PRISMARINE
}

final case class PrismarineCrystals(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PRISMARINE_CRYSTALS
}

final case class PrismarineShard(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PRISMARINE_SHARD
}

final case class Pufferfish(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PUFFERFISH
  override val edible = true
}

final case class Pumpkin(
    carved: Boolean,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PUMPKIN
}

final case class PumpkinPie(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PUMPKIN_PIE
  override val edible = true
}

final case class PurpurBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.PURPUR_BLOCK
}

final case class Quartz(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.QUARTZ
}

final case class QuartzBlock(
    variant: QuartzBlockVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[QuartzBlockVariant]
    with StackableItem {
  val `type` = ItemType.QUARTZ_BLOCK
}

final case class QuartzOre(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.QUARTZ_ORE
}

final case class Rabbit(
    variant: RabbitVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[RabbitVariant]
    with StackableItem {
  val `type` = ItemType.RABBIT
  override val edible = true
}

final case class RabbitFoot(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.RABBIT_FOOT
}

final case class RabbitHide(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.RABBIT_HIDE
}

final case class Rail(
    variant: RailVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[RailVariant]
    with StackableItem {
  val `type` = ItemType.RAIL
}

final case class Repeater(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.REPEATER
}

final case class Redstone(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.REDSTONE
}

final case class RedstoneBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.REDSTONE_BLOCK
}

final case class RedstoneLamp(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.REDSTONE_LAMP
}

final case class RedstoneOre(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.REDSTONE_ORE
}

final case class RedstoneTorch(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.REDSTONE_TORCH
}

final case class RottenFlesh(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.ROTTEN_FLESH
  override val edible = true
}

final case class Saddle(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item {
  val `type` = ItemType.SADDLE
}

final case class Salmon(
    variant: SalmonVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SalmonVariant]
    with StackableItem {
  val `type` = ItemType.SALMON
  override val edible = true
}

final case class Sand(
    variant: SandVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SandVariant]
    with StackableItem {
  val `type` = ItemType.SAND
}

final case class Sandstone(
    variant: SandstoneVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SandstoneVariant]
    with StackableItem {
  val `type` = ItemType.SANDSTONE
}

final case class Sapling(
    variant: item.variant.SaplingVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[item.variant.SaplingVariant]
    with StackableItem {
  val `type` = ItemType.SAPLING
}

final case class Scaffolding(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SCAFFOLDING
}

final case class Scute(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SCUTE
}

final case class Seagrass(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SEAGRASS
}

final case class SeaLantern(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SEA_LANTERN
}

final case class SeaPickle(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SEA_PICKLE
}

final case class Seeds(
    variant: SeedsVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SeedsVariant]
    with StackableItem {
  val `type` = ItemType.SEEDS
}

final case class Shears(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.SHEARS
  override def maxDurability = 238
}

final case class Shield(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.SHIELD
  override def maxDurability = 336
}

final case class Shovel(
    variant: ShovelVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[ShovelVariant]
    with StackableItem {
  val `type` = ItemType.SHOVEL
}

final case class ShulkerBox(
    color: Option[BlockColor],
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColorableItem
    with StackableItem {
  val `type` = ItemType.SHULKER_BOX
}

final case class ShulkerShell(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SHULKER_SHELL
}

final case class Sign(
    variant: SignVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SignVariant]
    with StackableItem {
  val `type` = ItemType.SIGN
  override def maxCount = 16
}

final case class Slab(
    variant: SlabVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SlabVariant]
    with StackableItem {
  val `type` = ItemType.SLAB
}

final case class Slimeball(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SLIMEBALL
}

final case class SlimeBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SLIME_BLOCK
}

final case class SmithingTable(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SMITHING_TABLE
}

final case class Smoker(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SMOKER
}

final case class Snow(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SNOW
}

final case class Snowball(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SNOWBALL
  override def maxCount = 16
}

final case class SnowBlock(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SNOW_BLOCK
}

final case class SoulSand(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SOUL_SAND
}

final case class SpawnEgg(
    variant: SpawnEggVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SpawnEggVariant]
    with StackableItem {
  val `type` = ItemType.SPAWN_EGG
}

final case class Spawner(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SPAWNER
}

final case class SpiderEye(
    variant: SpiderEyeVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SpiderEyeVariant]
    with StackableItem {
  val `type` = ItemType.SPIDER_EYE
  override val edible: Boolean =
    variant == SpiderEyeVariant.NORMAL
}

final case class Sponge(
    variant: SpongeVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SpongeVariant]
    with StackableItem {
  val `type` = ItemType.SPONGE
}

final case class Stairs(
    variant: StairsVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[StairsVariant]
    with StackableItem {
  val `type` = ItemType.SLAB
}

final case class Stew(
    variant: StewVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[StewVariant]
    with StackableItem {
  val `type` = ItemType.STEW
  override val edible = true
}

final case class Stick(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.STICK
}

final case class Stone(
    variant: StoneVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[StoneVariant]
    with StackableItem {
  val `type` = ItemType.STONE
}

final case class Stonecutter(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.STONECUTTER
}

final case class StructureBlock(
    variant: StructureBlockVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[StructureBlockVariant]
    with StackableItem {
  val `type` = ItemType.STRUCTURE_BLOCK
}

final case class PieceOfString(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.STRING
}

final case class Sugar(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SUGAR
}

final case class SugarCane(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SUGAR_CANE
}

final case class SweetBerries(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.SWEET_BERRIES
  override val edible = true
}

final case class Sword(
    variant: SwordVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[SwordVariant]
    with StackableItem {
  val `type` = ItemType.SWORD
}

final case class Terracotta(
    color: Option[BlockColor],
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColorableItem
    with StackableItem {
  val `type` = ItemType.TERRACOTTA
}

final case class TNT(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.TNT
}

final case class Torch(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.TORCH
}

final case class TotemOfUndying(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean
) extends Item {
  val `type` = ItemType.TOTEM_OF_UNDYING
}

final case class Trapdoor(
    variant: TrapdoorVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[TrapdoorVariant]
    with StackableItem {
  val `type` = ItemType.TRAPDOOR
}

final case class Trident(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.TRIDENT
  override def maxDurability = 250
}

final case class TripwireHook(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.TRIPWIRE_HOOK
}

final case class TropicalFish(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.TROPICAL_FISH
  override val edible = true
}

final case class TurtleEgg(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.TURTLE_EGG
}

final case class TurtleHelmet(
    name: String,
    tooltip: Array[String],
    attributes: Set[String],
    hideAttributes: Boolean,
    durability: Int,
    unbreakable: Boolean,
    hideUnbreakable: Boolean
) extends DurableItem {
  val `type` = ItemType.TURTLE_HELMET
  override def maxDurability = 275
}

final case class Vine(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.VINE
}

final case class Wall(
    variant: WallVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[WallVariant]
    with StackableItem {
  val `type` = ItemType.WALL
}

final case class WeightedPressurePlate(
    variant: WeightedPressurePlateVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[WeightedPressurePlateVariant]
    with StackableItem {
  val `type` = ItemType.WEIGHTED_PRESSURE_PLATE
}

final case class Wheat(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.WHEAT
}

final case class Wood(
    variant: WoodVariant,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends VariableItem[WoodVariant]
    with StackableItem {
  val `type` = ItemType.WOOD
}

final case class Wool(
    color: BlockColor,
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends ColoredItem
    with StackableItem {
  val `type` = ItemType.WOOL
}

final case class WrittenBook(
    name: String,
    tooltip: Array[String],
    count: Int,
    attributes: Set[String],
    hideAttributes: Boolean
) extends StackableItem {
  val `type` = ItemType.WRITTEN_BOOK
  override def maxCount = 16
}
