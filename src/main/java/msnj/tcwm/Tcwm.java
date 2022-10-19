package msnj.tcwm;

import msnj.tcwm.block.*;
import msnj.tcwm.item.nosource;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.item.*;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import msnj.tcwm.block.*;

public class Tcwm implements ModInitializer {
        public static Tunnel_platform_block TNP = new Tunnel_platform_block();
        public static final Block Marble = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F,5.0F).requiresTool());
        public static final Block WMarble = new Block(FabricBlockSettings.of(Material.STONE).strength(1.3F,5.0F).requiresTool());
        public static final Block METAL = new Block(FabricBlockSettings.of(Material.METAL).strength(4.9F,7.0F).requiresTool().sound(SoundType.METAL));
        public static final Lines_style_1 mangdaoyellow = new Lines_style_1(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).requiresTool());
        public static final Lines_style_2 mangdaoblack = new Lines_style_2(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).requiresTool());
        public static final Block TNL = new Tunnel_cable_block_style_1(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).requiresTool().noOcclusion());
        public static final Block LGO = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0F).resistance(3.0F).luminance(5).requiresTool().noOcclusion());
        public static final Block TNN = new Tunnel_cable_block_style_2(FabricBlockSettings.of(Material.METAL).strength(1.5F,6.0F).requiresTool().noOcclusion());
        public static final Block MLR = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0F).resistance(3.0F).requiresTool().noOcclusion());
        public static final Block mangdaoyellow_SLB = new Lines_style_1_slab(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).requiresTool());
        public static final Block mangdaoblack_SLB = new Lines_style_2_slab(FabricBlockSettings.of(Material.STONE).strength(1.5F, 6.0F).requiresTool());
        public static final Block TNLS = new Tunnel_Light_block(4);
        public static final Block WINDOWS = new Window_block(FabricBlockSettings.of(Material.GLASS).requiresTool().sound(SoundType.GLASS).strength(0.9F, 4.0F).noOcclusion());
        public static final Block WINDOWSPANE = new Window_Pane_Block(DyeColor.BLACK, FabricBlockSettings.of(Material.GLASS).requiresTool().sound(SoundType.GLASS).strength(0.9F, 4.0F).noOcclusion());
        public static final Block SIGNPOLE = new SignPoleBlock(FabricBlockSettings.of(Material.STONE).requiresTool().sound(SoundType.METAL).strength(1F,10F).noOcclusion());
        public static Block DRIVPOSBARS = new Driver_position_bar_block(FabricBlockSettings.of(Material.STONE).requiresTool().sound(SoundType.METAL).strength(1F,10F).noOcclusion());
        public static mtr.block.BlockPlatform PLATFORM = new PlatformBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0F).resistance(3.0F).requiresTool().nonOpaque(), false);
        public static Block SIGN = new SignBlock(FabricBlockSettings.of(Material.STONE).strength(0.9F,3.0F).requiresTool().sound(SoundType.SCULK_SENSOR).noOcclusion());
  public static Block SIGN2 = new SignBlock(FabricBlockSettings.of(Material.STONE).strength(0.9F,3.0F).requiresTool().sound(SoundType.SCULK_SENSOR).noOcclusion());
  public static Block SIGN3 = new SignBlock(FabricBlockSettings.of(Material.STONE).strength(0.9F,3.0F).requiresTool().sound(SoundType.SCULK_SENSOR).noOcclusion());

    public static CreativeModeTab BLO = FabricItemGroupBuilder.build(
            new ResourceLocation("tcwm", "blocks"),
            () -> new ItemStack(LGO));

    public static CreativeModeTab ENT = FabricItemGroupBuilder.create(
                    new ResourceLocation("tcwm", "entitys"))
            .icon(() -> new ItemStack(Items.PLAYER_HEAD))
            .build();
  public static Item NOTFOUND = new nosource(new FabricItemSettings().group(ENT));

    @Override
    public void onInitialize() {
        System.out.println("RCCmod is starting...");
      System.out.println("(TCWM) 音符盒音乐部分将替换为列车关门音");
        //not Found item:
      Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "group_not_found"), NOTFOUND);

        //Logo Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "logo"), LGO);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "logo"), new BlockItem(LGO, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 1");

        //marble 未打磨 Block Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "marble_ore_block"), MLR);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "marble_ore_block"), new BlockItem(MLR, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 2");

        //marble Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "marble"), Marble);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "marble"), new BlockItem(Marble, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 3");

        //白色 marble Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "white_marble"), WMarble);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "white_marble"), new BlockItem(WMarble, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 4");

        //peoplemangdao Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "peoplemangdao"), mangdaoyellow);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "peoplemangdao"), new BlockItem(mangdaoyellow, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 5");

        //黑色 peoplemangdao Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "peoplemangdaoblack"), mangdaoblack);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "peoplemangdaoblack"), new BlockItem(mangdaoblack, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 6");

        //metal Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "metal"), METAL);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "metal"), new BlockItem(METAL, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 7");

        //tunnelline 样式1 Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "tunnelline"), TNL);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "tunnelline"), new BlockItem(TNL, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 8");

        //tunnelline 样式2 Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "tunnellinenoblock"), TNN);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "tunnellinenoblock"), new BlockItem(TNN, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 9");

        //黄色 mangdao slab Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "peoplemangdao_slab"), mangdaoyellow_SLB);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "peoplemangdao_slab"), new BlockItem(mangdaoyellow_SLB, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 10");

        //黑色 mangdao slab Register
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "peoplemangdaoblack_slab"), mangdaoblack_SLB);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "peoplemangdaoblack_slab"), new BlockItem(mangdaoblack_SLB, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 11");

        Registry.register(Registry.ITEM, new ResourceLocation("minecraft", "nether_portal"), new BlockItem(Blocks.NETHER_PORTAL,new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 13");

        Registry.register(Registry.ITEM, new ResourceLocation("minecraft", "end_portal"), new BlockItem(Blocks.END_PORTAL,new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 14");

        //TNL
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "tunnellight"), TNLS);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "tunnellight"), new BlockItem(TNLS, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 15");

        //WINDOWS
        Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "window"), WINDOWS);
        Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "window"), new BlockItem(WINDOWS, new FabricItemSettings().group(BLO)));
        System.out.println("(TCWM) Blocks Loaded of 16");

      //WINDOWSPANE
      Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "windowpane"), WINDOWSPANE);
      Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "windowpane"), new BlockItem(WINDOWSPANE, new FabricItemSettings().group(BLO)));
      System.out.println("(TCWM) Blocks Loaded of 17");

      //SIGNPOLE
      Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "signpole"), SIGNPOLE);
      Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "signpole"), new BlockItem(SIGNPOLE, new FabricItemSettings().group(BLO)));
      System.out.println("(TCWM) Blocks Loaded of 18");

      //BARS
      Registry.register(Registry.BLOCK, new ResourceLocation("tcwm","driverposition_bars"),DRIVPOSBARS);
      Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "driverposition_bars"), new BlockItem(DRIVPOSBARS, new FabricItemSettings().group(BLO)));
      System.out.println("(TCWM) Blocks Loaded of 19");

      //PLATFORM
      Registry.register(Registry.BLOCK, new ResourceLocation("tcwm","platform"),PLATFORM);
      Registry.register(Registry.ITEM, new ResourceLocation("tcwm", "platform"), new BlockItem(PLATFORM, new FabricItemSettings().group(BLO)));
      System.out.println("(TCWM) Blocks Loaded of 20");

      //SIGN
      Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "sign_1"),SIGN);
      Registry.register(Registry.ITEM, new ResourceLocation("tcwm","sign_1"),new BlockItem(SIGN, new FabricItemSettings().group(BLO)));
      Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "sign_2"),SIGN2);
      Registry.register(Registry.ITEM, new ResourceLocation("tcwm","sign_2"),new BlockItem(SIGN2, new FabricItemSettings().group(BLO)));
      Registry.register(Registry.BLOCK, new ResourceLocation("tcwm", "sign_3"),SIGN3);
      Registry.register(Registry.ITEM, new ResourceLocation("tcwm","sign_3"),new BlockItem(SIGN3, new FabricItemSettings().group(BLO)));
      System.out.println("(TCWM) Done.");
    }
}
