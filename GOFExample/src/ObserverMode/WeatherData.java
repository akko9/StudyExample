package ObserverMode;

public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    private Receiver receiver;

    public WeatherData(Receiver receiver) {
       this.receiver = receiver;
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
        receiver.update(this.temperature,this.pressure,this.humidity);
    }

    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}
