package BuilderMode;

public class House {
    private String ground;
    private String wall;
    private String roof;

    public House() {
    }

    public House(String ground, String wall, String roof) {
        this.ground = ground;
        this.wall = wall;
        this.roof = roof;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }
}
