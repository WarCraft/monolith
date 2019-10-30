package gg.warcraft.monolith.spigot.world.item

import gg.warcraft.monolith.api.world.block.BlockColor
import gg.warcraft.monolith.api.world.item._
import gg.warcraft.monolith.spigot.world.block.SpigotBlockColorMapper
import javax.inject.Inject
import org.bukkit.Material

class SpigotItemColorMapper @Inject()(
    blockMapper: SpigotBlockColorMapper
) {

  def map(material: Material): BlockColor =
    blockMapper.map(material)

  def map(item: ColoredItem): Material = item match {
    case Banner(color, _, _, _, _, _)           => blockMapper.mapBanner(color)
    case Bed(color, _, _, _, _, _)              => blockMapper.mapBed(color)
    case Carpet(color, _, _, _, _, _)           => blockMapper.mapCarpet(color)
    case Concrete(color, _, _, _, _, _)         => blockMapper.mapConcrete(color)
    case ConcretePowder(color, _, _, _, _, _)   => blockMapper.mapConcretePowder(color)
    case GlazedTerracotta(color, _, _, _, _, _) => blockMapper.mapGlazedTerracotta(color)
    case Wool(color, _, _, _, _, _)             => blockMapper.mapWool(color)

    case _ => throw new IllegalArgumentException(s"$item")
  }

  def map(item: ColorableItem): Material = item match {
    case Glass(None, _, _, _, _, _)        => Material.GLASS
    case Glass(Some(color), _, _, _, _, _) => blockMapper.mapStainedGlass(color)

    case GlassPane(None, _, _, _, _, _)        => Material.GLASS_PANE
    case GlassPane(Some(color), _, _, _, _, _) => blockMapper.mapStainedGlassPane(color)

    case ShulkerBox(None, _, _, _, _, _)        => Material.SHULKER_BOX
    case ShulkerBox(Some(color), _, _, _, _, _) => blockMapper.mapShulkerBox(color)

    case Terracotta(None, _, _, _, _, _)        => Material.TERRACOTTA
    case Terracotta(Some(color), _, _, _, _, _) => blockMapper.mapTerracotta(color)

    case _ => throw new IllegalArgumentException(s"$item")
  }
}
