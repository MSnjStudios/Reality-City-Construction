package msnj.tcwm.client;

import msnj.tcwm.Tcwm;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

@Environment(EnvType.CLIENT)
public class TcwmClient implements ClientModInitializer {
  public static final String ModVersion(){
    return "1.0.0-unofficial-5";
  }
    @Override
    public void onInitializeClient() {
      System.out.println("\n(TCWMClient) RCCmod Client Task Loading\nVersion: "+ModVersion());
      BlockRenderLayerMap.INSTANCE.putBlock(Tcwm.WINDOWS, RenderType.cutout());
      System.out.println("(TCWMClient) Blocks Loaded of 16(1)");
      //WINDOWSPANE
      BlockRenderLayerMap.INSTANCE.putBlock(Tcwm.WINDOWSPANE, RenderType.cutout());
      System.out.println("(TCWMClient) Blocks Loaded of 17(2)");
      BlockRenderLayerMap.INSTANCE.putBlock(Tcwm.DRIVPOSBARS, RenderType.cutout());
      System.out.println("(TCWMClient) Blocks Loaded of 19(3)");
      BlockRenderLayerMap.INSTANCE.putBlock(Tcwm.PLATFORM, RenderType.cutout());
      System.out.println("(TCWMClient) Blocks Loaded of 20(4)");
      System.out.println("(TCWMClient) DONE");
    }
}
