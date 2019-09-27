package gg.warcraft.monolith.spigot.world.block

import com.google.inject.Inject
import gg.warcraft.monolith.api.world.block._
import gg.warcraft.monolith.api.world.block.`type`._
import gg.warcraft.monolith.api.world.block.material._
import gg.warcraft.monolith.api.world.block.state._
import gg.warcraft.monolith.spigot.world.SpigotLocationMapper
import org.bukkit.{ Instrument, Material, Bukkit => Spigot }
import org.bukkit.block.{ Block => SpigotBlock, BlockState => SpigotBlockState, Sign => SpigotSign }
import org.bukkit.block.data.{ BlockData => SpigotBlockData, _ }
import org.bukkit.block.data.`type`.{ Bamboo => SpigotBamboo, Bed => SpigotBed, BubbleColumn => SpigotBubbleColumn, Campfire => SpigotCampfire, CommandBlock => SpigotCommandBlock, Door => SpigotDoor, EndPortalFrame => SpigotEndPortalFrame, Hopper => SpigotHopper, Jukebox => SpigotJukebox, Lantern => SpigotLantern, Lectern => SpigotLectern, NoteBlock => SpigotNoteBlock, Piston => SpigotPiston, Repeater => SpigotRepeater, TNT => SpigotTNT }

