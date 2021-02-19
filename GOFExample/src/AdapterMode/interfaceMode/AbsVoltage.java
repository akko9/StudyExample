package AdapterMode.interfaceMode;

public abstract class AbsVoltage implements IVoltage {
    @Override
    public int output() {
        return 0;
    }

    @Override
    public int input() {
        return 0;
    }
}
