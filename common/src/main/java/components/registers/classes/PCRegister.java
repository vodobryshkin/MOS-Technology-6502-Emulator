package components.registers.classes;

import components.registers.interfaces.Register;
import tools.descriptors.classes.DecToHexDescriptor;

public class PCRegister implements Register {
    private int value;

    public PCRegister() {
        value = 0;
    }

    @Override
    public void setValue(int value) {
        this.value = value + 0x100;
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

    public void increment() {
        if (value == 0xffff) {
            value = 0;
            return;
        }
        value++;
    }
}
