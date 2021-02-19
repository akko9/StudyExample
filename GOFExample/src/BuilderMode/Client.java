package BuilderMode;

public class Client {
    public static void main(String[] args) {
        House house=new House("1","2","3");
        CommonHouse commonHouse = new CommonHouse(house);
        BuildCommander buildCommander = new BuildCommander(commonHouse);
        House house1 = buildCommander.commanderBuild();
        System.out.println(house1);
    }
}
