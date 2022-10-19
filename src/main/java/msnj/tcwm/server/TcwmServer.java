package msnj.tcwm.server;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

public class TcwmServer implements DedicatedServerModInitializer {
  @Override
  public void onInitializeServer() {
    System.out.println("(TCWMClient) RCCmod Server Task Loading");
    System.out.println("(TCWMClient) DONE");
  }
}
