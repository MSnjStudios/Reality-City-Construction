package msnj.tcwm.block;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.*;

import javax.swing.text.html.BlockView;
import java.util.Collections;
import java.util.List;

public class Lines_style_1 extends HorizontalDirectionalBlock {
  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public Lines_style_1(FabricBlockSettings settings) {
        super(settings);
      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockGetter world, BlockView view, BlockPos pos, CollisionContext ctx) {
      Vec3 offset = state.getOffset(world, pos);
      switch ((Direction) state.getValue(FACING)) {
        case SOUTH :
        default :
          return box(0, 0, 0, 16, 17, 16).move(offset.x, offset.y, offset.z);
        case NORTH :
          return box(0, 0, 0, 16, 17, 16).move(offset.x, offset.y, offset.z);
        case EAST :
          return box(0, 0, 0, 16, 17, 16).move(offset.x, offset.y, offset.z);
        case WEST :
          return box(0, 0, 0, 16, 17, 16).move(offset.x, offset.y, offset.z);
      }
    }
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  public BlockState rotate(BlockState state, Rotation rot) {
    return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
  }

  public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    ;
    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
  }

  @Override
  public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
    List<ItemStack> dropsOriginal = super.getDrops(state, builder);
    if (!dropsOriginal.isEmpty())
      return dropsOriginal;
    return Collections.singletonList(new ItemStack(Blocks.STONE));
  }
}
