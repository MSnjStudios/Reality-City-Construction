package msnj.tcwm.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import javax.swing.text.html.BlockView;
import java.util.List;

public class nosource extends Item {
  public nosource(Properties properties) {
    super(properties);
  }

  @Override
  public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
    super.appendHoverText(itemstack, world, list, flag);
    list.add(new TranslatableComponent("item.tcwm.group_not_found.tooltip"));
  }
}
