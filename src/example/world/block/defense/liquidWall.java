package example.world.block.defense;
import mindustry.gen.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.type.*;

public class liquidWall extends Wall {
    public float liquidMultiplier = 1.5f;
    public Liquid liquidType = Liquids.water;
    
    public liquidWall(String name) {
        super(name);
        update = true;
    }
    
    @Override
    public void setStats() {
        super.setStats();
        stats.add(Stat.health, (health * liquidMultiplier), StatUnit.none);
    }
    
    @Override
    public void updateTile() {
        super.updateTile(){
        if (liquidCapacity > 0 && liquids.get(liquidType) > 0) {
            health = baseHealth * liquidMultiplier;
        } else {
            health = baseHealth;
        }
    }
    
    @Override
    public void init() {
        super.init();
        liquidCapacity = 10f;
    }
}
