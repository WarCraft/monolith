package gg.warcraft.monolith.spigot.world.item

import gg.warcraft.monolith.api.world.block.variant._
import gg.warcraft.monolith.api.world.item._
import gg.warcraft.monolith.api.world.item.variant._
import gg.warcraft.monolith.spigot.Extensions._
import javax.inject.Inject
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag

class SpigotItemMapper @Inject() (
    private val colorMapper: SpigotItemColorMapper,
    private val materialMapper: SpigotItemMaterialMapper,
    private val variantMapper: SpigotItemVariantMapper
) {
  def map(item: SpigotItemStack): Option[Item] = {
    // return None if Air
    val material = item.getType
    if (material.name.endsWith("AIR")) return None

    // Set common item data
    val meta = item.getItemMeta
    val name = meta.getDisplayName
    val tooltip: Array[String] = Array() // TODO item.getItemMeta.getLore
    val attr = Set.empty[String] // TODO map attributes
    val hideAttr = meta.hasItemFlag(ItemFlag.HIDE_ATTRIBUTES)

    // Lazily compute generic item data
    lazy val color = colorMapper.map(material)
    lazy val count = item.getAmount
    lazy val durability = item.getDurability.toInt // TODO keep int or let be short?
    lazy val unbreakable = meta.isUnbreakable
    lazy val hideUnbreakable = meta.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE)
    lazy val variant = variantMapper.map(item)

    // Lazily construct tuples for all the different types of parameter sets
    lazy val params = (name, tooltip, count, attr, hideAttr)
    lazy val colorParams = (color, name, tooltip, count, attr, hideAttr)
    lazy val colorableParams = (Option(color), name, tooltip, count, attr, hideAttr)
    lazy val singleParams = (name, tooltip, attr, hideAttr)
    lazy val durableParams =
      (name, tooltip, attr, hideAttr, durability, unbreakable, hideUnbreakable)
    def params[T <: ItemVariant] =
      (variant.asInstanceOf[T], name, tooltip, count, attr, hideAttr)

    // Map item
    Some(material match {
      case Material.APPLE                  => Apple.tupled(params)
      case Material.ARMOR_STAND            => ArmorStand.tupled(params)
      case Material.BAMBOO                 => Bamboo.tupled(params)
      case Material.BARREL                 => Barrel.tupled(params)
      case Material.BARRIER                => Barrier.tupled(params)
      case Material.BEACON                 => Beacon.tupled(params)
      case Material.BEDROCK                => Bedrock.tupled(params)
      case Material.BEETROOT               => Beetroot.tupled(params)
      case Material.BELL                   => Bell.tupled(params)
      case Material.BLAST_FURNACE          => BlastFurnace.tupled(params)
      case Material.BLAZE_POWDER           => BlazeRod.tupled(params)
      case Material.BLAZE_ROD              => BlazeRod.tupled(params)
      case Material.BONE                   => Bone.tupled(params)
      case Material.BONE_BLOCK             => BoneBlock.tupled(params)
      case Material.BONE_MEAL              => BoneMeal.tupled(params)
      case Material.BOOK                   => Book.tupled(params)
      case Material.BOOKSHELF              => Bookshelf.tupled(params)
      case Material.BOW                    => Bow.tupled(durableParams)
      case Material.BOWL                   => Bowl.tupled(params)
      case Material.BREAD                  => Bread.tupled(params)
      case Material.BREWING_STAND          => BrewingStand.tupled(params)
      case Material.CACTUS                 => Cactus.tupled(params)
      case Material.CAKE                   => Cake.tupled(singleParams)
      case Material.CAMPFIRE               => Campfire.tupled(params)
      case Material.CARROT                 => Carrot.tupled(params)
      case Material.CARROT_ON_A_STICK      => CarrotOnAStick.tupled(durableParams)
      case Material.CARTOGRAPHY_TABLE      => CartographyTable.tupled(params)
      case Material.CAULDRON               => Cauldron.tupled(params)
      case Material.CHARCOAL               => Charcoal.tupled(params)
      case Material.CHORUS_FLOWER          => ChorusFlower.tupled(params)
      case Material.CHORUS_PLANT           => ChorusPlant.tupled(params)
      case Material.CLAY                   => ClayBlock.tupled(params)
      case Material.CLAY_BALL              => Clay.tupled(params)
      case Material.CLOCK                  => Clock.tupled(params)
      case Material.COAL                   => Coal.tupled(params)
      case Material.COAL_BLOCK             => CoalBlock.tupled(params)
      case Material.COAL_ORE               => CoalOre.tupled(params)
      case Material.COBWEB                 => Cobweb.tupled(params)
      case Material.COCOA_BEANS            => CocoaBeans.tupled(params)
      case Material.COMPARATOR             => Comparator.tupled(params)
      case Material.COMPASS                => Compass.tupled(params)
      case Material.COMPOSTER              => Composter.tupled(params)
      case Material.CONDUIT                => Conduit.tupled(params)
      case Material.COOKIE                 => Cookie.tupled(params)
      case Material.CRAFTING_TABLE         => CraftingTable.tupled(params)
      case Material.CROSSBOW               => Crossbow.tupled(durableParams)
      case Material.DAYLIGHT_DETECTOR      => DaylightDetector.tupled(params)
      case Material.DEAD_BUSH              => DeadBush.tupled(params)
      case Material.DEBUG_STICK            => DebugStick.tupled(singleParams)
      case Material.DIAMOND                => Diamond.tupled(params)
      case Material.DIAMOND_BLOCK          => DiamondBlock.tupled(params)
      case Material.DIAMOND_ORE            => DiamondOre.tupled(params)
      case Material.DISPENSER              => Dispenser.tupled(params)
      case Material.DRAGON_BREATH          => DragonBreath.tupled(params)
      case Material.DRAGON_EGG             => DragonEgg.tupled(params)
      case Material.DRIED_KELP             => DriedKelp.tupled(params)
      case Material.DRIED_KELP_BLOCK       => DriedKelpBlock.tupled(params)
      case Material.DROPPER                => Dropper.tupled(params)
      case Material.EGG                    => Egg.tupled(params)
      case Material.ELYTRA                 => Elytra.tupled(durableParams)
      case Material.EMERALD                => Emerald.tupled(params)
      case Material.EMERALD_BLOCK          => EmeraldBlock.tupled(params)
      case Material.EMERALD_ORE            => EmeraldOre.tupled(params)
      case Material.ENCHANTED_BOOK         => EnchantedBook.tupled(singleParams)
      case Material.ENCHANTING_TABLE       => EnchantingTable.tupled(params)
      case Material.ENDER_EYE              => EnderEye.tupled(params)
      case Material.ENDER_PEARL            => EnderPearl.tupled(params)
      case Material.END_CRYSTAL            => EndCrystal.tupled(params)
      case Material.END_PORTAL_FRAME       => EndPortalFrame.tupled(params)
      case Material.END_ROD                => EndRod.tupled(params)
      case Material.EXPERIENCE_BOTTLE      => BottleOfEnchanting.tupled(params)
      case Material.FARMLAND               => Farmland.tupled(params)
      case Material.FEATHER                => Feather.tupled(params)
      case Material.FISHING_ROD            => FishingRod.tupled(durableParams)
      case Material.FIREWORK_ROCKET        => FireworkRocket.tupled(params)
      case Material.FIREWORK_STAR          => FireworkStar.tupled(colorParams)
      case Material.FIRE_CHARGE            => FireCharge.tupled(params)
      case Material.FLETCHING_TABLE        => FletchingTable.tupled(params)
      case Material.FLINT                  => Flint.tupled(params)
      case Material.FLINT_AND_STEEL        => FlintAndSteel.tupled(durableParams)
      case Material.FLOWER_POT             => FlowerPot.tupled(params)
      case Material.FURNACE                => Furnace.tupled(params)
      case Material.GHAST_TEAR             => GhastTear.tupled(params)
      case Material.GLASS_BOTTLE           => GlassBottle.tupled(params)
      case Material.GLISTERING_MELON_SLICE => GoldenMelonSlice.tupled(params)
      case Material.GLOWSTONE              => Glowstone.tupled(params)
      case Material.GLOWSTONE_DUST         => GlowstoneDust.tupled(params)
      case Material.GOLDEN_CARROT          => GoldenCarrot.tupled(params)
      case Material.GOLD_BLOCK             => GoldBlock.tupled(params)
      case Material.GOLD_INGOT             => GoldIngot.tupled(params)
      case Material.GOLD_NUGGET            => GoldNugget.tupled(params)
      case Material.GOLD_ORE               => GoldOre.tupled(params)
      case Material.GRASS_BLOCK            => GrassBlock.tupled(params)
      case Material.GRASS_PATH             => GrassPath.tupled(params)
      case Material.GRAVEL                 => Gravel.tupled(params)
      case Material.GRINDSTONE             => Grindstone.tupled(params)
      case Material.GUNPOWDER              => Gunpowder.tupled(params)
      case Material.HAY_BLOCK              => HayBale.tupled(params)
      case Material.HEART_OF_THE_SEA       => HeartOfTheSea.tupled(params)
      case Material.HOPPER                 => Hopper.tupled(params)
      case Material.INK_SAC                => InkSac.tupled(params)
      case Material.IRON_BARS              => IronBars.tupled(params)
      case Material.IRON_BLOCK             => IronBlock.tupled(params)
      case Material.IRON_INGOT             => IronIngot.tupled(params)
      case Material.IRON_NUGGET            => IronNugget.tupled(params)
      case Material.IRON_ORE               => IronOre.tupled(params)
      case Material.ITEM_FRAME             => ItemFrame.tupled(params)
      case Material.JACK_O_LANTERN         => JackOfTheLantern.tupled(params)
      case Material.JIGSAW                 => JigsawBlock.tupled(params)
      case Material.JUKEBOX                => Jukebox.tupled(params)
      case Material.KELP                   => Kelp.tupled(params)
      case Material.KNOWLEDGE_BOOK         => KnowledgeBook.tupled(singleParams)
      case Material.LADDER                 => Ladder.tupled(params)
      case Material.LANTERN                => Lantern.tupled(params)
      case Material.LAPIS_BLOCK            => LapisBlock.tupled(params)
      case Material.LAPIS_LAZULI           => Lapis.tupled(params)
      case Material.LAPIS_ORE              => LapisOre.tupled(params)
      case Material.LEAD                   => Lead.tupled(params)
      case Material.LEATHER                => Leather.tupled(params)
      case Material.LECTERN                => Lectern.tupled(params)
      case Material.LEVER                  => Lever.tupled(params)
      case Material.LILY_PAD               => LilyPad.tupled(params)
      case Material.LOOM                   => Loom.tupled(params)
      case Material.MAGMA_BLOCK            => MagmaBlock.tupled(params)
      case Material.MAGMA_CREAM            => MagmaCream.tupled(params)
      case Material.MELON                  => Melon.tupled(params)
      case Material.MELON_SLICE            => MelonSlice.tupled(params)
      case Material.MYCELIUM               => Mycelium.tupled(params)
      case Material.NAME_TAG               => NameTag.tupled(params)
      case Material.NAUTILUS_SHELL         => NautilusShell.tupled(params)
      case Material.NETHERRACK             => Netherrack.tupled(params)
      case Material.NETHER_QUARTZ_ORE      => QuartzOre.tupled(params)
      case Material.NETHER_STAR            => NetherStar.tupled(params)
      case Material.NETHER_WART            => NetherWart.tupled(params)
      case Material.NETHER_WART_BLOCK      => NetherWartBlock.tupled(params)
      case Material.NOTE_BLOCK             => NoteBlock.tupled(params)
      case Material.OBSERVER               => Observer.tupled(params)
      case Material.OBSIDIAN               => Obsidian.tupled(params)
      case Material.PAINTING               => Painting.tupled(params)
      case Material.PAPER                  => Paper.tupled(params)
      case Material.PHANTOM_MEMBRANE       => PhantomMembrane.tupled(params)
      case Material.PODZOL                 => Podzol.tupled(params)
      case Material.POISONOUS_POTATO       => PoisonousPotato.tupled(params)
      case Material.PRISMARINE_CRYSTALS    => PrismarineCrystals.tupled(params)
      case Material.PRISMARINE_SHARD       => PrismarineShard.tupled(params)
      case Material.PUFFERFISH             => Pufferfish.tupled(params)
      case Material.PUMPKIN_PIE            => PumpkinPie.tupled(params)
      case Material.PURPUR_BLOCK           => PurpurBlock.tupled(params)
      case Material.QUARTZ                 => Quartz.tupled(params)
      case Material.RABBIT_FOOT            => RabbitFoot.tupled(params)
      case Material.RABBIT_HIDE            => RabbitHide.tupled(params)
      case Material.REDSTONE               => Redstone.tupled(params)
      case Material.REDSTONE_BLOCK         => RedstoneBlock.tupled(params)
      case Material.REDSTONE_LAMP          => RedstoneLamp.tupled(params)
      case Material.REDSTONE_ORE           => RedstoneOre.tupled(params)
      case Material.REDSTONE_TORCH         => RedstoneTorch.tupled(params)
      case Material.REPEATER               => Repeater.tupled(params)
      case Material.ROTTEN_FLESH           => RottenFlesh.tupled(params)
      case Material.SADDLE                 => Saddle.tupled(singleParams)
      case Material.SCAFFOLDING            => Scaffolding.tupled(params)
      case Material.SCUTE                  => Scute.tupled(params)
      case Material.SEAGRASS               => Seagrass.tupled(params)
      case Material.SEA_LANTERN            => SeaLantern.tupled(params)
      case Material.SEA_PICKLE             => SeaPickle.tupled(params)
      case Material.SHEARS                 => Shears.tupled(durableParams)
      case Material.SHIELD                 => Shield.tupled(durableParams)
      case Material.SHULKER_SHELL          => ShulkerShell.tupled(params)
      case Material.SLIME_BALL             => Slimeball.tupled(params)
      case Material.SLIME_BLOCK            => SlimeBlock.tupled(params)
      case Material.SMITHING_TABLE         => SmithingTable.tupled(params)
      case Material.SMOKER                 => Smoker.tupled(params)
      case Material.SNOW                   => Snow.tupled(params)
      case Material.SNOWBALL               => Snowball.tupled(params)
      case Material.SNOW_BLOCK             => SnowBlock.tupled(params)
      case Material.SOUL_SAND              => SoulSand.tupled(params)
      case Material.SPAWNER                => Spawner.tupled(params)
      case Material.STICK                  => Stick.tupled(params)
      case Material.STONECUTTER            => Stonecutter.tupled(params)
      case Material.STRING                 => PieceOfString.tupled(params)
      case Material.SUGAR                  => Sugar.tupled(params)
      case Material.SUGAR_CANE             => SugarCane.tupled(params)
      case Material.SWEET_BERRIES          => SweetBerries.tupled(params)
      case Material.TNT                    => TNT.tupled(params)
      case Material.TORCH                  => Torch.tupled(params)
      case Material.TOTEM_OF_UNDYING       => TotemOfUndying.tupled(singleParams)
      case Material.TRIDENT                => Trident.tupled(durableParams)
      case Material.TRIPWIRE_HOOK          => TripwireHook.tupled(params)
      case Material.TROPICAL_FISH          => TropicalFish.tupled(params)
      case Material.TURTLE_EGG             => TurtleEgg.tupled(params)
      case Material.TURTLE_HELMET          => TurtleHelmet.tupled(durableParams)
      case Material.VINE                   => Vine.tupled(params)
      case Material.WHEAT                  => Wheat.tupled(params)
      case Material.WRITABLE_BOOK          => BookAndQuill.tupled(singleParams)
      case Material.WRITTEN_BOOK           => WrittenBook.tupled(params)

      // TODO andesite etc are split in items, but merged in block, choose

      //      case Material.MUTTON  => Mutton(cooked = false, name, tooltip, count, attr, hideAttr)
      //      case Material.BAKED_POTATO => Potato(cooked = true, name, tooltip, count, attr, hideAttr)
      //      case Material.BEEF => Beef(cooked = false, name, tooltip, count, attr, hideAttr)
      //      case Material.CARVED_PUMPKIN => Pumpkin(carved = true, name, tooltip, count, attr, hideAttr)
      //      case Material.CHICKEN => Chicken(cooked = false, name, tooltip, count, attr, hideAttr)
      //      case Material.CHORUS_FRUIT => ChorusFruit(popped = false, name, tooltip, count, attr, hideAttr)
      //      case Material.COARSE_DIRT => Dirt(coarse = true, name, tooltip, count, attr, hideAttr)
      //      case Material.COD => Cod(cooked = false, name, tooltip, count, attr, hideAttr)
      //      case Material.COOKED_BEEF => Beef(cooked = true, name, tooltip, count, attr, hideAttr)
      //      case Material.COOKED_CHICKEN => Chicken(cooked = true, name, tooltip, count, attr, hideAttr)
      //      case Material.COOKED_COD => Cod(cooked = true, name, tooltip, count, attr, hideAttr)
      //      case Material.COOKED_MUTTON => Mutton(cooked = true, name, tooltip, count, attr, hideAttr)
      //      case Material.COOKED_PORKCHOP => Porkchop(cooked = true, name, tooltip, count, attr, hideAttr)
      //      case Material.COOKED_RABBIT => Rabbit(cooked = true, name, tooltip, count, attr, hideAttr)
      //      case Material.COOKED_SALMON => Salmon(cooked = true, name, tooltip, count, attr, hideAttr)
      //      case Material.DIRT => Dirt(coarse = false, name, tooltip, count, attr, hideAttr)
      //      case Material.ENCHANTED_GOLDEN_APPLE => GoldenApple(enchanted = true, name, tooltip, count, attr, hideAttr)
      //      case Material.FERMENTED_SPIDER_EYE => SpiderEye(fermented = true, name, tooltip, count, attr, hideAttr)
      //      case Material.FERN       => Fern(tall = false, name, tooltip, count, attr, hideAttr)
      //      case Material.FILLED_MAP => Map(filled = true, name, tooltip, count, attr, hideAttr)
      //      case Material.GOLDEN_APPLE => GoldenApple(enchanted = false, name, tooltip, count, attr, hideAttr)
      //      case Material.GRASS      => Grass(tall = false, name, tooltip, count, attr, hideAttr)
      //      case Material.LARGE_FERN => Fern(tall = true, name, tooltip, count, attr, hideAttr)
      //      case Material.MAP        => Map(filled = false, name, tooltip, count, attr, hideAttr)
      //      case Material.PISTON => Piston(sticky = false, name, tooltip, count, attr, hideAttr)
      //      case Material.POPPED_CHORUS_FRUIT => ChorusFruit(popped = true, name, tooltip, count, attr, hideAttr)
      //      case Material.PORKCHOP => Porkchop(cooked = false, name, tooltip, count, attr, hideAttr)
      //      case Material.POTATO => Potato(cooked = false, name, tooltip, count, attr, hideAttr)
      //      case Material.PUMPKIN => Pumpkin(carved = false, name, tooltip, count, attr, hideAttr)
      //      case Material.RABBIT => Rabbit(cooked = false, name, tooltip, count, attr, hideAttr)
      //      case Material.SALMON => Salmon(cooked = false, name, tooltip, count, attr, hideAttr)
      //      case Material.SPIDER_EYE => SpiderEye(fermented = false, name, tooltip, count, attr, hideAttr)
      //      case Material.SPONGE => Sponge(wet = false, name, tooltip, count, attr, hideAttr)
      //      case Material.STICKY_PISTON => Piston(sticky = true, name, tooltip, count, attr, hideAttr)
      //      case Material.TALL_GRASS => Grass(tall = true, name, tooltip, count, attr, hideAttr)
      //      case Material.WET_SPONGE => Sponge(wet = true, name, tooltip, count, attr, hideAttr)

      case m if m.isAnvil            => Anvil.tupled(params[AnvilVariant])
      case m if m.isArrow            => Arrow.tupled(params[ArrowVariant])
      case m if m.isBanner           => Banner.tupled(colorParams)
      case m if m.isBed              => Bed.tupled(colorParams)
      case m if m.isBoat             => Boat.tupled(params[BoatVariant])
      case m if m.isBrick            => Brick.tupled(params[BrickVariant])
      case m if m.isBrickBlock       => BrickBlock.tupled(params[BrickBlockVariant])
      case m if m.isBucket           => Bucket.tupled(params[BucketVariant])
      case m if m.isButton           => Button.tupled(params[ButtonVariant])
      case m if m.isCarpet           => Carpet.tupled(colorParams)
      case m if m.isCobblestone      => Cobblestone.tupled(params[CobblestoneVariant])
      case m if m.isChest            => Chest.tupled(params[ChestVariant])
      case m if m.isConcrete         => Concrete.tupled(colorParams)
      case m if m.isConcretePowder   => ConcretePowder.tupled(colorParams)
      case m if m.isCoral            => Coral.tupled(params[CoralVariant])
      case m if m.isCoralBlock       => CoralBlock.tupled(params[CoralBlockVariant])
      case m if m.isCoralFan         => CoralFan.tupled(params[CoralFanVariant])
      case m if m.isDye              => Dye.tupled(colorParams)
      case m if m.isEndStone         => EndStone.tupled(params[EndStoneVariant])
      case m if m.isFence            => Fence.tupled(params[FenceVariant])
      case m if m.isFenceGate        => FenceGate.tupled(params[FenceGateVariant])
      case m if m.isFlower           => Flower.tupled(params[FlowerVariant])
      case m if m.isGlass            => Glass.tupled(colorableParams)
      case m if m.isGlassPane        => GlassPane.tupled(colorableParams)
      case m if m.isGlazedTerracotta => GlazedTerracotta.tupled(colorParams)
      case m if m.isHorseArmor       => HorseArmor.tupled(params[HorseArmorVariant])
      case m if m.isIce              => Ice.tupled(params[IceVariant])
      case m if m.isLeaves           => Leaves.tupled(params[LeavesVariant])
      case m if m.isLog              => Log.tupled(params[LogVariant])
      case m if m.isMinecart         => Minecart.tupled(params[MinecartVariant])
      case m if m.isMobHead          => MobHead.tupled(params[MobHeadVariant])
      case m if m.isMushroom         => Mushroom.tupled(params[MushroomVariant])
      case m if m.isMusicDisc        => MusicDisc.tupled(params[MusicDiscVariant])
      case m if m.isPillar           => Pillar.tupled(params[PillarVariant])
      case m if m.isPlanks           => Planks.tupled(params[PlanksVariant])
      case m if m.isPlant            => Plant.tupled(params[PlantVariant])
      case m if m.isPrismarine       => Prismarine.tupled(params[PrismarineVariant])
      case m if m.isQuartzBlock      => QuartzBlock.tupled(params[QuartzBlockVariant])
      case m if m.isRail             => Rail.tupled(params[RailVariant])
      case m if m.isSand             => Sand.tupled(params[SandVariant])
      case m if m.isSandstone        => Sandstone.tupled(params[SandstoneVariant])
      case m if m.isSeeds            => Seeds.tupled(params[SeedsVariant])
      case m if m.isShulkerBox       => ShulkerBox.tupled(colorableParams)
      case m if m.isSlab             => Slab.tupled(params[SlabVariant])
      case m if m.isSpawnEgg         => SpawnEgg.tupled(params[SpawnEggVariant])
      case m if m.isStew             => Stew.tupled(params[StewVariant])
      case m if m.isStone            => Stone.tupled(params[StoneVariant])
      case m if m.isTerracotta       => Terracotta.tupled(colorableParams)
      case m if m.isWall             => Wall.tupled(params[WallVariant])
      case m if m.isWood             => Wood.tupled(params[WoodVariant])
      case m if m.isWool             => Wool.tupled(colorParams)

      // TODO
      // case m if m.isSapling          => Sapling.tupled(params[SaplingVariant])
      // case m if m.isStonite          => Stonite(loc, v[StoniteVariant])

      case m if m.isBannerPattern =>
        val _variant = variant.asInstanceOf[BannerPatternVariant]
        BannerPattern(_variant, name, tooltip, attr, hideAttr)

      case m if m.isInfestedBlock =>
        InfestedBlock.tupled(params[InfestedBlockVariant])

      case m if m.isMushroomBlock =>
        MushroomBlock.tupled(params[MushroomBlockVariant])

      case m if m.isPotion =>
        val _variant = variant.asInstanceOf[PotionVariant]
        val hideEffects = meta.hasItemFlag(ItemFlag.HIDE_POTION_EFFECTS)
        Potion(_variant, hideEffects, name, tooltip, attr, hideAttr)

      case m if m.isStructureBlock =>
        StructureBlock.tupled(params[StructureBlockVariant])

      /* TODO
     case r".*PICKAXE" =>
       case r".*AXE" =>
       case r".*BOOTS" =>
       case r".*CHESTPLATE" =>
       case r".*HELMET" =>
       case r".*HOE" =>
       case r".*LEGGINGS" =>
       case r".*SHOVEL" =>
       case r".*SWORD" =>
     */
    })
  }

  def map(item: Item): SpigotItemStack = {
    val spigotItem: SpigotItemStack = item match {
      case _ => null
    }

    // TODO map skull meta

    spigotItem
  }
}
