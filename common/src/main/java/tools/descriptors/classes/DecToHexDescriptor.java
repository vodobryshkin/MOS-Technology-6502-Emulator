package tools.descriptors.classes;

import tools.descriptors.interfaces.Descriptor;

public class DecToHexDescriptor implements Descriptor {
    private int decValue = 0;

    @Override
    public void reset() {
        decValue = 0;
    }

    @Override
    public int getIntValue() {
        return decValue;
    }

    @Override
    public String getHexValue() {
        return Integer.toHexString(decValue);
    }

    public void setValue(int decValue) {
        this.decValue = decValue;
    }
}
