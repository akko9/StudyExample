package BuilderMode;

public abstract class AbstractBuilder {
    private House house;

    public AbstractBuilder(House house) {
        this.house=house;
    }


    public abstract void buildGround();

    public abstract void buildWall();

    public abstract void buildRoof();

    public House buildHouse(){
        return  house;
    }
}
