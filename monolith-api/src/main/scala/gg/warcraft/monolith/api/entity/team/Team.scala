package gg.warcraft.monolith.api.entity.team

import gg.warcraft.monolith.api.core.ColorCode
import gg.warcraft.monolith.api.effect.Particle

trait Team {
  val name: String
  val chatColor: ColorCode.Type
  val particleColor: Particle.Color
}