package msnj.tcwm.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;

public abstract class npc_1_Entity extends net.minecraft.world.entity.npc.Villager{
  public npc_1_Entity(EntityType<? extends Villager> entityType, Level level) {
    super(entityType, level);
  }
}