class SpigotBlockMapper @Inject()(
  private val locationMapper: SpigotLocationMapper,
  private val materialMapper: SpigotBlockMaterialMapper,
  private val attachmentMapper: SpigotBlockAttachmentMapper,
  private val bisectionMapper: SpigotBlockBisectionMapper,
  private val colorMapper: SpigotBlockColorMapper,
  private val extensionMapper: SpigotBlockExtensionMapper,
  private val faceMapper: SpigotBlockFaceMapper,
  private val orientationMapper: SpigotBlockOrientationMapper,
  private val rotationMapper: SpigotBlockRotationMapper,
  private val stateMapper: SpigotBlockStateMapper,
) {

  def map(block: SpigotBlock): Block = {
    val location = locationMapper.map(block.getLocation).toBlockLocation
    val spigotState = block.getState.getBlockData

    lazy val attached = attachmentMapper.map(block.getState.asInstanceOf[Attachable])
    lazy val bisection = bisectionMapper.map(block.getState.asInstanceOf[Bisected].getHalf)
    lazy val color = colorMapper.map(block.getType)
    lazy val extensions = extensionMapper.map(block.getState.asInstanceOf[MultipleFacing].getFaces)
    lazy val facing = faceMapper.map(block.getState.asInstanceOf[Directional].getFacing)
    lazy val flooded = block.getState.asInstanceOf[Waterlogged].isWaterlogged
    lazy val lit = block.getState.asInstanceOf[Lightable].isLit
    lazy val material = materialMapper.map(block.getType)
    lazy val open = block.getState.asInstanceOf[Openable].isOpen
    lazy val orientation = orientationMapper.map(block.getState.asInstanceOf[Orientable].getAxis)
    lazy val powered = block.getState.asInstanceOf[Powerable].isPowered
    lazy val rotation = rotationMapper.map(block.getState.asInstanceOf[Rotatable].getRotation)
    lazy val snowy = block.getState.asInstanceOf[Snowable].isSnowy
    lazy val state = stateMapper.map(block)

    block.getType match {
      case Material.AIR => Air(location, material.asInstanceOf[AirMaterial])
      case Material.BARREL => Barrel(location, facing, open)
      case Material.BARRIER => Barrier(location)
      case Material.BEACON => Beacon(location)
      case Material.BEDROCK => Bedrock(location)
      case Material.BEETROOTS => Beetroots(location, state.asInstanceOf[BeetrootState])
      case Material.BELL => Bell(location, facing)
      case Material.BLAST_FURNACE => BlastFurnace(location, facing, lit)
      case Material.BONE_BLOCK => BoneBlock(location, orientation)
      case Material.BOOKSHELF => Bookshelf(location)
      case Material.BREWING_STAND => BrewingStand(location)
      case Material.CACTUS => Cactus(location, state.asInstanceOf[CactusState])
      case Material.CAKE => Cake(location, state.asInstanceOf[CakeState])
      case Material.CARROTS => Carrots(location, state.asInstanceOf[CarrotState])
      case Material.CARTOGRAPHY_TABLE => CartographyTable(location)
      case Material.CAULDRON => Cauldron(location, state.asInstanceOf[CauldronState])
      case Material.CHORUS_FLOWER => ChorusFlower(location, state.asInstanceOf[ChorusFlowerState])
      case Material.CHORUS_PLANT => ChorusPlant(location, extensions)
      case Material.CLAY => Clay(location)
      case Material.COBWEB => Cobweb(location)
      case Material.COCOA => Cocoa(location, state.asInstanceOf[CocoaState], facing)
      case Material.COMPARATOR => Comparator(location, state.asInstanceOf[ComparatorState], facing, powered)
      case Material.COMPOSTER => Composter(location, state.asInstanceOf[ComposterState])
      case Material.CONDUIT => Conduit(location, flooded)
      case Material.CRAFTING_TABLE => CraftingTable(location)
      case Material.DAYLIGHT_DETECTOR => DaylightDetector(location)
      case Material.DEAD_BUSH => DeadBush(location)
      case Material.DISPENSER => Dispenser(location, facing, powered)
      case Material.DRAGON_EGG => DragonEgg(location)
      case Material.DRIED_KELP_BLOCK => DriedKelp(location)
      case Material.DROPPER => Dropper(location, facing, powered)
      case Material.ENCHANTING_TABLE => EnchantingTable(location)
      case Material.END_GATEWAY => EndGateway(location)
      case Material.END_PORTAL => EndPortal(location)
      case Material.END_ROD => EndRod(location, facing)
      case Material.FARMLAND => Farmland(location)
      case Material.FERN => Fern(location, BlockBisection.BOTTOM, tall = false)
      case Material.LARGE_FERN => Fern(location, bisection, tall = true)
      case Material.FIRE => Fire(location)
      case Material.FLETCHING_TABLE => FletchingTable(location)
      case Material.FROSTED_ICE => Frost(location)
      case Material.FURNACE => Furnace(location, facing, lit)
      case Material.GLOWSTONE => Glowstone(location)
      case Material.GRASS_BLOCK => GrassBlock(location, snowy)
      case Material.GRASS_PATH => GrassPath(location)
      case Material.GRAVEL => Gravel(location)
      case Material.GRINDSTONE => Grindstone(location, facing, attached)
      case Material.HAY_BLOCK => HayBale(location, orientation)
      case Material.IRON_BARS => IronBars(location, extensions, flooded)
      case Material.JIGSAW => Jigsaw(location, facing)
      case Material.KELP_PLANT => Kelp(location, state.asInstanceOf[KelpState])
      case Material.LADDER => Ladder(location, facing, flooded)
      case Material.LAVA => Lava(location, state.asInstanceOf[LavaState])
      case Material.LEVER => Lever(location, facing, attached, powered)
      case Material.LILY_PAD => LilyPad(location)
      case Material.LOOM => Loom(location, facing)
      case Material.MAGMA_BLOCK => Magma(location)
      case Material.MELON => Melon(location)
      case Material.MYCELIUM => Mycelium(location, snowy)
      case Material.NETHERRACK => Netherrack(location)
      case Material.NETHER_PORTAL => NetherPortal(location, orientation)
      case Material.NETHER_WART => NetherWarts(location, state.asInstanceOf[NetherWartState])
      case Material.NETHER_WART_BLOCK => NetherWartBlock(location)
      case Material.OBSERVER => Observer(location, facing, powered)
      case Material.OBSIDIAN => Obsidian(location)
      case Material.PODZOL => Podzol(location, snowy)
      case Material.POTATOES => Potatoes(location, state.asInstanceOf[PotatoState])
      case Material.PUMPKIN => Pumpkin(location, None, lit = false, carved = false)
      case Material.CARVED_PUMPKIN => Pumpkin(location, Some(facing), lit = false, carved = true)
      case Material.JACK_O_LANTERN => Pumpkin(location, Some(facing), lit = true, carved = true)
      case Material.REDSTONE_LAMP => RedstoneLamp(location, lit)
      case Material.REDSTONE_TORCH => RedstoneTorch(location, None, lit)
      case Material.REDSTONE_WALL_TORCH => RedstoneTorch(location, Some(facing), lit)
      case Material.REDSTONE_WIRE => RedstoneWire(location, state.asInstanceOf[RedstoneWireState])
      case Material.SCAFFOLDING => Scaffold(location)
      case Material.SEA_LANTERN => SeaLantern(location)
      case Material.SEA_PICKLE => SeaPickle(location, state.asInstanceOf[SeaPickleState], flooded)
      case Material.SLIME_BLOCK => SlimeBlock(location)
      case Material.SMITHING_TABLE => SmithingTable(location)
      case Material.SMOKER => Smoker(location, facing, lit)
      case Material.SNOW => Snow(location)
      case Material.SNOW_BLOCK => SnowBlock(location)
      case Material.SPAWNER => Spawner(location)
      case Material.STONECUTTER => StoneCutter(location, facing)
      case Material.STRUCTURE_BLOCK => StructureBlock(location, state.asInstanceOf[StructureBlockState])
      case Material.SUGAR_CANE => SugarCane(location, state.asInstanceOf[SugarCaneState])
      case Material.SWEET_BERRY_BUSH => SweetBerryBush(location, state.asInstanceOf[SweetBerryState])
      case Material.TURTLE_EGG => TurtleEgg(location, state.asInstanceOf[TurtleEggState])
      case Material.VINE => Vine(location, extensions)
      case Material.WATER => Water(location, state.asInstanceOf[WaterState])
      case Material.WHEAT => Wheat(location, state.asInstanceOf[WheatState])

      // ANVIL
      case Material.ANVIL | Material.CHIPPED_ANVIL | Material.DAMAGED_ANVIL =>
        Anvil(location, state.asInstanceOf[AnvilState], facing)

      // BAMBOO
      case Material.BAMBOO =>
        val bamboo = spigotState.asInstanceOf[SpigotBamboo]
        val leaves = mapBambooLeaves(bamboo.getLeaves)
        val thick = bamboo.getAge == 1
        Bamboo(location, leaves, state.asInstanceOf[BambooState], thick) // TODO is the state and age the same?

      // BANNER
      case Material.BLACK_BANNER | Material.BLUE_BANNER | Material.BROWN_BANNER | Material.CYAN_BANNER |
           Material.GRAY_BANNER | Material.GREEN_BANNER | Material.LIGHT_BLUE_BANNER | Material.LIGHT_GRAY_BANNER |
           Material.LIME_BANNER | Material.MAGENTA_BANNER | Material.ORANGE_BANNER | Material.PINK_BANNER |
           Material.PURPLE_BANNER | Material.RED_BANNER | Material.WHITE_BANNER | Material.YELLOW_BANNER =>
        Banner(location, color, Some(rotation), None)

      case Material.BLACK_WALL_BANNER | Material.BLUE_WALL_BANNER | Material.BROWN_WALL_BANNER |
           Material.CYAN_WALL_BANNER | Material.GRAY_WALL_BANNER | Material.GREEN_WALL_BANNER |
           Material.LIGHT_BLUE_WALL_BANNER | Material.LIGHT_GRAY_WALL_BANNER | Material.LIME_WALL_BANNER |
           Material.MAGENTA_WALL_BANNER | Material.ORANGE_WALL_BANNER | Material.PINK_WALL_BANNER |
           Material.PURPLE_WALL_BANNER | Material.RED_WALL_BANNER | Material.WHITE_WALL_BANNER |
           Material.YELLOW_WALL_BANNER =>
        Banner(location, color, None, Some(facing))

      // BED
      case Material.BLACK_BED | Material.BLUE_BED | Material.BROWN_BED | Material.CYAN_BED |
           Material.GRAY_BED | Material.GREEN_BED | Material.LIGHT_BLUE_BED | Material.LIGHT_GRAY_BED |
           Material.LIME_BED | Material.MAGENTA_BED | Material.ORANGE_BED | Material.PINK_BED |
           Material.PURPLE_BED | Material.RED_BED | Material.WHITE_BED | Material.YELLOW_BED =>
        val occupied = spigotState.asInstanceOf[SpigotBed].isOccupied
        Bed(location, color, facing, bisection, occupied)

      // BUBBLE_COLUMN
      case Material.BUBBLE_COLUMN =>
        val drag = spigotState.asInstanceOf[SpigotBubbleColumn].isDrag
        BubbleColumn(location, drag)

      // BUTTON
      case Material.STONE_BUTTON |
           Material.ACACIA_BUTTON | Material.BIRCH_BUTTON | Material.DARK_OAK_BUTTON |
           Material.JUNGLE_BUTTON | Material.OAK_BUTTON | Material.SPRUCE_BUTTON =>
        Button(location, material.asInstanceOf[ButtonMaterial], facing, attached, powered)

      // CAMPFIRE
      case Material.CAMPFIRE =>
        val signal = spigotState.asInstanceOf[SpigotCampfire].isSignalFire
        Campfire(location, facing, flooded, lit, signal)

      // CARPET
      case Material.BLACK_CARPET | Material.BLUE_CARPET | Material.BROWN_CARPET | Material.CYAN_CARPET |
           Material.GRAY_CARPET | Material.GREEN_CARPET | Material.LIGHT_BLUE_CARPET | Material.LIGHT_GRAY_CARPET |
           Material.LIME_CARPET | Material.MAGENTA_CARPET | Material.ORANGE_CARPET | Material.PINK_CARPET |
           Material.PURPLE_CARPET | Material.RED_CARPET | Material.WHITE_CARPET | Material.YELLOW_CARPET =>
        Carpet(location, color)

      // CHEST
      case Material.CHEST | Material.ENDER_CHEST | Material.TRAPPED_CHEST =>
        Chest(location, material.asInstanceOf[ChestMaterial], facing)

      // COMMAND_BLOCK
      case Material.COMMAND_BLOCK | Material.CHAIN_COMMAND_BLOCK | Material.REPEATING_COMMAND_BLOCK =>
        val conditional = spigotState.asInstanceOf[SpigotCommandBlock].isConditional
        CommandBlock(location, material.asInstanceOf[CommandBlockMaterial], facing, conditional)

      // CONCRETE
      case Material.BLACK_CONCRETE | Material.BLUE_CONCRETE | Material.BROWN_CONCRETE | Material.CYAN_CONCRETE |
           Material.GRAY_CONCRETE | Material.GREEN_CONCRETE | Material.LIGHT_BLUE_CONCRETE | Material.LIGHT_GRAY_CONCRETE |
           Material.LIME_CONCRETE | Material.MAGENTA_CONCRETE | Material.ORANGE_CONCRETE | Material.PINK_CONCRETE |
           Material.PURPLE_CONCRETE | Material.RED_CONCRETE | Material.WHITE_CONCRETE | Material.YELLOW_CONCRETE =>
        Concrete(location, color)

      case Material.BLACK_CONCRETE_POWDER | Material.BLUE_CONCRETE_POWDER | Material.BROWN_CONCRETE_POWDER |
           Material.CYAN_CONCRETE_POWDER | Material.GRAY_CONCRETE_POWDER | Material.GREEN_CONCRETE_POWDER |
           Material.LIGHT_BLUE_CONCRETE_POWDER | Material.LIGHT_GRAY_CONCRETE_POWDER | Material.LIME_CONCRETE_POWDER |
           Material.MAGENTA_CONCRETE_POWDER | Material.ORANGE_CONCRETE_POWDER | Material.PINK_CONCRETE_POWDER |
           Material.PURPLE_CONCRETE_POWDER | Material.RED_CONCRETE_POWDER | Material.WHITE_CONCRETE_POWDER |
           Material.YELLOW_CONCRETE_POWDER =>
        ConcretePowder(location, color)

      // CORAL
      case Material.BRAIN_CORAL | Material.DEAD_BRAIN_CORAL |
           Material.BUBBLE_CORAL | Material.DEAD_BUBBLE_CORAL |
           Material.FIRE_CORAL | Material.DEAD_FIRE_CORAL |
           Material.HORN_CORAL | Material.DEAD_HORN_CORAL |
           Material.TUBE_CORAL | Material.DEAD_TUBE_CORAL =>
        Coral(location, material.asInstanceOf[CoralMaterial], flooded)

      case Material.BRAIN_CORAL_BLOCK | Material.DEAD_BRAIN_CORAL_BLOCK |
           Material.BUBBLE_CORAL_BLOCK | Material.DEAD_BUBBLE_CORAL_BLOCK |
           Material.FIRE_CORAL_BLOCK | Material.DEAD_FIRE_CORAL_BLOCK |
           Material.HORN_CORAL_BLOCK | Material.DEAD_HORN_CORAL_BLOCK |
           Material.TUBE_CORAL_BLOCK | Material.DEAD_TUBE_CORAL_BLOCK =>
        CoralBlock(location, material.asInstanceOf[CoralMaterial])

      case Material.BRAIN_CORAL_FAN | Material.DEAD_BRAIN_CORAL_FAN |
           Material.BUBBLE_CORAL_FAN | Material.DEAD_BUBBLE_CORAL_FAN |
           Material.FIRE_CORAL_FAN | Material.DEAD_FIRE_CORAL_FAN |
           Material.HORN_CORAL_FAN | Material.DEAD_HORN_CORAL_FAN |
           Material.TUBE_CORAL_FAN | Material.DEAD_TUBE_CORAL_FAN =>
        CoralFan(location, material.asInstanceOf[CoralMaterial], None, flooded)

      case Material.BRAIN_CORAL_WALL_FAN | Material.DEAD_BRAIN_CORAL_WALL_FAN |
           Material.BUBBLE_CORAL_WALL_FAN | Material.DEAD_BUBBLE_CORAL_WALL_FAN |
           Material.FIRE_CORAL_WALL_FAN | Material.DEAD_FIRE_CORAL_WALL_FAN |
           Material.HORN_CORAL_WALL_FAN | Material.DEAD_HORN_CORAL_WALL_FAN |
           Material.TUBE_CORAL_WALL_FAN | Material.DEAD_TUBE_CORAL_WALL_FAN =>
        CoralFan(location, material.asInstanceOf[CoralMaterial], Some(facing), flooded)

      // DIRT
      case Material.DIRT => Dirt(location, coarse = false)
      case Material.COARSE_DIRT => Dirt(location, coarse = true)

      // DOOR
      case Material.IRON_DOOR |
           Material.ACACIA_DOOR | Material.BIRCH_DOOR | Material.DARK_OAK_DOOR |
           Material.JUNGLE_DOOR | Material.OAK_DOOR | Material.SPRUCE_DOOR =>
        val hinge = mapDoorHinge(spigotState.asInstanceOf[SpigotDoor].getHinge)
        Door(location, material.asInstanceOf[DoorMaterial], facing, hinge, bisection, open, powered)

      // END_PORTAL_FRAME
      case Material.END_PORTAL_FRAME =>
        val eye = spigotState.asInstanceOf[SpigotEndPortalFrame].hasEye
        EndPortalFrame(location, facing, eye)

      // FENCE
      case Material.NETHER_BRICK_FENCE |
           Material.ACACIA_FENCE | Material.BIRCH_FENCE | Material.DARK_OAK_FENCE |
           Material.JUNGLE_FENCE | Material.OAK_FENCE | Material.SPRUCE_FENCE =>
        Fence(location, material.asInstanceOf[FenceMaterial], extensions, flooded)

      // FLOWER
      case Material.ALLIUM | Material.AZURE_BLUET | Material.BLUE_ORCHID | Material.CORNFLOWER |
           Material.DANDELION | Material.LILY_OF_THE_VALLEY | Material.ORANGE_TULIP |
           Material.OXEYE_DAISY | Material.PINK_TULIP | Material.POPPY | Material.RED_TULIP |
           Material.WHITE_TULIP | Material.WITHER_ROSE =>
        Flower(location, material.asInstanceOf[FlowerMaterial], BlockBisection.BOTTOM, tall = false)

      case Material.LILAC | Material.PEONY | Material.ROSE_BUSH | Material.SUNFLOWER =>
        Flower(location, material.asInstanceOf[FlowerMaterial], bisection, tall = true)

      // FLOWER_POT
      case Material.FLOWER_POT => FlowerPot(location, null, state.asInstanceOf[FlowerPotState])

      case Material.POTTED_ALLIUM | Material.POTTED_AZURE_BLUET | Material.POTTED_BLUE_ORCHID |
           Material.POTTED_CORNFLOWER | Material.POTTED_DANDELION | Material.POTTED_LILY_OF_THE_VALLEY |
           Material.POTTED_ORANGE_TULIP | Material.POTTED_OXEYE_DAISY | Material.POTTED_PINK_TULIP |
           Material.POTTED_POPPY | Material.POTTED_RED_TULIP | Material.POTTED_WHITE_TULIP |
           Material.POTTED_WITHER_ROSE |

           Material.POTTED_BAMBOO | Material.POTTED_BROWN_MUSHROOM | Material.POTTED_CACTUS |
           Material.POTTED_DEAD_BUSH | Material.POTTED_FERN | Material.POTTED_RED_MUSHROOM |

           Material.POTTED_ACACIA_SAPLING | Material.POTTED_BIRCH_SAPLING | Material.POTTED_DARK_OAK_SAPLING |
           Material.POTTED_JUNGLE_SAPLING | Material.POTTED_OAK_SAPLING | Material.POTTED_SPRUCE_SAPLING =>
        FlowerPot(location, material.asInstanceOf[FlowerPotMaterial], state.asInstanceOf[FlowerPotState])

      // GATE TODO add whether attached to wall or not
      case Material.ACACIA_FENCE_GATE | Material.BIRCH_FENCE_GATE | Material.DARK_OAK_FENCE_GATE |
           Material.JUNGLE_FENCE_GATE | Material.OAK_FENCE_GATE | Material.SPRUCE_FENCE_GATE =>
        Gate(location, material.asInstanceOf[WoodMaterial], facing, open, powered, wall = false)

      // GLASS
      case Material.GLASS |
           Material.BLACK_STAINED_GLASS | Material.BLUE_STAINED_GLASS | Material.BROWN_STAINED_GLASS | Material.CYAN_STAINED_GLASS |
           Material.GRAY_STAINED_GLASS | Material.GREEN_STAINED_GLASS | Material.LIGHT_BLUE_STAINED_GLASS | Material.LIGHT_GRAY_STAINED_GLASS |
           Material.LIME_STAINED_GLASS | Material.MAGENTA_STAINED_GLASS | Material.ORANGE_STAINED_GLASS | Material.PINK_STAINED_GLASS |
           Material.PURPLE_STAINED_GLASS | Material.RED_STAINED_GLASS | Material.WHITE_STAINED_GLASS | Material.YELLOW_STAINED_GLASS =>
        Glass(location, Some(color))

      case Material.GLASS_PANE |
           Material.BLACK_STAINED_GLASS_PANE | Material.BLUE_STAINED_GLASS_PANE | Material.BROWN_STAINED_GLASS_PANE | Material.CYAN_STAINED_GLASS_PANE |
           Material.GRAY_STAINED_GLASS_PANE | Material.GREEN_STAINED_GLASS_PANE | Material.LIGHT_BLUE_STAINED_GLASS_PANE | Material.LIGHT_GRAY_STAINED_GLASS_PANE |
           Material.LIME_STAINED_GLASS_PANE | Material.MAGENTA_STAINED_GLASS_PANE | Material.ORANGE_STAINED_GLASS_PANE | Material.PINK_STAINED_GLASS_PANE |
           Material.PURPLE_STAINED_GLASS_PANE | Material.RED_STAINED_GLASS_PANE | Material.WHITE_STAINED_GLASS_PANE | Material.YELLOW_STAINED_GLASS_PANE =>
        GlassPane(location, Some(color), extensions, flooded)

      // GRASS
      case Material.GRASS => Grass(location, BlockBisection.BOTTOM, tall = false)
      case Material.TALL_GRASS => Grass(location, bisection, tall = true)

      // HOPPER
      case Material.HOPPER =>
        val enabled = spigotState.asInstanceOf[SpigotHopper].isEnabled
        Hopper(location, facing, !enabled)

      // ICE
      case Material.ICE | Material.BLUE_ICE | Material.PACKED_ICE =>
        Ice(location, material.asInstanceOf[IceMaterial])

      // INFESTED_STONE
      case Material.INFESTED_STONE | Material.INFESTED_COBBLESTONE |
           Material.INFESTED_STONE_BRICKS | Material.INFESTED_CRACKED_STONE_BRICKS |
           Material.INFESTED_CHISELED_STONE_BRICKS | Material.INFESTED_MOSSY_STONE_BRICKS =>
        InfestedBlock(location, material.asInstanceOf[InfestedMaterial])

      // JUKEBOX
      case Material.JUKEBOX =>
        val record = spigotState.asInstanceOf[SpigotJukebox].hasRecord
        Jukebox(location, record)

      // LANTERN
      case Material.LANTERN =>
        val hanging = spigotState.asInstanceOf[SpigotLantern].isHanging
        Lantern(location, hanging)

      // LEAVES
      case Material.ACACIA_LEAVES | Material.BIRCH_LEAVES | Material.DARK_OAK_LEAVES |
           Material.JUNGLE_LEAVES | Material.OAK_LEAVES | Material.SPRUCE_LEAVES =>
        Leaves(location, material.asInstanceOf[WoodMaterial])

      // LECTERN
      case Material.LECTERN =>
        val book = spigotState.asInstanceOf[SpigotLectern].hasBook
        Lectern(location, facing, powered, book)

      // LOG
      case Material.ACACIA_LOG | Material.BIRCH_LOG | Material.DARK_OAK_LOG |
           Material.JUNGLE_LOG | Material.OAK_LOG | Material.SPRUCE_LOG =>
        Log(location, material.asInstanceOf[WoodMaterial], orientation, stripped = false)

      case Material.STRIPPED_ACACIA_LOG | Material.STRIPPED_BIRCH_LOG | Material.STRIPPED_DARK_OAK_LOG |
           Material.STRIPPED_JUNGLE_LOG | Material.STRIPPED_OAK_LOG | Material.STRIPPED_SPRUCE_LOG =>
        Log(location, material.asInstanceOf[WoodMaterial], orientation, stripped = true)

      // MELON_STEM
      case Material.MELON_STEM => MelonStem(location, state.asInstanceOf[MelonStemState], None)
      case Material.ATTACHED_MELON_STEM => MelonStem(location, state.asInstanceOf[MelonStemState], Some(facing))

      // MINERAL
      case Material.COAL_BLOCK | Material.DIAMOND_BLOCK | Material.EMERALD_BLOCK | Material.GOLD_BLOCK |
           Material.IRON_BLOCK | Material.LAPIS_BLOCK | Material.QUARTZ_BLOCK | Material.REDSTONE_BLOCK =>
        Mineral(location, material.asInstanceOf[MineralMaterial])

      // MOB_HEAD
      case Material.CREEPER_HEAD |
           Material.DRAGON_HEAD |
           Material.PLAYER_HEAD |
           Material.SKELETON_SKULL |
           Material.WITHER_SKELETON_SKULL |
           Material.ZOMBIE_HEAD =>
        MobHead(location, material.asInstanceOf[MobHeadMaterial], None, Some(rotation))

      case Material.CREEPER_WALL_HEAD |
           Material.DRAGON_WALL_HEAD |
           Material.PLAYER_WALL_HEAD |
           Material.SKELETON_WALL_SKULL |
           Material.WITHER_SKELETON_WALL_SKULL |
           Material.ZOMBIE_WALL_HEAD =>
        MobHead(location, material.asInstanceOf[MobHeadMaterial], Some(facing), None)

      // MUSHROOM
      case Material.BROWN_MUSHROOM | Material.RED_MUSHROOM =>
        Mushroom(location, material.asInstanceOf[MushroomMaterial])

      case Material.BROWN_MUSHROOM_BLOCK | Material.RED_MUSHROOM_BLOCK | Material.MUSHROOM_STEM =>
        MushroomBlock(location, material.asInstanceOf[MushroomBlockMaterial])

      // NOTE_BLOCK
      case Material.NOTE_BLOCK =>
        val instrument = spigotState.asInstanceOf[SpigotNoteBlock].getInstrument
        NoteBlock(location, mapInstrument(instrument), state.asInstanceOf[NoteBlockState], powered)

      // ORE
      case Material.COAL_ORE | Material.DIAMOND_ORE | Material.EMERALD_ORE | Material.GOLD_ORE |
           Material.IRON_ORE | Material.LAPIS_ORE | Material.NETHER_QUARTZ_ORE | Material.REDSTONE_ORE =>
        Ore(location, material.asInstanceOf[OreMaterial])

      // PILLAR
      case Material.PURPUR_PILLAR | Material.QUARTZ_PILLAR =>
        Pillar(location, material.asInstanceOf[PillarMaterial])

      // PISTON
      case Material.PISTON =>
        val extended = spigotState.asInstanceOf[SpigotPiston].isExtended
        Piston(location, facing, sticky = false, extended)

      case Material.STICKY_PISTON =>
        val extended = spigotState.asInstanceOf[SpigotPiston].isExtended
        Piston(location, facing, sticky = true, extended)

      case Material.MOVING_PISTON | Material.PISTON_HEAD =>
        throw new IllegalArgumentException("Technical block")

      // PLANKS
      case Material.ACACIA_PLANKS | Material.BIRCH_PLANKS | Material.DARK_OAK_PLANKS |
           Material.JUNGLE_PLANKS | Material.OAK_PLANKS | Material.SPRUCE_PLANKS =>
        Planks(location, material.asInstanceOf[WoodMaterial])

      // PRESSURE_PLATE
      case Material.STONE_PRESSURE_PLATE |
           Material.ACACIA_PRESSURE_PLATE | Material.BIRCH_PRESSURE_PLATE | Material.DARK_OAK_PRESSURE_PLATE |
           Material.JUNGLE_PRESSURE_PLATE | Material.OAK_PRESSURE_PLATE | Material.SPRUCE_PRESSURE_PLATE =>
        PressurePlate(location, material.asInstanceOf[PressurePlateMaterial], powered)

      case Material.LIGHT_WEIGHTED_PRESSURE_PLATE | Material.HEAVY_WEIGHTED_PRESSURE_PLATE =>
        WeightedPressurePlate(location, material.asInstanceOf[WeightedPressurePlateMaterial],
          state.asInstanceOf[WeightedPressurePlateState])

      // PUMPKIN_STEM
      case Material.PUMPKIN_STEM => PumpkinStem(location, state.asInstanceOf[PumpkinStemState], None)
      case Material.ATTACHED_PUMPKIN_STEM => PumpkinStem(location, state.asInstanceOf[PumpkinStemState], Some(facing))

      // RAIL
      case Material.RAIL | Material.ACTIVATOR_RAIL | Material.DETECTOR_RAIL | Material.POWERED_RAIL =>
        Rails(location, material.asInstanceOf[RailsMaterial], state.asInstanceOf[RailsState], powered)

      // REPEATER
      case Material.REPEATER =>
        val locked = spigotState.asInstanceOf[SpigotRepeater].isLocked
        Repeater(location, state.asInstanceOf[RepeaterState], facing, powered, locked)

      // SAND
      case Material.SAND | Material.RED_SAND | Material.SOUL_SAND =>
        Sand(location, material.asInstanceOf[SandMaterial])

      // SANDSTONE
      case Material.SANDSTONE | Material.RED_SANDSTONE |
           Material.CHISELED_SANDSTONE | Material.CHISELED_RED_SANDSTONE |
           Material.CUT_SANDSTONE | Material.CUT_RED_SANDSTONE |
           Material.SMOOTH_SANDSTONE | Material.SMOOTH_RED_SANDSTONE =>
        Sandstone(location, material.asInstanceOf[SandstoneMaterial], state.asInstanceOf[SandstoneState])

      // SAPLING
      case Material.BAMBOO_SAPLING |
           Material.ACACIA_SAPLING | Material.BIRCH_SAPLING | Material.DARK_OAK_SAPLING |
           Material.JUNGLE_SAPLING | Material.OAK_SAPLING | Material.SPRUCE_SAPLING =>
        Sapling(location, material.asInstanceOf[SaplingMaterial], state.asInstanceOf[SaplingState])

      // SEAGRASS
      case Material.SEAGRASS => Seagrass(location, BlockBisection.BOTTOM, tall = false)
      case Material.TALL_SEAGRASS => Seagrass(location, bisection, tall = true)

      // SHULKER_BOX
      case Material.SHULKER_BOX |
           Material.BLACK_SHULKER_BOX | Material.BLUE_SHULKER_BOX | Material.BROWN_SHULKER_BOX | Material.CYAN_SHULKER_BOX |
           Material.GRAY_SHULKER_BOX | Material.GREEN_SHULKER_BOX | Material.LIGHT_BLUE_SHULKER_BOX | Material.LIGHT_GRAY_SHULKER_BOX |
           Material.LIME_SHULKER_BOX | Material.MAGENTA_SHULKER_BOX | Material.ORANGE_SHULKER_BOX | Material.PINK_SHULKER_BOX |
           Material.PURPLE_SHULKER_BOX | Material.RED_SHULKER_BOX | Material.WHITE_SHULKER_BOX | Material.YELLOW_SHULKER_BOX =>
        ShulkerBox(location, Some(color))

      // SIGN
      case Material.ACACIA_SIGN | Material.BIRCH_SIGN | Material.DARK_OAK_SIGN |
           Material.JUNGLE_SIGN | Material.OAK_SIGN | Material.SPRUCE_SIGN =>
        val lines = spigotState.asInstanceOf[SpigotSign].getLines.toList // TODO keep as array? seem to be immutable
        Sign(lines, location, material.asInstanceOf[WoodMaterial], Some(facing), None, flooded)

      case Material.ACACIA_WALL_SIGN | Material.BIRCH_WALL_SIGN | Material.DARK_OAK_WALL_SIGN |
           Material.JUNGLE_WALL_SIGN | Material.OAK_WALL_SIGN | Material.SPRUCE_WALL_SIGN =>
        val lines = spigotState.asInstanceOf[SpigotSign].getLines.toList
        Sign(lines, location, material.asInstanceOf[WoodMaterial], None, Some(rotation), flooded)

      // SLAB
      case Material.BRICK_SLAB | Material.NETHER_BRICK_SLAB | Material.RED_NETHER_BRICK_SLAB |

           Material.SANDSTONE_SLAB | Material.CUT_SANDSTONE_SLAB | Material.SMOOTH_SANDSTONE_SLAB |
           Material.RED_SANDSTONE_SLAB | Material.CUT_RED_SANDSTONE_SLAB | Material.SMOOTH_RED_SANDSTONE_SLAB |

           Material.STONE_SLAB | Material.SMOOTH_STONE_SLAB |
           Material.STONE_BRICK_SLAB | Material.MOSSY_STONE_BRICK_SLAB |
           Material.COBBLESTONE_SLAB | Material.MOSSY_COBBLESTONE_SLAB |

           Material.ANDESITE_SLAB | Material.DIORITE_SLAB | Material.GRANITE_SLAB |
           Material.POLISHED_ANDESITE_SLAB | Material.POLISHED_DIORITE_SLAB | Material.POLISHED_GRANITE_SLAB |

           Material.END_STONE_BRICK_SLAB |
           Material.PRISMARINE_SLAB | Material.PRISMARINE_BRICK_SLAB | Material.DARK_PRISMARINE_SLAB |
           Material.PURPUR_SLAB |
           Material.QUARTZ_SLAB | Material.SMOOTH_QUARTZ_SLAB |

           Material.ACACIA_SLAB | Material.BIRCH_SLAB | Material.DARK_OAK_SLAB |
           Material.JUNGLE_SLAB | Material.OAK_SLAB | Material.SPRUCE_SLAB | Material.PETRIFIED_OAK_SLAB =>
        Slab(location, material.asInstanceOf[SlabMaterial], bisection)

      // SPONGE
      case Material.SPONGE => Sponge(location, wet = false)
      case Material.WET_SPONGE => Sponge(location, wet = true)

      // STAIRS
      case Material.BRICK_STAIRS | Material.NETHER_BRICK_STAIRS | Material.RED_NETHER_BRICK_STAIRS |

           Material.SANDSTONE_STAIRS | Material.SMOOTH_SANDSTONE_STAIRS |
           Material.RED_SANDSTONE_STAIRS | Material.SMOOTH_RED_SANDSTONE_STAIRS |

           Material.STONE_STAIRS |
           Material.STONE_BRICK_STAIRS | Material.MOSSY_STONE_BRICK_STAIRS |
           Material.COBBLESTONE_STAIRS | Material.MOSSY_COBBLESTONE_STAIRS |

           Material.ANDESITE_STAIRS | Material.DIORITE_STAIRS | Material.GRANITE_STAIRS |
           Material.POLISHED_ANDESITE_STAIRS | Material.POLISHED_DIORITE_STAIRS | Material.POLISHED_GRANITE_STAIRS |

           Material.END_STONE_BRICK_STAIRS |
           Material.PRISMARINE_STAIRS | Material.PRISMARINE_BRICK_STAIRS | Material.DARK_PRISMARINE_STAIRS |
           Material.PURPUR_STAIRS |
           Material.QUARTZ_STAIRS | Material.SMOOTH_QUARTZ_STAIRS |

           Material.ACACIA_STAIRS | Material.BIRCH_STAIRS | Material.DARK_OAK_STAIRS |
           Material.JUNGLE_STAIRS | Material.OAK_STAIRS | Material.SPRUCE_STAIRS =>
        Stairs(location, material.asInstanceOf[StairsMaterial], state.asInstanceOf[StairsState], facing, bisection, flooded)

      // STONE
      case Material.BRICK | Material.NETHER_BRICK | Material.RED_NETHER_BRICKS |

           Material.STONE | Material.SMOOTH_STONE | Material.CHISELED_STONE_BRICKS |
           Material.STONE_BRICKS | Material.MOSSY_STONE_BRICKS | Material.CRACKED_STONE_BRICKS |
           Material.COBBLESTONE | Material.MOSSY_COBBLESTONE |

           Material.ANDESITE | Material.DIORITE | Material.GRANITE |
           Material.POLISHED_ANDESITE | Material.POLISHED_DIORITE | Material.POLISHED_GRANITE |

           Material.END_STONE | Material.END_STONE_BRICKS |
           Material.PRISMARINE | Material.PRISMARINE_BRICKS | Material.DARK_PRISMARINE |
           Material.PURPUR_BLOCK |
           Material.QUARTZ | Material.SMOOTH_QUARTZ | Material.CHISELED_QUARTZ_BLOCK =>
        Stone(location, material.asInstanceOf[StoneMaterial])

      // TERRACOTTA
      case Material.TERRACOTTA |
           Material.BLACK_TERRACOTTA | Material.BLUE_TERRACOTTA | Material.BROWN_TERRACOTTA | Material.CYAN_TERRACOTTA |
           Material.GRAY_TERRACOTTA | Material.GREEN_TERRACOTTA | Material.LIGHT_BLUE_TERRACOTTA | Material.LIGHT_GRAY_TERRACOTTA |
           Material.LIME_TERRACOTTA | Material.MAGENTA_TERRACOTTA | Material.ORANGE_TERRACOTTA | Material.PINK_TERRACOTTA |
           Material.PURPLE_TERRACOTTA | Material.RED_TERRACOTTA | Material.WHITE_TERRACOTTA | Material.YELLOW_TERRACOTTA =>
        Terracotta(location, Some(color))

      case Material.BLACK_GLAZED_TERRACOTTA | Material.BLUE_GLAZED_TERRACOTTA | Material.BROWN_GLAZED_TERRACOTTA | Material.CYAN_GLAZED_TERRACOTTA |
           Material.GRAY_GLAZED_TERRACOTTA | Material.GREEN_GLAZED_TERRACOTTA | Material.LIGHT_BLUE_GLAZED_TERRACOTTA | Material.LIGHT_GRAY_GLAZED_TERRACOTTA |
           Material.LIME_GLAZED_TERRACOTTA | Material.MAGENTA_GLAZED_TERRACOTTA | Material.ORANGE_GLAZED_TERRACOTTA | Material.PINK_GLAZED_TERRACOTTA |
           Material.PURPLE_GLAZED_TERRACOTTA | Material.RED_GLAZED_TERRACOTTA | Material.WHITE_GLAZED_TERRACOTTA | Material.YELLOW_GLAZED_TERRACOTTA =>
        GlazedTerracotta(location, color)

      // TNT
      case Material.TNT =>
        val unstable = spigotState.asInstanceOf[SpigotTNT].isUnstable
        TNT(location, unstable)

      // TORCH
      case Material.TORCH => Torch(location, BlockFace.UP, wall = false)
      case Material.WALL_TORCH => Torch(location, facing, wall = true)

      // TRAPDOOR
      case Material.IRON_TRAPDOOR |
           Material.ACACIA_TRAPDOOR | Material.BIRCH_TRAPDOOR | Material.DARK_OAK_TRAPDOOR |
           Material.JUNGLE_TRAPDOOR | Material.OAK_TRAPDOOR | Material.SPRUCE_TRAPDOOR =>
        val trapdoorMaterial = material.asInstanceOf[TrapdoorMaterial]
        Trapdoor(location, trapdoorMaterial, facing, bisection, powered, flooded, open)

      // TRIPWIRE
      case Material.TRIPWIRE => throw new IllegalArgumentException(s"Failed to map block with type: ${ block.getType }")
      case Material.TRIPWIRE_HOOK => throw new IllegalArgumentException(s"Failed to map block with type: ${ block.getType }")

      // WALL
      case Material.BRICK_WALL | Material.NETHER_BRICK_WALL | Material.RED_NETHER_BRICK_WALL |

           Material.PRISMARINE_WALL |

           Material.SANDSTONE_WALL | Material.RED_SANDSTONE_WALL |

           Material.STONE_BRICK_WALL | Material.MOSSY_STONE_BRICK_WALL | Material.END_STONE_BRICK_WALL |
           Material.COBBLESTONE_WALL | Material.MOSSY_COBBLESTONE_WALL |
           Material.ANDESITE_WALL | Material.DIORITE_WALL | Material.GRANITE_WALL =>
        Wall(location, material.asInstanceOf[WallMaterial], extensions)

      // WOOD
      case Material.ACACIA_WOOD | Material.BIRCH_WOOD | Material.DARK_OAK_WOOD |
           Material.JUNGLE_WOOD | Material.OAK_WOOD | Material.SPRUCE_WOOD =>
        Wood(location, material.asInstanceOf[WoodMaterial], stripped = false)

      case Material.STRIPPED_ACACIA_WOOD | Material.STRIPPED_BIRCH_WOOD | Material.STRIPPED_DARK_OAK_WOOD |
           Material.STRIPPED_JUNGLE_WOOD | Material.STRIPPED_OAK_WOOD | Material.STRIPPED_SPRUCE_WOOD =>
        Wood(location, material.asInstanceOf[WoodMaterial], stripped = true)

      // WOOL
      case Material.BLACK_WOOL | Material.BLUE_WOOL | Material.BROWN_WOOL | Material.CYAN_WOOL |
           Material.GRAY_WOOL | Material.GREEN_WOOL | Material.LIGHT_BLUE_WOOL | Material.LIGHT_GRAY_WOOL |
           Material.LIME_WOOL | Material.MAGENTA_WOOL | Material.ORANGE_WOOL | Material.PINK_WOOL |
           Material.PURPLE_WOOL | Material.RED_WOOL | Material.WHITE_WOOL | Material.YELLOW_WOOL =>
        Wool(location, color)

      case _ => throw new IllegalArgumentException(s"Failed to map block with type: ${ block.getType }")
    }
  }

  def map(block: Block): SpigotBlockData = {
    // Create new block data object
    val material = materialMapper.map(block)
    val data: SpigotBlockData = Spigot.createBlockData(material)

    // Lazily compute generic block data
    lazy val extensions = extensionMapper.map(block.asInstanceOf[ExtendableBlock].extensions)
    lazy val flooded = block.asInstanceOf[FloodableBlock].flooded
    lazy val lit = block.asInstanceOf[LightableBlock].lit
    lazy val open = block.asInstanceOf[OpenableBlock].open
    lazy val powered = block.asInstanceOf[PowerableBlock].powered
    lazy val snowy = block.asInstanceOf[SnowableBlock].snowy

    lazy val attached = block match {
      case it: AttachedBlock => attachmentMapper.map(Some(it.attached))
      case it: AttachableBlock => attachmentMapper.map(it.attached)
    }

    lazy val bisection = {
      val bisection = block.asInstanceOf[BisectedBlock].section
      bisectionMapper.map(bisection)
    }

    lazy val facing = block match {
      case it: DirectionalBlock => faceMapper.map(it.facing)
      case it: DirectableBlock => faceMapper.map(it.facing.get)
    }

    lazy val orientation = {
      val orientation = block.asInstanceOf[OrientedBlock].orientation
      orientationMapper.map(orientation)
    }

    lazy val rotation = {
      val rotation = block.asInstanceOf[RotatableBlock].rotation.orNull
      rotationMapper.map(rotation)
    }

    // Set generic block data
    data match { case it: Attachable => it.setAttached(attached) }
    data match { case it: Bisected => it.setHalf(bisection) }
    data match { case it: Directional => it.setFacing(facing) }
    data match { case it: Lightable => it.setLit(lit) }
    data match { case it: Openable => it.setOpen(open) }
    data match { case it: Orientable => it.setAxis(orientation) }
    data match { case it: Powerable => it.setPowered(powered) }
    data match { case it: Rotatable => it.setRotation(rotation) }
    data match { case it: Snowable => it.setSnowy(snowy) }
    data match { case it: Waterlogged => it.setWaterlogged(flooded) }

    data match {
      case it: MultipleFacing =>
        it.getAllowedFaces.forEach(face => it.setFace(face, false)) // TODO check if this is necessary on fresh BlockData objects
        extensions.forEach(face => it.setFace(face, true))
    }

    // Set specific block data
    block match { case it: StatefulBlock[_] => stateMapper.map(it, data) }

    // Return block data object
    data
  }

  def map(block: Block, spigotState: SpigotBlockState): Unit = block match {
    case sign: Sign => spigotState match { // TODO map isEditable
      case state: SpigotSign => sign.lines.foreachindex((line, i) => state.setLine(i, line))
    }
  }

  def mapBambooLeaves(leaves: SpigotBamboo.Leaves): BambooLeavesMaterial = leaves match {
    case SpigotBamboo.Leaves.NONE => BambooLeavesMaterial.NONE
    case SpigotBamboo.Leaves.SMALL => BambooLeavesMaterial.SMALL
    case SpigotBamboo.Leaves.LARGE => BambooLeavesMaterial.LARGE
  }

  def mapBambooLeaves(leaves: BambooLeavesMaterial): SpigotBamboo.Leaves = leaves match {
    case BambooLeavesMaterial.NONE => SpigotBamboo.Leaves.NONE
    case BambooLeavesMaterial.SMALL => SpigotBamboo.Leaves.SMALL
    case BambooLeavesMaterial.LARGE => SpigotBamboo.Leaves.LARGE
  }

  def mapDoorHinge(hinge: SpigotDoor.Hinge): BlockHinge = hinge match {
    case SpigotDoor.Hinge.LEFT => BlockHinge.LEFT
    case SpigotDoor.Hinge.RIGHT => BlockHinge.RIGHT
  }

  def mapDoorHinge(hinge: BlockHinge): SpigotDoor.Hinge = hinge match {
    case BlockHinge.LEFT => SpigotDoor.Hinge.LEFT
    case BlockHinge.RIGHT => SpigotDoor.Hinge.RIGHT
  }

  def mapInstrument(instrument: Instrument): NoteBlockMaterial = instrument match {
    case Instrument.BANJO => NoteBlockMaterial.BANJO
    case Instrument.BASS_DRUM => NoteBlockMaterial.BASS_DRUM
    case Instrument.BASS_GUITAR => NoteBlockMaterial.BASS_GUITAR
    case Instrument.BELL => NoteBlockMaterial.BELL
    case Instrument.BIT => NoteBlockMaterial.BIT
    case Instrument.CHIME => NoteBlockMaterial.CHIME
    case Instrument.COW_BELL => NoteBlockMaterial.COW_BELL
    case Instrument.DIDGERIDOO => NoteBlockMaterial.DIDGERIDOO
    case Instrument.FLUTE => NoteBlockMaterial.FLUTE
    case Instrument.GUITAR => NoteBlockMaterial.GUITAR
    case Instrument.IRON_XYLOPHONE => NoteBlockMaterial.IRON_XYLOPHONE
    case Instrument.PIANO => NoteBlockMaterial.HAT
    case Instrument.PLING => NoteBlockMaterial.PLING
    case Instrument.SNARE_DRUM => NoteBlockMaterial.SNARE_DRUM
    case Instrument.STICKS => NoteBlockMaterial.HARP
    case Instrument.XYLOPHONE => NoteBlockMaterial.XYLOPHONE
  }

  def mapInstrument(instrument: NoteBlockMaterial): Instrument = instrument match {
    case NoteBlockMaterial.BANJO => Instrument.BANJO
    case NoteBlockMaterial.BASS_DRUM => Instrument.BASS_DRUM
    case NoteBlockMaterial.BASS_GUITAR => Instrument.BASS_GUITAR
    case NoteBlockMaterial.BELL => Instrument.BELL
    case NoteBlockMaterial.BIT => Instrument.BIT
    case NoteBlockMaterial.CHIME => Instrument.CHIME
    case NoteBlockMaterial.COW_BELL => Instrument.COW_BELL
    case NoteBlockMaterial.DIDGERIDOO => Instrument.DIDGERIDOO
    case NoteBlockMaterial.FLUTE => Instrument.FLUTE
    case NoteBlockMaterial.GUITAR => Instrument.GUITAR
    case NoteBlockMaterial.IRON_XYLOPHONE => Instrument.IRON_XYLOPHONE
    case NoteBlockMaterial.HAT => Instrument.PIANO
    case NoteBlockMaterial.PLING => Instrument.PLING
    case NoteBlockMaterial.SNARE_DRUM => Instrument.SNARE_DRUM
    case NoteBlockMaterial.HARP => Instrument.STICKS
    case NoteBlockMaterial.XYLOPHONE => Instrument.XYLOPHONE
  }
}
