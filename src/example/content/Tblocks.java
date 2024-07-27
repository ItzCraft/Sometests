package example.content;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import example.world.block.*;

public class Tblocks {
  public static Block testWall;

  public static void load() {
    testWall = new liquidWall("liquid-wall"){{
      requirements(Category.defense, ItemStack.with(Items.copper, 6, Items.lead, 4));
      health = 200;
      size = 2;
    }};
  }
}
