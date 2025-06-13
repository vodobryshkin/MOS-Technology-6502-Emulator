package components.registers.classes;

import components.registers.interfaces.Register;
import tools.descriptors.classes.DecToHexDescriptor;

public class SRegister implements Register {
    private int value;

    public SRegister() {
        value = 0x100;
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
        value++;
    }

    public void decrement() {
        value--;
    }
}
