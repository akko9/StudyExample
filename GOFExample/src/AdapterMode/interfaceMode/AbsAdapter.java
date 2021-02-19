package AdapterMode.interfaceMode;

public abstract class AbsAdapter implements IAdapter {
    @Override
    public IVoltage v5Adapter() {
        return new IVoltage5();
    }

    @Override
    public int v10Adapter() {
        return 0;
    }

    @Override
    public int v20Adapter() {
        return 0;
    }

    @Override
    public int v220Adapter() {
        return 0;
    }
}
