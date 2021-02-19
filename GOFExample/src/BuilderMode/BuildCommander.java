package BuilderMode;

public class BuildCommander {
    private AbstractBuilder abstractBuilder;

    public BuildCommander(AbstractBuilder abstractBuilder) {
        this.abstractBuilder = abstractBuilder;
    }
    public House commanderBuild(){
        abstractBuilder.buildGround();
        abstractBuilder.buildWall();
        abstractBuilder.buildRoof();
        abstractBuilder.buildHouse();
        return abstractBuilder.buildHouse();
    }
}
