package BuilderMode;

public class CommonHouse extends AbstractBuilder {

    public CommonHouse(House house) {
        super(house);
    }

    @Override
    public void buildGround() {
        System.out.println("建造普通地板");
    }

    @Override
    public void buildWall() {
        System.out.println("建造普通墙壁");
    }

    @Override
    public void buildRoof() {
        System.out.println("建造普通屋顶");
    }
}
