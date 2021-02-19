package AdapterMode.interfaceMode;




public class Client {
    public static void main(String[] args) {
        Phone phone=new Phone();
        phone.Recharge(new Voltage5VAdapter().v5Adapter());

    }
}
