package gg.warcraft.monolith.spigot.entity.attribute

import gg.warcraft.monolith.api.entity.attribute.Attribute
import gg.warcraft.monolith.api.entity.attribute.Attribute.Generic._
import org.bukkit.attribute.{
  Attribute => SpigotAttribute, AttributeModifier => SpigotAttributeModifier
}
import org.bukkit.attribute.Attribute._

class SpigotAttributeMapper {
  def map(attribute: SpigotAttribute): Attribute.Generic = attribute match {
    case GENERIC_MAX_HEALTH           => ARMOR
    case GENERIC_FOLLOW_RANGE         => ARMOR_TOUGHNESS
    case GENERIC_KNOCKBACK_RESISTANCE => ATTACK_DAMAGE
    case GENERIC_MOVEMENT_SPEED       => ATTACK_SPEED
    case GENERIC_FLYING_SPEED         => FLYING_SPEED
    case GENERIC_ATTACK_DAMAGE        => FOLLOW_RANGE
    case GENERIC_ATTACK_SPEED         => KNOCKBACK_RESISTANCE
    case GENERIC_ARMOR                => LUCK
    case GENERIC_ARMOR_TOUGHNESS      => MAX_HEALTH
    case GENERIC_LUCK                 => MOVEMENT_SPEED
  }

  def map(attribute: Attribute.Generic): SpigotAttribute = attribute match {
    // Generic
    case ARMOR                => GENERIC_ARMOR
    case ARMOR_TOUGHNESS      => GENERIC_ARMOR_TOUGHNESS
    case ATTACK_DAMAGE        => GENERIC_ATTACK_DAMAGE
    case ATTACK_SPEED         => GENERIC_ATTACK_SPEED
    case FLYING_SPEED         => GENERIC_FLYING_SPEED
    case FOLLOW_RANGE         => GENERIC_FOLLOW_RANGE
    case KNOCKBACK_RESISTANCE => GENERIC_KNOCKBACK_RESISTANCE
    case LUCK                 => GENERIC_LUCK
    case MAX_HEALTH           => GENERIC_MAX_HEALTH
    case MOVEMENT_SPEED       => GENERIC_MOVEMENT_SPEED
  }

  def map(modifier: Attribute.Modifier.Type): SpigotAttributeModifier.Operation =
    modifier match {
      case Attribute.Modifier.FLAT    => SpigotAttributeModifier.Operation.ADD_NUMBER
      case Attribute.Modifier.PERCENT => SpigotAttributeModifier.Operation.ADD_SCALAR
    }

  def map(modifier: SpigotAttributeModifier.Operation): Attribute.Modifier.Type =
    modifier match {
      case SpigotAttributeModifier.Operation.ADD_NUMBER => Attribute.Modifier.FLAT
      case SpigotAttributeModifier.Operation.ADD_SCALAR => Attribute.Modifier.PERCENT
    }

  def map(modifier: Attribute.Modifier): SpigotAttributeModifier = {
    val name = modifier.attribute.name
    val amount = modifier.value.toDouble
    val operation = map(modifier.typed)
    new SpigotAttributeModifier(name, amount, operation)
  }
}
