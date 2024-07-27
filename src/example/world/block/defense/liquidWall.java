package example.world.block.defense;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.type.*;

public class liquidWall extends Wall {
    public float liquidMultiplier = 1.5f; // множитель HP при наличии воды
    public Liquid liquidType = Liquids.water; // тип жидкости, увеличивающей HP
    
    public LiquidWall(String name) {
        super(name);
        update = true; // требуется обновление каждый тик
    }
    
    @Override
    public void setStats() {
        super.setStats();
        stats.add(Stat.health, (health * liquidMultiplier), StatUnit.none);
    }
    
    @Override
    public void updateTile() {
        super.updateTile();
        // если в стене есть вода, увеличить HP
        if (liquidCapacity > 0 && liquids.get(liquidType) > 0) {
            health = baseHealth * liquidMultiplier;
        } else {
            health = baseHealth;
        }
    }
    
    @Override
    public void init() {
        super.init();
        liquidCapacity = 10f; // ёмкость для воды
    }
}
