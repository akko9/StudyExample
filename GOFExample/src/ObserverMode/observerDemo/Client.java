package ObserverMode.observerDemo;

public class Client {
    public static void main(String[] args) {
        Observer receiver=new Receiver();
        WeatherData weatherData=new WeatherData();
        //注册
        weatherData.register(receiver);
        //更新数据
        weatherData.setData(15,100,30);
        //通知
        weatherData.notifyTarget();

    }
}
