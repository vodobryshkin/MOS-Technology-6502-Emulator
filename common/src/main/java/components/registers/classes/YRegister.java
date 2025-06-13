package components.registers.classes;

import components.registers.interfaces.Register;
import tools.descriptors.classes.DecToHexDescriptor;

public class YRegister implements Register {
    private int value;

    public YRegister() {
        value = 0;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        DecToHexDescriptor decToHexDescriptor = new DecToHexDescriptor();
        decToHexDescriptor.reset();
        decToHexDescriptor.setValue(value);
        return decToHexDescriptor.getHexValue();
    }
}
