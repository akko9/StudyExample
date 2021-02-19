package AdapterMode.simaple;

public class Client {
    public static void main(String[] args) {
        Phone phone=new Phone();
        Voltage5VAdapter voltage5VAdapter = new Voltage5VAdapter(new Voltage220());
        phone.Recharge(voltage5VAdapter);

    }
}
