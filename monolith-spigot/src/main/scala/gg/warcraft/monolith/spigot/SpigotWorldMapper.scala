package gg.warcraft.monolith.spigot

import gg.warcraft.monolith.api.world.World
import org.bukkit.Server
import org.bukkit.World.{Environment => SpigotWorldType}

import scala.jdk.CollectionConverters._

class SpigotWorldMapper(
    private implicit val server: Server
) {
  private val overworld =
    server.getWorlds.asScala.find(_.getEnvironment == SpigotWorldType.NORMAL).get

  private val theNether =
    server.getWorlds.asScala.find(_.getEnvironment == SpigotWorldType.NETHER).get

  private val theEnd =
    server.getWorlds.asScala.find(_.getEnvironment == SpigotWorldType.THE_END).get

  def map(world: SpigotWorld): World = world.getEnvironment match {
    case SpigotWorldType.NORMAL  => World.OVERWORLD
    case SpigotWorldType.NETHER  => World.THE_NETHER
    case SpigotWorldType.THE_END => World.THE_END
  }

  def map(world: World): SpigotWorld = world match {
    case World.OVERWORLD  => overworld
    case World.THE_NETHER => theNether
    case World.THE_END    => theEnd
  }
}