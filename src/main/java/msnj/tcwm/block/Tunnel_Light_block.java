package msnj.tcwm.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Collections;
import java.util.List;

public class Tunnel_Light_block extends Block implements SimpleWaterloggedBlock

{
  public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

  public Tunnel_Light_block(int Lightlevel) {
    super(FabricBlockSettings.of(Material.METAL).sound(SoundType.GLASS).strength(1f, 10f).lightLevel(s -> Lightlevel).noOcclusion()
      .hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).isRedstoneConductor((bs, br, bp) -> false));
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
  }

  @Override
  public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
    super.appendHoverText(itemstack, world, list, flag);
    list.add(new TextComponent("\u4EAE\u5EA6\u7A0D\u5FAE\u5C0F\u4E00\u70B9"));
  }

  @Override
  public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
    return state.getFluidState().isEmpty();
  }

  @Override
  public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
    return 0;
  }

  @Override
  public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
    Vec3 offset = state.getOffset(world, pos);
    switch ((Direction) state.getValue(FACING)) {
      case SOUTH :
      default :
        return box(0, 0, 0, 16, 16, 2).move(offset.x, offset.y, offset.z);
      case NORTH :
        return box(0, 0, 14, 16, 16, 16).move(offset.x, offset.y, offset.z);
      case EAST :
        return box(0, 0, 0, 2, 16, 16).move(offset.x, offset.y, offset.z);
      case WEST :
        return box(14, 0, 0, 16, 16, 16).move(offset.x, offset.y, offset.z);
    }
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    builder.add(FACING, WATERLOGGED);
  }

  public BlockState rotate(BlockState state, Rotation rot) {
    return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
  }

  public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;;
    return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
  }

  @Override
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }

  @Override
  public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos,
                                BlockPos facingPos) {
    if (state.getValue(WATERLOGGED)) {

    }
    return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
  }

  @Override
  public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
    List<ItemStack> dropsOriginal = super.getDrops(state, builder);
    if (!dropsOriginal.isEmpty())
      return dropsOriginal;
    return Collections.singletonList(new ItemStack(Blocks.SEA_LANTERN));
  }



}
