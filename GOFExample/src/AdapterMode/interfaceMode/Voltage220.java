package AdapterMode.interfaceMode;

import AdapterMode.simaple.IVoltage;

public class Voltage220 extends AbsVoltage  {
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
