package AdapterMode.simaple;

public class Voltage220 implements IVoltage {
    @Override
    public int output() {
        System.out.println("输出电压220V");
        return 220;
    }

    @Override
    public int input() {
        return 0;
    }
}
