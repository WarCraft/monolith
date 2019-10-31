package gg.warcraft.monolith.api.world.item

trait ItemFactory {
  def create(`type`: ItemType): Item
  def create[T <: ItemVariant](variant: T): VariedItem[T]
}