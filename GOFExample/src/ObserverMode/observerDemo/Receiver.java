package ObserverMode.observerDemo;

public class Receiver implements Observer {
    private float temperature;
    private float pressure;
    private float humidity;
    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    private void display() {
        System.out.println("该为接收者一的数据");
        System.out.println("*****温度:"+temperature+"*********");
        System.out.println("*****压力:"+pressure+"*********");
        System.out.println("*****湿度:"+humidity+"*********");
    }
}
