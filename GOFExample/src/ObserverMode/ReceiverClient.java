package ObserverMode;

public class ReceiverClient {
    public static void main(String[] args) {
        Receiver receiver =new Receiver();
        WeatherData weatherData=new WeatherData(receiver);
        //提供者调用
        weatherData.setData(15,100,30);
        //接收者调用更新
        weatherData.DataChange();
    }
}
