package msnj.tcwm.block;

import msnj.tcwm.Tcwm;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.Collections;
import java.util.List;

public class Lines_style_1_slab extends SlabBlock {

    public Lines_style_1_slab(FabricBlockSettings settings) {
        super(settings);
      this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false)
                .setValue(SlabBlock.TYPE, SlabType.BOTTOM));
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, state.getValue(TYPE) == SlabType.DOUBLE ? 2 : 1));
    }

    @Environment(EnvType.CLIENT)
    public static void clientInit() {
        BlockRenderLayerMap.INSTANCE.putBlock(Tcwm.mangdaoyellow_SLB, RenderType.solid());
    }
}
