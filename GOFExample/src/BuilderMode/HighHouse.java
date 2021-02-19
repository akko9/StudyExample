package BuilderMode;

public class HighHouse extends AbstractBuilder {
    public HighHouse(House house) {
        super(house);
    }

    @Override
    public void buildGround() {
        System.out.println("建造高楼地基");
    }

    @Override
    public void buildWall() {
        System.out.println("建造高楼墙壁");
    }

    @Override
    public void buildRoof() {
        System.out.println("建造高楼屋顶");
    }
}
