package ObserverMode.observerDemo;

import ObserverMode.Receiver;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private float temperature;
    private float pressure;
    private float humidity;
    private Receiver receiver;
    //定义list来注册observer
    private final ArrayList<Observer> observers;
    public WeatherData() {
        observers=new ArrayList<Observer>();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    public void DataChange(){
        notifyTarget();
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        System.out.println("更新成功。。。。。");
    }


    @Override
    public void register(Observer observer) {
        if (!observers.contains(observer)){
            observers.add(observer);
        }

    }

    @Override
    public void remove(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }

    }

    @Override
    public void notifyTarget() {
        for (int i = 0; i <observers.size() ; i++) {
            observers.get(i).update(this.temperature,this.pressure,this.humidity);
        }
    }
}
