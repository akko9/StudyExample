package AdapterMode.simaple;

public class Voltage5VAdapter extends IVoltage5 {
    private IVoltage iVoltage;

    public Voltage5VAdapter(IVoltage iVoltage) {
        this.iVoltage = iVoltage;
    }

    @Override
    public int output() {
        int source=iVoltage.output();
        int target=source/44;
        System.out.println("转换电压结束");
        return target;
    }
}
