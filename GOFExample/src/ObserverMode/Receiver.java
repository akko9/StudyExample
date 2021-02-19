package ObserverMode;

public class Receiver {
    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    private void display() {
        System.out.println("*****温度:"+temperature+"*********");
        System.out.println("*****压力:"+pressure+"*********");
        System.out.println("*****湿度:"+humidity+"*********");
    }

}
