package AdapterMode.interfaceMode;

public  class IVoltage5 extends AbsVoltage {
    @Override
    public int output() {
        System.out.println("输出电压为5V");
        return 5;
    }
}
